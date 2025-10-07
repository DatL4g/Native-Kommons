package dev.datlag.nkommons

import kotlinx.cinterop.ExperimentalForeignApi

@OptIn(markerClass = [ExperimentalForeignApi::class])
actual typealias JavaVMAttachArgs = platform.android.JavaVMAttachArgs