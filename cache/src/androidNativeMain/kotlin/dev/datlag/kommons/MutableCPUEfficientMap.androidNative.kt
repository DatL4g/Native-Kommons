package dev.datlag.kommons

internal actual fun <K, V> mutableCPUEfficientMap(): MutableMap<K, V> {
    return hashMapOf()
}
