package dev.datlag.kommons

import kotlinx.cinterop.ExperimentalForeignApi

@OptIn(markerClass = [ExperimentalForeignApi::class])
actual typealias JNIInvokeInterface = platform.android.JNIInvokeInterface