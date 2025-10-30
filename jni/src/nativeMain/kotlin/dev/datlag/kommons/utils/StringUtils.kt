package dev.datlag.kommons.utils

import dev.datlag.kommons.Encoding
import dev.datlag.kommons.JNIEnvVar
import dev.datlag.kommons.binding.jbooleanVar
import dev.datlag.kommons.binding.jstring
import kotlinx.cinterop.CPointer
import kotlinx.cinterop.ExperimentalForeignApi

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