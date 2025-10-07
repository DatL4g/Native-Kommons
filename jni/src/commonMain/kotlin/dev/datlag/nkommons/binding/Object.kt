package dev.datlag.nkommons.binding

import kotlinx.cinterop.COpaquePointer
import kotlinx.cinterop.CPointerVarOf
import kotlinx.cinterop.ExperimentalForeignApi

@OptIn(ExperimentalForeignApi::class)
typealias jobject = COpaquePointer

@OptIn(ExperimentalForeignApi::class)
typealias jobjectVar = CPointerVarOf<jobject>

@OptIn(ExperimentalForeignApi::class)
typealias jarray = jobject

@OptIn(ExperimentalForeignApi::class)
typealias jobjectArray = jarray

@OptIn(ExperimentalForeignApi::class)
typealias jobjectArrayVar = CPointerVarOf<jobjectArray>

@OptIn(ExperimentalForeignApi::class)
typealias jthrowable = jobject

@OptIn(ExperimentalForeignApi::class)
typealias jstring = jobject

@OptIn(ExperimentalForeignApi::class)
typealias jstringVar = CPointerVarOf<jstring>

@OptIn(ExperimentalForeignApi::class)
typealias jweak = jobject

@OptIn(ExperimentalForeignApi::class)
typealias jweakVar = CPointerVarOf<jweak>