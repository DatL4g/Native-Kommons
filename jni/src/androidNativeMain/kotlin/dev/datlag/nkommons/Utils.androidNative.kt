package dev.datlag.nkommons

import dev.datlag.nkommons.binding.jcharVar
import dev.datlag.nkommons.binding.jintArray
import dev.datlag.nkommons.binding.jstring
import kotlinx.cinterop.ByteVar
import kotlinx.cinterop.CPointer
import kotlinx.cinterop.ExperimentalForeignApi
import kotlinx.cinterop.addressOf
import kotlinx.cinterop.invoke
import kotlinx.cinterop.pointed
import kotlinx.cinterop.usePinned

@OptIn(markerClass = [ExperimentalForeignApi::class])
actual fun jstring.getStringUTFChars(env: CPointer<JNIEnvVar>): CPointer<ByteVar>? {
    val method = env.pointed.pointed?.GetStringUTFChars ?: return null
    return method.invoke(env, this, null)
}

@OptIn(markerClass = [ExperimentalForeignApi::class])
actual fun CPointer<JNIEnvVar>.newIntArray(size: Int): jintArray? {
    val method = pointed.pointed?.NewIntArray ?: return null
    return method.invoke(this, size)
}

@OptIn(markerClass = [ExperimentalForeignApi::class])
actual fun CPointer<JNIEnvVar>.fill(
    target: jintArray,
    value: IntArray
): jintArray? {
    val method = pointed.pointed?.SetIntArrayRegion ?: return null
    value.usePinned { pinnedArray ->
        val pointer = pinnedArray.addressOf(0)
        method.invoke(this, target, 0, value.size, pointer)
    }
    return target
}