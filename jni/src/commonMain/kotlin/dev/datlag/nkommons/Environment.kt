package dev.datlag.nkommons

import kotlinx.cinterop.CPointer
import kotlinx.cinterop.CPointerVarOf
import kotlinx.cinterop.ExperimentalForeignApi

@OptIn(ExperimentalForeignApi::class)
typealias JNIEnv = CPointer<JNINativeInterface>

@OptIn(ExperimentalForeignApi::class)
typealias JNIEnvVar = CPointerVarOf<JNIEnv>

@OptIn(ExperimentalForeignApi::class)
typealias C_JNIEnv = CPointer<JNINativeInterface>

@OptIn(ExperimentalForeignApi::class)
typealias C_JNIEnvVar = CPointerVarOf<C_JNIEnv>

@OptIn(ExperimentalForeignApi::class)
typealias JavaVM = CPointer<JNIInvokeInterface>

@OptIn(ExperimentalForeignApi::class)
typealias JavaVMVar = CPointerVarOf<JavaVM>
