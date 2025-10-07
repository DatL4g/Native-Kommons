package dev.datlag.nkommons

import dev.datlag.nkommons.binding.jcharVar
import dev.datlag.nkommons.binding.jintArray
import dev.datlag.nkommons.binding.jstring
import kotlinx.cinterop.ByteVar
import kotlinx.cinterop.CPointer
import kotlinx.cinterop.ExperimentalForeignApi
import kotlinx.cinterop.invoke
import kotlinx.cinterop.memScoped
import kotlinx.cinterop.pointed
import kotlinx.cinterop.toKStringFromUtf8
import kotlinx.cinterop.wcstr

@OptIn(ExperimentalForeignApi::class)
fun String.toJstring(env: CPointer<JNIEnvVar>): jstring? = memScoped {
    env.newString(wcstr.ptr, length)
}

@OptIn(ExperimentalForeignApi::class)
expect fun jstring.getStringUTFChars(env: CPointer<JNIEnvVar>): CPointer<ByteVar>?

@OptIn(ExperimentalForeignApi::class)
fun jstring.getString(env: CPointer<JNIEnvVar>): String? {
    val chars = getStringUTFChars(env)
    return chars?.toKStringFromUtf8()
}

@OptIn(ExperimentalForeignApi::class)
expect fun CPointer<JNIEnvVar>.newIntArray(size: Int): jintArray?

@OptIn(ExperimentalForeignApi::class)
expect fun CPointer<JNIEnvVar>.fill(target: jintArray, value: IntArray): jintArray?

@OptIn(ExperimentalForeignApi::class)
fun CPointer<JNIEnvVar>.newString(chars: CPointer<jcharVar>, length: Int): jstring? {
    val method = pointed.pointedCommon?.NewString ?: return null
    return method.invoke(this, chars, length)
}