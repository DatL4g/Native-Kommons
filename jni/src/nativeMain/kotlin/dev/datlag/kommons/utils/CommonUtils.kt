package dev.datlag.kommons.utils

import dev.datlag.kommons.CommonJNINativeInterface
import dev.datlag.kommons.JNIEnvVar
import dev.datlag.kommons.JNINativeInterface
import dev.datlag.kommons.binding.jarray
import dev.datlag.kommons.pointedCommon
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
