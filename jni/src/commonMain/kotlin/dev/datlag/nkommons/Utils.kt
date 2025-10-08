package dev.datlag.nkommons

import dev.datlag.nkommons.binding.jboolean
import dev.datlag.nkommons.binding.jbooleanVar
import dev.datlag.nkommons.binding.jchar
import dev.datlag.nkommons.binding.jintArray
import dev.datlag.nkommons.binding.jsize
import dev.datlag.nkommons.binding.jstring
import kotlinx.cinterop.ByteVar
import kotlinx.cinterop.CPointer
import kotlinx.cinterop.ExperimentalForeignApi
import kotlinx.cinterop.addressOf
import kotlinx.cinterop.invoke
import kotlinx.cinterop.pointed
import kotlinx.cinterop.toBoolean
import kotlinx.cinterop.toByte
import kotlinx.cinterop.toKStringFromUtf8
import kotlinx.cinterop.usePinned

val JNINativeInterface.common
    get() = CommonJNINativeInterface(this)

@OptIn(ExperimentalForeignApi::class)
fun String.toJString(env: CPointer<JNIEnvVar>, encoding: Encoding = Encoding.UTF8): jstring? {
    return with(encoding) {
        this@toJString.toJString(env)
    }
}

@OptIn(ExperimentalForeignApi::class)
fun jstring.toKString(
    env: CPointer<JNIEnvVar>,
    encoding: Encoding = Encoding.UTF8,
    isCopy: CPointer<jbooleanVar>? = null
): String? {
    return with(encoding) {
        this@toKString.toKString(env, isCopy)
    }
}

@OptIn(ExperimentalForeignApi::class)
fun CPointer<JNIEnvVar>.newIntArray(size: jsize): jintArray? {
    val method = pointed.pointedCommon?.NewIntArray ?: return null
    return method.invoke(this, size)
}

@OptIn(ExperimentalForeignApi::class)
fun jintArray.fill(env: CPointer<JNIEnvVar>, value: IntArray): jintArray? {
    val method = env.pointed.pointedCommon?.SetIntArrayRegion ?: return null
    value.usePinned { pinnedArray ->
        val pointer = pinnedArray.addressOf(0)
        method.invoke(env, this, 0, value.size, pointer)
    }
    return this
}

@OptIn(ExperimentalForeignApi::class)
fun IntArray.toJIntArray(env: CPointer<JNIEnvVar>): jintArray? {
    return env.newIntArray(size)?.fill(env, this)
}

@OptIn(ExperimentalForeignApi::class)
fun jboolean.toKBoolean(): Boolean {
    return this.toByte().toBoolean()
}

@OptIn(ExperimentalForeignApi::class)
fun Boolean.toJBoolean(): jboolean {
    return this.toByte().toUByte()
}

@OptIn(ExperimentalForeignApi::class)
fun jchar.toKChar(): Char {
    return Char(this)
}

fun Char.toJChar(): jchar {
    return this.code.toUShort()
}