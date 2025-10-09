package dev.datlag.nkommons.utils

import dev.datlag.nkommons.Encoding
import dev.datlag.nkommons.JNIEnvVar
import dev.datlag.nkommons.binding.jbooleanVar
import dev.datlag.nkommons.binding.jstring
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