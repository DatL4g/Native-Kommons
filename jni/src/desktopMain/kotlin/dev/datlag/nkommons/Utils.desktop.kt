package dev.datlag.nkommons

import dev.datlag.nkommons.binding.jcharVar
import dev.datlag.nkommons.binding.jintArray
import dev.datlag.nkommons.binding.jobject
import dev.datlag.nkommons.binding.jstring
import kotlinx.cinterop.ByteVar
import kotlinx.cinterop.CPointer
import kotlinx.cinterop.ExperimentalForeignApi
import kotlinx.cinterop.addressOf
import kotlinx.cinterop.invoke
import kotlinx.cinterop.pointed
import kotlinx.cinterop.usePinned

@OptIn(ExperimentalForeignApi::class)
actual fun CPointer<JNIEnvVar>.newString(chars: CPointer<jcharVar>, length: Int): jstring? {
    val method = pointed.pointed?.NewString ?: return null
    return method.invoke(this, chars, length)
}

@OptIn(ExperimentalForeignApi::class)
actual fun jstring.getStringUTFChars(env: CPointer<JNIEnvVar>): CPointer<ByteVar>? {
    val method = env.pointed.pointed?.GetStringUTFChars ?: return null
    return method.invoke(env, this.forPlatform(), null)
}

@OptIn(ExperimentalForeignApi::class)
actual fun CPointer<JNIEnvVar>.newIntArray(size: Int): jintArray? {
    val method = pointed.pointed?.NewIntArray ?: return null
    return method.invoke(this, size)
}

@OptIn(ExperimentalForeignApi::class)
actual fun CPointer<JNIEnvVar>.fill(target: jintArray, value: IntArray): jintArray? {
    val method = pointed.pointed?.SetIntArrayRegion ?: return null
    value.usePinned { pinnedArray ->
        val pointer = pinnedArray.addressOf(0)
        method.invoke(this, this.forPlatform(), 0, value.size, pointer)
    }
    return target
}

/**
 * Casts common jobject to jni.jobject
 */
@Suppress("UNCHECKED_CAST")
@OptIn(ExperimentalForeignApi::class)
fun jobject.forPlatform(): jni.jobject {
    return this as jni.jobject
}

/**
 * Casts jni.jobject to common jobject
 */
@OptIn(ExperimentalForeignApi::class)
fun jni.jobject.forCommon(): jobject {
    return this as jobject
}