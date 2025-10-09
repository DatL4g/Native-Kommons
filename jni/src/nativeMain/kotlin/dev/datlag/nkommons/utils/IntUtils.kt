package dev.datlag.nkommons.utils

import dev.datlag.nkommons.JNIEnvVar
import dev.datlag.nkommons.RequiresRelease
import dev.datlag.nkommons.binding.jbooleanVar
import dev.datlag.nkommons.binding.jint
import dev.datlag.nkommons.binding.jintArray
import dev.datlag.nkommons.binding.jintVar
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
fun jintArray.getIntElements(env: CPointer<JNIEnvVar>, isCopy: CPointer<jbooleanVar>? = null): CPointer<jintVar>? {
    val method = env.pointed.pointedCommon?.GetIntArrayElements ?: return null
    return method.invoke(env, this, isCopy)
}

@OptIn(ExperimentalForeignApi::class)
fun jintArray.releaseElements(env: CPointer<JNIEnvVar>, elements: CPointer<jintVar>, mode: jint = 0) {
    val method = env.pointed.pointedCommon?.ReleaseIntArrayElements
    method?.invoke(env, this, elements, mode)
}

@OptIn(ExperimentalForeignApi::class, RequiresRelease::class)
fun jintArray.toKIntArray(env: CPointer<JNIEnvVar>): IntArray? {
    val length = this.getLength(env) ?: return null
    val elements = this.getIntElements(env) ?: return null

    val result = memScoped {
        IntArray(length) {
            elements[it]
        }
    }

    this.releaseElements(env, elements)
    return result
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