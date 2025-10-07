package dev.datlag.nkommons

import kotlinx.cinterop.CPointer
import kotlinx.cinterop.CPointerVarOf
import kotlinx.cinterop.ExperimentalForeignApi
import kotlinx.cinterop.pointed

@OptIn(ExperimentalForeignApi::class)
typealias JNIEnv = CPointer<JNINativeInterface>

@OptIn(ExperimentalForeignApi::class)
val JNIEnv.pointedCommon: CommonJNINativeInterface
    get() = CommonJNINativeInterface(pointed)

@OptIn(ExperimentalForeignApi::class)
typealias JNIEnvVar = CPointerVarOf<JNIEnv>

@OptIn(ExperimentalForeignApi::class)
val JNIEnvVar.pointedCommon: CommonJNINativeInterface?
    get() = pointed?.let(CommonJNINativeInterface::invoke)

@OptIn(ExperimentalForeignApi::class)
typealias C_JNIEnv = CPointer<JNINativeInterface>

@OptIn(ExperimentalForeignApi::class)
typealias C_JNIEnvVar = CPointerVarOf<C_JNIEnv>

@OptIn(ExperimentalForeignApi::class)
typealias JavaVM = CPointer<JNIInvokeInterface>

@OptIn(ExperimentalForeignApi::class)
typealias JavaVMVar = CPointerVarOf<JavaVM>
