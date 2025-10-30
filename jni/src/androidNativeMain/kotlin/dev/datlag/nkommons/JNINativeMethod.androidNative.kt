package dev.datlag.kommons

import kotlinx.cinterop.ExperimentalForeignApi

@OptIn(markerClass = [ExperimentalForeignApi::class])
actual typealias JNINativeMethod = platform.android.JNINativeMethod