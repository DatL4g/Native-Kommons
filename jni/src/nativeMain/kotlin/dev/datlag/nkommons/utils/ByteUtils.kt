package dev.datlag.nkommons.utils

import dev.datlag.nkommons.JNIEnvVar
import dev.datlag.nkommons.RequiresRelease
import dev.datlag.nkommons.binding.jbooleanVar
import dev.datlag.nkommons.binding.jbyteArray
import dev.datlag.nkommons.binding.jbyteVar
import dev.datlag.nkommons.binding.jint
import dev.datlag.nkommons.binding.jsize
import dev.datlag.nkommons.pointedCommon
import kotlinx.cinterop.ByteVar
import kotlinx.cinterop.CPointer
import kotlinx.cinterop.ExperimentalForeignApi
import kotlinx.cinterop.addressOf
import kotlinx.cinterop.get
import kotlinx.cinterop.invoke
import kotlinx.cinterop.memScoped
import kotlinx.cinterop.pointed
import kotlinx.cinterop.usePinned

@OptIn(ExperimentalForeignApi::class)
@RequiresRelease
fun jbyteArray.getByteElements(env: CPointer<JNIEnvVar>, isCopy: CPointer<jbooleanVar>? = null): CPointer<ByteVar>? {
    val method = env.pointed.pointedCommon?.GetByteArrayElements ?: return null
    return method.invoke(env, this, isCopy)
}

@OptIn(ExperimentalForeignApi::class)
fun jbyteArray.releaseElements(env: CPointer<JNIEnvVar>, elements: CPointer<jbyteVar>, mode: jint = 0) {
    val method = env.pointed.pointedCommon?.ReleaseByteArrayElements
    method?.invoke(env, this, elements, mode)
}

@OptIn(ExperimentalForeignApi::class, RequiresRelease::class)
fun jbyteArray.toKByteArray(env: CPointer<JNIEnvVar>): ByteArray? {
    val length = this.getLength(env) ?: return null
    val elements = this.getByteElements(env) ?: return null

    val result = memScoped {
        ByteArray(length) {
            elements[it]
        }
    }

    this.releaseElements(env, elements)
    return result
}

@OptIn(ExperimentalForeignApi::class)
fun CPointer<JNIEnvVar>.newByteArray(size: jsize): jbyteArray? {
    val method = pointed.pointedCommon?.NewByteArray ?: return null
    return method.invoke(this, size)
}

@OptIn(ExperimentalForeignApi::class)
fun jbyteArray.fill(env: CPointer<JNIEnvVar>, value: ByteArray): jbyteArray? {
    val method = env.pointed.pointedCommon?.SetByteArrayRegion ?: return null
    value.usePinned {
        val pointer = it.addressOf(0)
        method.invoke(env, this, 0, value.size, pointer)
    }
    return this
}

@OptIn(ExperimentalForeignApi::class)
fun ByteArray.toJByteArray(env: CPointer<JNIEnvVar>): jbyteArray? {
    return env.newByteArray(size)?.fill(env, this)
}