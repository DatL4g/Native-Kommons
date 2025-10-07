package dev.datlag.nkommons

import kotlinx.cinterop.ExperimentalForeignApi

@OptIn(markerClass = [ExperimentalForeignApi::class])
actual typealias JNIInvokeInterface = platform.android.JNIInvokeInterface