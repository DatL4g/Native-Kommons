package dev.datlag.kommons

interface Cache<K : Any, V : Any> {

    val size: Long

    suspend operator fun get(key: K): V?

    /**
     * Operator provider for [put] has same logic
     */
    suspend operator fun set(key: K, value: V) = put(key, value)

    suspend fun put(key: K, value: V)
    suspend fun putAndGet(key: K, value: V): V?
    suspend fun getAndPut(key: K, value: V): V?

    suspend fun clear()

    fun isEmpty(): Boolean = size <= 0
    fun isNotEmpty(): Boolean = !isEmpty()
}