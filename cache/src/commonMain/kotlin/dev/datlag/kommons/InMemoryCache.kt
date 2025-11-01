package dev.datlag.kommons

import kotlinx.atomicfu.atomic
import kotlinx.coroutines.sync.Mutex
import kotlinx.coroutines.sync.withLock
import kotlin.jvm.JvmOverloads
import kotlin.time.Duration
import kotlin.time.TimeMark
import kotlin.time.TimeSource

class InMemoryCache<K : Any, V : Any> @JvmOverloads constructor(
    val maxSize: Long,
    private val evictionPolicy: EvictionPolicy = EvictionPolicy.LRU,
    private val timeSource: TimeSource = TimeSource.Monotonic,
    private val expireAfterWriteDuration: Duration = Duration.INFINITE,
    private val expireAfterAccessDuration: Duration = Duration.INFINITE
) : Cache<K, V>, AutoCloseable {

    private val checkWrite = expireAfterWriteDuration.isFinite()
    private val checkAccess = expireAfterAccessDuration.isFinite()

    private val storage = mutableCPUEfficientMap<K, Entry<K, V>>()
    private val lock = Mutex()
    private val atomicSize = atomic(0L)

    private var head: Entry<K, V>? = null
    private var tail: Entry<K, V>? = null

    override val size: Long
        get() = atomicSize.value

    override suspend fun get(key: K): V? {
        val now = timeSource.markNow()

        return lock.withLock {
            getWithoutLocking(key, now)
        }
    }

    suspend fun getOrPut(key: K, value: V): V {
        val now = timeSource.markNow()

        return lock.withLock {
            getWithoutLocking(key, now)?.let {
                return@withLock it
            }

            putWithoutLocking(key, value, now)
        }
    }

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

    fun tryGet(key: K): V? {
        if (!lock.tryLock()) {
            val existing = try {
                storage[key]
            } catch (_: Throwable) { null } ?: return null

            if (existing.isExpired()) {
                return null
            }
            return existing.value
        }

        val now = timeSource.markNow()
        return try {
            getWithoutLocking(key, now)
        } finally {
            lock.unlock()
        }
    }

    fun tryGetOrDefault(key: K, defaultValue: V): V {
        return tryGet(key) ?: defaultValue
    }

    private fun getWithoutLocking(key: K, now: TimeMark): V? {
        val entry = storage[key] ?: return null

        if (entry.isExpired()) {
            unlinkEntry(entry)
            storage.remove(entry.key)
            atomicSize.getAndDecrement()
            return null
        }

        if (checkAccess) {
            entry.accessTimeMark = now
        }

        if (evictionPolicy == EvictionPolicy.LRU || evictionPolicy == EvictionPolicy.MRU) {
            moveToTail(entry)
        }

        return entry.value
    }

    override suspend fun put(key: K, value: V) {
        val now = timeSource.markNow()

        lock.withLock {
            putWithoutLocking(key, value, now)
        }
    }

    override suspend fun putAndGet(key: K, value: V): V {
        val now = timeSource.markNow()

        return lock.withLock {
            putWithoutLocking(key, value, now)
        }
    }

    override suspend fun getAndPut(key: K, value: V): V? {
        val now = timeSource.markNow()

        return lock.withLock {
            val existingEntry = storage[key]
            val oldValue: V?

            if (existingEntry == null) {
                oldValue = null

                checkEviction()

                val newEntry = Entry(key, value, now, now)
                storage[key] = newEntry
                linkEntryAtTail(newEntry)
                atomicSize.getAndIncrement()
            } else {
                oldValue = if (existingEntry.isExpired()) {
                    null
                } else {
                    existingEntry.value
                }

                existingEntry.value = value
                existingEntry.writeTimeMark = now
                existingEntry.accessTimeMark = now

                if (evictionPolicy == EvictionPolicy.LRU || evictionPolicy == EvictionPolicy.MRU) {
                    moveToTail(existingEntry)
                }
            }

            oldValue
        }
    }

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

    private fun putWithoutLocking(key: K, value: V, now: TimeMark): V {
        val existingEntry = storage[key]

        if (existingEntry == null) {
            checkEviction()

            val newEntry = Entry(key, value, now, now)
            storage[key] = newEntry
            linkEntryAtTail(newEntry)
            atomicSize.getAndIncrement()
        } else {
            existingEntry.value = value
            existingEntry.writeTimeMark = now
            existingEntry.accessTimeMark = now

            if (evictionPolicy == EvictionPolicy.LRU || evictionPolicy == EvictionPolicy.MRU) {
                moveToTail(existingEntry)
            }
        }
        return value
    }

    suspend fun remove(key: K): V? {
        return lock.withLock {
            removeWithoutLocking(key)
        }
    }

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
        atomicSize.getAndDecrement()

        if (entry.isExpired()) {
            return null
        }

        return entry.value
    }

    override suspend fun clear() {
        lock.withLock {
            clearWithoutLocking()
        }
    }

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

    override fun close() {
        tryClear()
    }

    private fun clearWithoutLocking() {
        storage.clear()

        head = null
        tail = null

        atomicSize.value = 0L
    }

    suspend fun trim(size: Long) {
        lock.withLock {
            checkEviction(size)
        }
    }

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

    private fun checkEviction(size: Long = maxSize) {
        if (size <= 0) {
            return
        }

        while (atomicSize.value >= size) {
            val entryToEvict = when (evictionPolicy) {
                EvictionPolicy.LRU, EvictionPolicy.FIFO -> head
                EvictionPolicy.MRU, EvictionPolicy.FILO -> tail
            }

            if (entryToEvict == null) {
                break
            }

            unlinkEntry(entryToEvict)
            storage.remove(entryToEvict.key)
            atomicSize.getAndDecrement()
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

    private inner class Entry<K, V>(
        val key: K,
        var value: V,
        var writeTimeMark: TimeMark,
        var accessTimeMark: TimeMark,
        var prev: Entry<K, V>? = null,
        var next: Entry<K, V>? = null
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
}