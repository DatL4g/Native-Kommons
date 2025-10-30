package dev.datlag.kommons.binding

import kotlinx.cinterop.ExperimentalForeignApi
import kotlinx.cinterop.FloatVarOf

typealias jfloat = Float

@OptIn(ExperimentalForeignApi::class)
typealias jfloatVar = FloatVarOf<jfloat>

@OptIn(ExperimentalForeignApi::class)
typealias jfloatArray = jarray