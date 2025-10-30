package dev.datlag.kommons.utils

import dev.datlag.kommons.JNIEnvVar
import dev.datlag.kommons.RequiresRelease
import dev.datlag.kommons.binding.jboolean
import dev.datlag.kommons.binding.jbooleanArray
import dev.datlag.kommons.binding.jbooleanVar
import dev.datlag.kommons.binding.jint
import dev.datlag.kommons.binding.jsize
import dev.datlag.kommons.pointedCommon
import kotlinx.cinterop.CPointer
import kotlinx.cinterop.ExperimentalForeignApi
import kotlinx.cinterop.addressOf
import kotlinx.cinterop.get
import kotlinx.cinterop.invoke
import kotlinx.cinterop.memScoped
import kotlinx.cinterop.pointed
import kotlinx.cinterop.toBoolean
import kotlinx.cinterop.toByte
import kotlinx.cinterop.usePinned

@OptIn(ExperimentalForeignApi::class)
fun jboolean.toKBoolean(): Boolean {
    return this.toByte().toBoolean()
}

@OptIn(ExperimentalForeignApi::class)
fun Boolean.toJBoolean(): jboolean {
    return this.toByte().toUByte()
}

@RequiresRelease
@OptIn(ExperimentalForeignApi::class)
fun jbooleanArray.getBooleanElements(env: CPointer<JNIEnvVar>, isCopy: CPointer<jbooleanVar>? = null): CPointer<jbooleanVar>? {
    val method = env.pointed.pointedCommon?.GetBooleanArrayElements ?: return null
    return method.invoke(env, this, isCopy)
}

@OptIn(ExperimentalForeignApi::class)
fun jbooleanArray.releaseElements(env: CPointer<JNIEnvVar>, elements: CPointer<jbooleanVar>, mode: jint = 0) {
    val method = env.pointed.pointedCommon?.ReleaseBooleanArrayElements
    method?.invoke(env, this, elements, mode)
}

@OptIn(ExperimentalForeignApi::class, RequiresRelease::class)
fun jbooleanArray.toKBooleanArray(env: CPointer<JNIEnvVar>, isCopy: CPointer<jbooleanVar>? = null): BooleanArray? {
    val length = this.getLength(env) ?: return null
    val elements = this.getBooleanElements(env, isCopy) ?: return null

    val result = memScoped {
        BooleanArray(length) {
            elements[it].toKBoolean()
        }
    }

    this.releaseElements(env, elements)
    return result
}

@OptIn(ExperimentalForeignApi::class)
fun CPointer<JNIEnvVar>.newBooleanArray(size: jsize): jbooleanArray? {
    val method = pointed.pointedCommon?.NewBooleanArray ?: return null
    return method.invoke(this, size)
}

@OptIn(ExperimentalForeignApi::class)
fun jbooleanArray.fill(env: CPointer<JNIEnvVar>, value: BooleanArray): jbooleanArray? {
    val method = env.pointed.pointedCommon?.SetBooleanArrayRegion ?: return null
    val byteArray = UByteArray(value.size) {
        value[it].toJBoolean()
    }
    byteArray.usePinned {
        val pointer = it.addressOf(0)
        method.invoke(env, this, 0, value.size, pointer)
    }
    return this
}

@OptIn(ExperimentalForeignApi::class)
fun BooleanArray.toJBooleanArray(env: CPointer<JNIEnvVar>): jbooleanArray? {
    return env.newBooleanArray(size)?.fill(env, this)
}