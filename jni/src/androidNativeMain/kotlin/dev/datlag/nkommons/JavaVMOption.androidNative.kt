package dev.datlag.kommons

import kotlinx.cinterop.ByteVarOf
import kotlinx.cinterop.CPointed
import kotlinx.cinterop.CPointer
import kotlinx.cinterop.CStructVar
import kotlinx.cinterop.ExperimentalForeignApi

@OptIn(markerClass = [ExperimentalForeignApi::class])
actual typealias JavaVMOption = platform.android.JavaVMOption