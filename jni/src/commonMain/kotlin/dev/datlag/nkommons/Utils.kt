package dev.datlag.nkommons

import dev.datlag.nkommons.binding.jcharVar
import dev.datlag.nkommons.binding.jintArray
import dev.datlag.nkommons.binding.jstring
import kotlinx.cinterop.ByteVar
import kotlinx.cinterop.CPointer
import kotlinx.cinterop.ExperimentalForeignApi
import kotlinx.cinterop.addressOf
import kotlinx.cinterop.invoke
import kotlinx.cinterop.memScoped
import kotlinx.cinterop.pointed
import kotlinx.cinterop.toKStringFromUtf8
import kotlinx.cinterop.usePinned
import kotlinx.cinterop.wcstr

@OptIn(ExperimentalForeignApi::class)
fun CPointer<JNIEnvVar>.newString(chars: CPointer<jcharVar>, length: Int): jstring? {
    val method = pointed.pointedCommon?.NewString ?: return null
    return method.invoke(this, chars, length)
}

@OptIn(ExperimentalForeignApi::class)
fun String.toJstring(env: CPointer<JNIEnvVar>): jstring? = memScoped {
    env.newString(wcstr.ptr, length)
}

@OptIn(ExperimentalForeignApi::class)
fun jstring.getStringUTFChars(env: CPointer<JNIEnvVar>): CPointer<ByteVar>? {
    val method = env.pointed.pointedCommon?.GetStringUTFChars ?: return null
    return method.invoke(env, this, null)
}

@OptIn(ExperimentalForeignApi::class)
fun jstring.toKString(env: CPointer<JNIEnvVar>): String? {
    val chars = getStringUTFChars(env)
    return chars?.toKStringFromUtf8()
}

@OptIn(ExperimentalForeignApi::class)
fun CPointer<JNIEnvVar>.newIntArray(size: Int): jintArray? {
    val method = pointed.pointedCommon?.NewIntArray ?: return null
    return method.invoke(this, size)
}

@OptIn(ExperimentalForeignApi::class)
fun CPointer<JNIEnvVar>.fill(target: jintArray, value: IntArray): jintArray? {
    val method = pointed.pointedCommon?.SetIntArrayRegion ?: return null
    value.usePinned { pinnedArray ->
        val pointer = pinnedArray.addressOf(0)
        method.invoke(this, target, 0, value.size, pointer)
    }
    return target
}