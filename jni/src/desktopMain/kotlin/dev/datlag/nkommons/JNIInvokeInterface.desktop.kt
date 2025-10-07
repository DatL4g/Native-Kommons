package dev.datlag.nkommons

import kotlinx.cinterop.CStructVar
import kotlinx.cinterop.ExperimentalForeignApi

@OptIn(markerClass = [ExperimentalForeignApi::class])
actual typealias JNIInvokeInterface = jni.JNINativeInterface_