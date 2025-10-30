package dev.datlag.kommons

import dev.datlag.kommons.binding.jint
import kotlinx.cinterop.ExperimentalForeignApi

@OptIn(ExperimentalForeignApi::class)
actual val JNI_COMMIT: jint = jni.JNI_COMMIT

@OptIn(ExperimentalForeignApi::class)
actual val JNI_ABORT: jint = jni.JNI_ABORT