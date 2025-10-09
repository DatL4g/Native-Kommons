package dev.datlag.nkommons.utils

import dev.datlag.nkommons.JNIEnvVar
import dev.datlag.nkommons.RequiresRelease
import dev.datlag.nkommons.binding.jbooleanVar
import dev.datlag.nkommons.binding.jfloatArray
import dev.datlag.nkommons.binding.jfloatVar
import dev.datlag.nkommons.binding.jint
import dev.datlag.nkommons.binding.jsize
import dev.datlag.nkommons.pointedCommon
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
fun jfloatArray.getFloatElements(env: CPointer<JNIEnvVar>, isCopy: CPointer<jbooleanVar>? = null): CPointer<jfloatVar>? {
    val method = env.pointed.pointedCommon?.GetFloatArrayElements ?: return null
    return method.invoke(env, this, isCopy)
}

@OptIn(ExperimentalForeignApi::class)
fun jfloatArray.releaseElements(env: CPointer<JNIEnvVar>, elements: CPointer<jfloatVar>, mode: jint = 0) {
    val method = env.pointed.pointedCommon?.ReleaseFloatArrayElements
    method?.invoke(env, this, elements, mode)
}

@OptIn(ExperimentalForeignApi::class, RequiresRelease::class)
fun jfloatArray.toKFloatArray(env: CPointer<JNIEnvVar>): FloatArray? {
    val length = this.getLength(env) ?: return null
    val elements = this.getFloatElements(env) ?: return null

    val result = memScoped {
        FloatArray(length) {
            elements[it]
        }
    }

    this.releaseElements(env, elements)
    return result
}

@OptIn(ExperimentalForeignApi::class)
fun CPointer<JNIEnvVar>.newFloatArray(size: jsize): jfloatArray? {
    val method = pointed.pointedCommon?.NewFloatArray ?: return null
    return method.invoke(this, size)
}

@OptIn(ExperimentalForeignApi::class)
fun jfloatArray.fill(env: CPointer<JNIEnvVar>, value: FloatArray): jfloatArray? {
    val method = env.pointed.pointedCommon?.SetFloatArrayRegion ?: return null
    value.usePinned {
        val pointer = it.addressOf(0)
        method.invoke(env, this, 0, value.size, pointer)
    }
    return this
}

@OptIn(ExperimentalForeignApi::class)
fun FloatArray.toJFloatArray(env: CPointer<JNIEnvVar>): jfloatArray? {
    return env.newFloatArray(size)?.fill(env, this)
}