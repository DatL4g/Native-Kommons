package dev.datlag.nkommons.utils

import dev.datlag.nkommons.CommonJNINativeInterface
import dev.datlag.nkommons.JNIEnvVar
import dev.datlag.nkommons.JNINativeInterface
import dev.datlag.nkommons.binding.jarray
import dev.datlag.nkommons.pointedCommon
import kotlinx.cinterop.CPointer
import kotlinx.cinterop.ExperimentalForeignApi
import kotlinx.cinterop.invoke
import kotlinx.cinterop.pointed

val JNINativeInterface.common
    get() = CommonJNINativeInterface(this)

@OptIn(ExperimentalForeignApi::class)
fun jarray.getLength(env: CPointer<JNIEnvVar>): Int? {
    val method = env.pointed.pointedCommon?.GetArrayLength ?: return null
    return method.invoke(env, this)
}
