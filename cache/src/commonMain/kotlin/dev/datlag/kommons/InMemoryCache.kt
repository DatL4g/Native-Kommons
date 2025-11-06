package dev.datlag.kommons

import kotlinx.atomicfu.atomic
import kotlinx.coroutines.sync.Mutex
import kotlinx.coroutines.sync.withLock
import kotlin.jvm.JvmField
import kotlin.jvm.JvmStatic
import kotlin.time.Duration
import kotlin.time.TimeMark
import kotlin.time.TimeSource

/**
 * A thread-safe, suspending, in-memory cache with policies for size-based eviction,
 * time-based expiration (after write and after access), and different eviction strategies
 * (LRU, MRU, FIFO, FILO, LFU).
 *
 * All suspending operations are guaranteed to be atomic and thread-safe via a [Mutex].
 * Non-suspending `try...` operations attempt to acquire the lock without blocking and
 * return immediately (e.g., with `null` or a default value) if the lock is contended.
 *
 * This class implements [AutoCloseable] and will attempt to [tryClear] itself upon close.
 *
 * @param K The type of the keys. Must be [Any].
 * @param V The type of the values. Must be [Any].
 * @property maxSize The maximum total weight the cache can hold before entries are evicted.
 */
class InMemoryCache<K : Any, V : Any> private constructor(
    @JvmField val maxSize: Long,
    private val evictionPolicy: EvictionPolicy,
    private val timeSource: TimeSource,
    private val expireAfterWriteDuration: Duration,
    private val expireAfterAccessDuration: Duration,
    private val sizeCalculator: SizeCalculator<K, V>
) : Cache<K, V>, AutoCloseable {

    private val checkWrite = expireAfterWriteDuration.isFinite()
    private val checkAccess = expireAfterAccessDuration.isFinite()

    private val storage = mutableCPUEfficientMap<K, Entry<K, V>>()
    private val lock = Mutex()
    private val atomicSize = atomic(0L)

    private var head: Entry<K, V>? = null
    private var tail: Entry<K, V>? = null

    /**
     * Returns the current total weight of all entries in the cache.
     * This value is thread-safe and accessed atomically.
     */
    override val size: Long
        get() = atomicSize.value

    /**
     * Retrieves the value associated with the given [key], or `null` if the key is not present
     * or the entry has expired.
     *
     * This is a suspending function that safely acquires a lock.
     * Accessing an entry updates its state for time-based expiration (if configured)
     * and eviction policies (e.g., moves to tail for LRU).
     *
     * @param key The key to retrieve.
     * @return The value associated with [key], or `null` if not found or expired.
     */
    override suspend fun get(key: K): V? {
        val now = timeSource.markNow()

        return lock.withLock {
            getWithoutLocking(key, now)
        }
    }

    /**
     * Retrieves the value for the given [key]. If the key is not found or its value is expired,
     * it inserts the provided [value] into the cache and returns it.
     *
     * This is a suspending function that safely acquires a lock.
     *
     * @param key The key to retrieve or put.
     * @param value The value to insert if [key] is not present.
     * @return The existing value for [key] or the new [value] that was just inserted.
     */
    suspend fun getOrPut(key: K, value: V): V {
        val now = timeSource.markNow()

        return lock.withLock {
            getWithoutLocking(key, now)?.let {
                return@withLock it
            }

            putWithoutLocking(key, value, now)
        }
    }

    /**
     * Retrieves the value for the given [key]. If the key is not found or its value is expired,
     * it calls the [block] function to compute a new value, inserts it into the cache,
     * and returns it.
     *
     * If the [block] returns `null`, the key (if it existed) is removed, and `null` is returned.
     *
     * This function ensures that the [block] is computed *outside* the primary cache lock,
     * but the final check and insertion are atomic.
     *
     * @param key The key to retrieve or put.
     * @param block A suspending function to compute the value if it's not present.
     * @return The existing value, the newly computed value, or `null` if the [block] returned `null`.
     */
    suspend fun getOrPut(key: K, block: suspend (key: K) -> V?): V? {
        get(key)?.let {
            return it
        }

        val newValue = block(key)
        val now = timeSource.markNow()

        return lock.withLock {
            val existingValue = getWithoutLocking(key, now)
            if (existingValue != null) {
                return@withLock existingValue
            }

            if (newValue == null) {
                removeWithoutLocking(key)
            } else {
                putWithoutLocking(key, newValue, now)
            }

            return@withLock newValue
        }
    }

    /**
     * Attempts to retrieve the value associated with the given [key] without suspending.
     *
     * This function is non-blocking. If the cache lock is currently held by another coroutine,
     * this function will return `null` immediately instead of waiting.
     *
     * @param key The key to retrieve.
     * @return The value associated with [key], or `null` if not found, expired, or
     * if the cache lock was contended.
     */
    fun tryGet(key: K): V? {
        if (!lock.tryLock()) {
            return null
        }

        val now = timeSource.markNow()
        return try {
            getWithoutLocking(key, now)
        } finally {
            lock.unlock()
        }
    }

    /**
     * Attempts to retrieve the value associated with the given [key] without suspending,
     * returning [defaultValue] if the key is not found, expired, or the lock is contended.
     *
     * @param key The key to retrieve.
     * @param defaultValue The value to return if [tryGet] fails or returns `null`.
     * @return The value from the cache or [defaultValue].
     */
    fun tryGetOrDefault(key: K, defaultValue: V): V {
        return tryGet(key) ?: defaultValue
    }

    private fun getWithoutLocking(key: K, now: TimeMark): V? {
        val entry = storage[key] ?: return null

        if (entry.isExpired()) {
            unlinkEntry(entry)
            storage.remove(entry.key)
            atomicSize.addAndGet(-entry.weight)
            return null
        }

        entry.accessCount++

        if (checkAccess) {
            entry.accessTimeMark = now
        }

        if (evictionPolicy == EvictionPolicy.LRU || evictionPolicy == EvictionPolicy.MRU) {
            moveToTail(entry)
        }

        return entry.value
    }

    /**
     * Inserts or updates the value for the given [key].
     *
     * This is a suspending function that safely acquires a lock.
     * If the new entry (or size difference) exceeds [maxSize], eviction will be triggered.
     * If the single new entry's weight is larger than [maxSize], it will not be added
     * (or it will replace an old entry and then be immediately removed).
     *
     * @param key The key for the entry.
     * @param value The value to be stored.
     */
    override suspend fun put(key: K, value: V) {
        val now = timeSource.markNow()

        lock.withLock {
            putWithoutLocking(key, value, now)
        }
    }

    /**
     * Inserts or updates the value for the given [key] and returns the [value] that was put.
     *
     * This is a suspending function that safely acquires a lock.
     *
     * @param key The key for the entry.
     * @param value The value to be stored.
     * @return The [value] that was just put into the cache.
     */
    override suspend fun putAndGet(key: K, value: V): V {
        val now = timeSource.markNow()

        return lock.withLock {
            putWithoutLocking(key, value, now)
        }
    }

    /**
     * Inserts or updates the value for the given [key] and returns the *previous* value
     * associated with the key, or `null` if the key was not present or was expired.
     *
     * This is a suspending function that safely acquires a lock.
     *
     * @param key The key for the entry.
     * @param value The new value to be stored.
     * @return The previous value, or `null` if none existed or it was expired.
     */
    override suspend fun getAndPut(key: K, value: V): V? {
        val now = timeSource.markNow()

        return lock.withLock {
            val existingEntry = storage[key]
            val oldValue: V?

            if (existingEntry == null) {
                oldValue = null

                val newWeight = sizeCalculator(key, value)
                if (newWeight > maxSize) {
                    return@withLock oldValue
                }

                checkEviction(maxSize - newWeight)

                val newEntry = Entry(key, value, newWeight, now, now)
                storage[key] = newEntry
                linkEntryAtTail(newEntry)
                atomicSize.addAndGet(newWeight)
            } else {
                oldValue = if (existingEntry.isExpired()) {
                    null
                } else {
                    existingEntry.value
                }
                val oldWeight = existingEntry.weight
                val newWeight = sizeCalculator(key, value)

                if (newWeight > maxSize) {
                    removeWithoutLocking(key)
                    return@withLock oldValue
                }

                checkEviction(maxSize - (newWeight - oldWeight))

                existingEntry.value = value
                existingEntry.weight = newWeight
                existingEntry.writeTimeMark = now
                existingEntry.accessTimeMark = now
                existingEntry.accessCount++

                if (evictionPolicy == EvictionPolicy.LRU || evictionPolicy == EvictionPolicy.MRU) {
                    moveToTail(existingEntry)
                }

                atomicSize.addAndGet(newWeight - oldWeight)
            }

            oldValue
        }
    }

    /**
     * Computes a value using the suspending [block] and inserts it for the given [key].
     *
     * If the [block] returns `null`, the key (if it existed) is removed from the cache.
     *
     * This is a suspending function. The [block] is executed *outside* the cache lock,
     * and the insertion is performed atomically after.
     *
     * @param key The key for the entry.
     * @param block A suspending function to compute the new value.
     * @return The newly computed value, or `null` if the [block] returned `null`.
     */
    suspend fun put(key: K, block: suspend (key: K) -> V?): V? {
        val newValue = block(key)
        val now = timeSource.markNow()

        lock.withLock {
            if (newValue == null) {
                removeWithoutLocking(key)
            } else {
                putWithoutLocking(key, newValue, now)
            }
        }
        return newValue
    }

    /**
     * Inserts all key-value pairs from the given [map] into the cache.
     *
     * This is a suspending function that performs all insertions within a single lock.
     * Eviction may be triggered multiple times during this operation.
     *
     * @param map The map of entries to add to the cache.
     */
    suspend fun putAll(map: Map<K, V>) {
        val now = timeSource.markNow()

        lock.withLock {
            map.forEach { (key, value) ->
                putWithoutLocking(key, value, now)
            }
        }
    }

    private fun putWithoutLocking(key: K, value: V, now: TimeMark): V {
        val existingEntry = storage[key]

        if (existingEntry == null) {
            val newWeight = sizeCalculator(key, value)
            if (newWeight > maxSize) {
                return value
            }

            checkEviction(maxSize - newWeight)

            val newEntry = Entry(key, value, newWeight, now, now)
            storage[key] = newEntry
            linkEntryAtTail(newEntry)
            atomicSize.addAndGet(newWeight)
        } else {
            val oldWeight = existingEntry.weight
            val newWeight = sizeCalculator(key, value)

            if (newWeight > maxSize) {
                removeWithoutLocking(key)
                return value
            }

            checkEviction(maxSize - (newWeight - oldWeight))

            existingEntry.value = value
            existingEntry.weight = newWeight
            existingEntry.writeTimeMark = now
            existingEntry.accessTimeMark = now
            existingEntry.accessCount++

            if (evictionPolicy == EvictionPolicy.LRU || evictionPolicy == EvictionPolicy.MRU) {
                moveToTail(existingEntry)
            }

            atomicSize.addAndGet(newWeight - oldWeight)
        }
        return value
    }

    /**
     * Removes the entry for the
     * given [key] and returns the value that was removed.
     *
     * If the key is not found or the entry is expired, it returns `null`.
     *
     * This is a suspending function that safely acquires a lock.
     *
     * @param key The key to remove.
     * @return The value that was removed, or `null` if not found or expired.
     */
    suspend fun remove(key: K): V? {
        return lock.withLock {
            removeWithoutLocking(key)
        }
    }

    /**
     * Attempts to remove the entry for the given [key] without suspending.
     *
     * This function is non-blocking. If the cache lock is currently held by another coroutine,
     * this function will return `null` immediately instead of waiting.
     *
     * @param key The key to remove.
     * @return The value that was removed, or `null` if not found, expired, or
     * if the cache lock was contended.
     */
    fun tryRemove(key: K): V? {
        if (!lock.tryLock()) {
            return null
        }

        return try {
            removeWithoutLocking(key)
        } finally {
            lock.unlock()
        }
    }

    private fun removeWithoutLocking(key: K): V? {
        val entry = storage[key] ?: return null

        unlinkEntry(entry)
        storage.remove(entry.key)
        atomicSize.addAndGet(-entry.weight)

        if (entry.isExpired()) {
            return null
        }

        return entry.value
    }

    /**
     * Removes all entries from the cache.
     *
     * This is a suspending function that safely acquires a lock.
     */
    override suspend fun clear() {
        lock.withLock {
            clearWithoutLocking()
        }
    }

    /**
     * Attempts to remove all entries from the cache without suspending.
     *
     * This function is non-blocking. If the cache lock is currently held by another coroutine,
     * this function will return immediately without clearing the cache.
     */
    fun tryClear() {
        if (!lock.tryLock()) {
            return
        }

        try {
            clearWithoutLocking()
        } finally {
            lock.unlock()
        }
    }

    /**
     * Closes the cache. This is part of the [AutoCloseable] interface.
     * It performs a [tryClear] operation, meaning it will attempt to clear the cache
     * without blocking if the lock is contended.
     */
    override fun close() {
        tryClear()
    }

    private fun clearWithoutLocking() {
        storage.clear()

        head = null
        tail = null

        atomicSize.value = 0L
    }

    /**
     * Manually triggers eviction until the total weight of the cache is at or below [size].
     *
     * This is a suspending function that safely acquires a lock.
     *
     * @param size The target maximum weight to trim the cache down to.
     */
    suspend fun trim(size: Long) {
        lock.withLock {
            checkEviction(size)
        }
    }

    /**
     * Attempts to trigger eviction without suspending until the total weight of the cache
     * is at or below [size].
     *
     * This function is non-blocking. If the cache lock is currently held by another coroutine,
     * this function will return immediately without trimming.
     *
     * @param size The target maximum weight to trim the cache down to.
     */
    fun tryTrim(size: Long) {
        if (!lock.tryLock()) {
            return
        }

        try {
            checkEviction(size)
        } finally {
            lock.unlock()
        }
    }

    /**
     * Returns a thread-safe, immutable snapshot of the cache's valid entries as a [Map].
     * Expired entries will not be included in the map.
     *
     * This is a suspending function that safely acquires a lock to create the snapshot.
     *
     * @return A [Map] containing all non-expired entries in the cache.
     */
    suspend fun asMap(): Map<K, V> {
        return lock.withLock {
            storage.mapValues { (_, value) -> value.value }
        }
    }

    /**
     * Attempts to return a snapshot of the cache's entries as a [Map] without suspending.
     *
     * This function is non-blocking. If the cache lock is currently held by another coroutine,
     * this function will return `null` immediately.
     *
     * @return A [Map] containing all entries, or `null` if the cache lock was contended.
     */
    fun tryAsMap(): Map<K, V>? {
        if (!lock.tryLock()) {
            return null
        }

        return try {
            storage.mapValues { (_, value) -> value.value }
        } finally {
            lock.unlock()
        }
    }

    private fun checkEviction(size: Long = maxSize) {
        if (size <= 0 || atomicSize.value <= size) {
            return
        }

        if (evictionPolicy == EvictionPolicy.LFU) {
            val numToEvict = (atomicSize.value - size).toInt()
            if (numToEvict <= 0) {
                return
            }

            val heap = PriorityQueue<Entry<K, V>>(compareByDescending { it.accessCount })
            for (entry in storage.values) {
                if (heap.size < numToEvict) {
                    heap.offer(entry)
                } else {
                    val maxOfSmallest = heap.peek()?.accessCount ?: DEFAULT_ACCESS_COUNT

                    if (maxOfSmallest == DEFAULT_ACCESS_COUNT) {
                        break
                    }

                    if (entry.accessCount < maxOfSmallest) {
                        heap.poll()
                        heap.offer(entry)
                    }
                }
            }

            var item = heap.poll()
            while (item != null) {
                unlinkEntry(item)
                storage.remove(item.key)
                atomicSize.addAndGet(-item.weight)
                item = heap.poll()
            }
        } else {
            while (atomicSize.value > size) {
                val entryToEvict = when (evictionPolicy) {
                    EvictionPolicy.LRU, EvictionPolicy.FIFO -> head
                    EvictionPolicy.MRU, EvictionPolicy.FILO -> tail
                    EvictionPolicy.LFU -> null
                }

                if (entryToEvict == null) {
                    break
                }

                unlinkEntry(entryToEvict)
                storage.remove(entryToEvict.key)
                atomicSize.addAndGet(-entryToEvict.weight)
            }
        }
    }

    private fun moveToTail(entry: Entry<K, V>) {
        if (entry == tail) {
            return // Already at tail
        }
        unlinkEntry(entry)
        linkEntryAtTail(entry)
    }

    private fun unlinkEntry(entry: Entry<K, V>) {
        val prev = entry.prev
        val next = entry.next

        if (prev != null) {
            prev.next = next
        } else {
            head = next // Was the head
        }

        if (next != null) {
            next.prev = prev
        } else {
            tail = prev // Was the tail
        }

        entry.prev = null
        entry.next = null
    }

    private fun linkEntryAtTail(entry: Entry<K, V>) {
        val oldTail = tail
        entry.prev = oldTail
        entry.next = null // This is the new tail

        if (oldTail != null) {
            oldTail.next = entry
        } else {
            head = entry // List was empty
        }

        tail = entry
    }

    /**
     * A functional interface for calculating the "weight" of a cache entry.
     * The default calculator returns 1 for all entries, making [maxSize] a measure of
     * the maximum *number* of entries.
     *
     * Implement this to define custom sizing, e.g., based on byte size.
     */
    fun interface SizeCalculator<K, V> {
        /**
         * Calculates the weight of a single cache entry.
         * @param key The key of the entry.
         * @param value The value of the entry.
         * @return The weight (e.g., size in bytes, or 1 for count-based) of the entry.
         */
        operator fun invoke(key: K, value: V): Long
    }

    private inner class Entry<K, V>(
        val key: K,
        var value: V,
        var weight: Long,
        var writeTimeMark: TimeMark,
        var accessTimeMark: TimeMark,
        var prev: Entry<K, V>? = null,
        var next: Entry<K, V>? = null,
        var accessCount: Long = DEFAULT_ACCESS_COUNT
    ) {
        private fun writeExpired(): Boolean {
            return if (checkWrite) {
                (writeTimeMark + expireAfterWriteDuration).hasPassedNow()
            } else {
                false
            }
        }

        private fun accessExpired(): Boolean {
            return if (checkAccess) {
                (accessTimeMark + expireAfterAccessDuration).hasPassedNow()
            } else {
                false
            }
        }

        fun isExpired(): Boolean {
            return writeExpired() || accessExpired()
        }
    }

    /**
     * Builder for creating [InMemoryCache] instances with custom configurations.
     *
     * @param K The type of the keys.
     * @param V The type of the values.
     * @param maxSize The maximum total weight the cache can hold. This is a mandatory parameter.
     */
    class Builder<K : Any, V : Any>(@JvmField var maxSize: Long) {

        @JvmField
        var evictionPolicy: EvictionPolicy = EvictionPolicy.LRU

        @JvmField
        var timeSource: TimeSource = TimeSource.Monotonic

        var expireAfterWriteDuration = Duration.INFINITE

        var expireAfterAccessDuration = Duration.INFINITE

        @JvmField
        var sizeCalculator: SizeCalculator<K, V> = SizeCalculator { _, _ -> 1 }

        /**
         * Sets the maximum total weight the cache can hold.
         * Default is set in the constructor.
         */
        fun maxSize(value: Number) = apply {
            maxSize = value.toLong()
        }

        /**
         * Sets the [EvictionPolicy] to use when [maxSize] is exceeded.
         * Default is [EvictionPolicy.LRU].
         */
        fun evictionPolicy(value: EvictionPolicy) = apply {
            evictionPolicy = value
        }

        /**
         * Sets the [TimeSource] used for calculating entry expiration.
         * Default is [TimeSource.Monotonic].
         */
        fun timeSource(value: TimeSource) = apply {
            timeSource = value
        }

        /**
         * Sets the [Duration] after which a cache entry expires since it was last written.
         * Default is [Duration.INFINITE] (no expiration).
         */
        fun expireAfterWrite(duration: Duration) = apply {
            expireAfterWriteDuration = duration
        }

        /**
         * Sets the [Duration] after which a cache entry expires since it was last accessed.
         * Default is [Duration.INFINITE] (no expiration).
         */
        fun expireAfterAccess(duration: Duration) = apply {
            expireAfterAccessDuration = duration
        }

        /**
         * Sets the [SizeCalculator] used to determine the weight of each entry.
         * Default is a calculator that returns 1 for every entry (count-based sizing).
         */
        fun sizeCalculator(value: SizeCalculator<K, V>) = apply {
            sizeCalculator = value
        }

        /**
         * Builds and returns the configured [InMemoryCache] instance.
         */
        fun build() = InMemoryCache<K, V>(
            maxSize = maxSize,
            evictionPolicy = evictionPolicy,
            timeSource = timeSource,
            expireAfterWriteDuration = expireAfterWriteDuration,
            expireAfterAccessDuration = expireAfterAccessDuration,
            sizeCalculator = sizeCalculator
        )
    }

    companion object {
        private const val DEFAULT_ACCESS_COUNT = 1L

        /**
         * Creates an [InMemoryCache] instance using the provided [Builder].
         */
        @JvmStatic
        operator fun <K : Any, V : Any> invoke(builder: Builder<K, V>) = builder.build()

        /**
         * Creates an [InMemoryCache] instance with the given [maxSize] and
         * optional configuration from the [builder] lambda.
         *
         * @param maxSize The maximum total weight (or count) of the cache.
         * @param builder A lambda function to configure the [Builder] instance.
         */
        @JvmStatic
        operator fun <K : Any, V : Any> invoke(
            maxSize: Number,
            builder: Builder<K, V>.() -> Unit = { }
        ) = invoke(Builder<K, V>(maxSize.toLong()).apply(builder))
    }
}