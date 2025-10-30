package dev.datlag.kommons

import dev.datlag.kommons.binding.jint
import kotlinx.cinterop.CFunction
import kotlinx.cinterop.COpaquePointer
import kotlinx.cinterop.COpaquePointerVar
import kotlinx.cinterop.CPointed
import kotlinx.cinterop.CPointer
import kotlinx.cinterop.CPointerVarOf
import kotlinx.cinterop.CStructVar
import kotlinx.cinterop.ExperimentalForeignApi

/**
 * JNIInvokeInterface which can be "implemented" using typealias.
 *
 * AttachCurrentThread and AttachCurrentThreadAsDaemon can't be added here as these differ slightly on android / desktop.
 */
@OptIn(ExperimentalForeignApi::class)
expect class JNIInvokeInterface : CStructVar {

    var reserved1: COpaquePointer?
    var reserved2: COpaquePointer?
    var reserved0: COpaquePointer?
    var DestroyJavaVM: CPointer<CFunction<(CPointer<JavaVMVar>?) -> jint>>?
    var GetEnv: CPointer<CFunction<(CPointer<JavaVMVar>?, CPointer<COpaquePointerVar>?, jint) -> jint>>?
    var DetachCurrentThread: CPointer<CFunction<(CPointer<JavaVMVar>?) -> jint>>?

    @Deprecated("Deprecated in actual type")
    companion object : CStructVar.Type
}