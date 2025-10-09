package dev.datlag.nkommons.utils

import dev.datlag.nkommons.JNIEnvVar
import dev.datlag.nkommons.RequiresRelease
import dev.datlag.nkommons.binding.jbooleanVar
import dev.datlag.nkommons.binding.jchar
import dev.datlag.nkommons.binding.jcharArray
import dev.datlag.nkommons.binding.jcharVar
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
fun jchar.toKChar(): Char {
    return Char(this)
}

fun Char.toJChar(): jchar {
    return this.code.toUShort()
}

@OptIn(ExperimentalForeignApi::class)
@RequiresRelease
fun jcharArray.getCharElements(env: CPointer<JNIEnvVar>, isCopy: CPointer<jbooleanVar>? = null): CPointer<jcharVar>? {
    val method = env.pointed.pointedCommon?.GetCharArrayElements ?: return null
    return method.invoke(env, this, isCopy)
}

@OptIn(ExperimentalForeignApi::class)
fun jcharArray.releaseElements(env: CPointer<JNIEnvVar>, elements: CPointer<jcharVar>, mode: jint = 0) {
    val method = env.pointed.pointedCommon?.ReleaseCharArrayElements
    method?.invoke(env, this, elements, mode)
}

@OptIn(ExperimentalForeignApi::class, RequiresRelease::class)
fun jcharArray.toKCharArray(env: CPointer<JNIEnvVar>, isCopy: CPointer<jbooleanVar>? = null): CharArray? {
    val length = this.getLength(env) ?: return null
    val elements = this.getCharElements(env, isCopy) ?: return null

    val result = memScoped {
        CharArray(length) {
            elements[it].toKChar()
        }
    }

    this.releaseElements(env, elements)
    return result
}

@OptIn(ExperimentalForeignApi::class)
fun CPointer<JNIEnvVar>.newCharArray(size: jsize): jcharArray? {
    val method = pointed.pointedCommon?.NewCharArray ?: return null
    return method.invoke(this, size)
}

@OptIn(ExperimentalForeignApi::class)
fun jcharArray.fill(env: CPointer<JNIEnvVar>, value: CharArray): jcharArray? {
    val method = env.pointed.pointedCommon?.SetCharArrayRegion ?: return null
    val charArray = UShortArray(value.size) {
        value[it].toJChar()
    }
    charArray.usePinned {
        val pointer = it.addressOf(0)
        method.invoke(env, this, 0, value.size, pointer)
    }
    return this
}

@OptIn(ExperimentalForeignApi::class)
fun CharArray.toJCharArray(env: CPointer<JNIEnvVar>): jcharArray? {
    return env.newCharArray(size)?.fill(env, this)
}