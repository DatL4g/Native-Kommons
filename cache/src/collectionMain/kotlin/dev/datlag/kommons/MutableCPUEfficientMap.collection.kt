package dev.datlag.kommons

import androidx.collection.mutableScatterMapOf

actual fun <K, V> mutableCPUEfficientMap(): MutableMap<K, V> {
    return mutableScatterMapOf<K, V>().asMutableMap()
}