package dev.datlag.kommons

import dev.datlag.kommons.binding.jint
import kotlinx.cinterop.ByteVar
import kotlinx.cinterop.CPointer
import kotlinx.cinterop.CStructVar
import kotlinx.cinterop.ExperimentalForeignApi

@OptIn(ExperimentalForeignApi::class)
expect class JavaVMAttachArgs : CStructVar {

    var version: jint
    var name: CPointer<ByteVar>?

    @Deprecated("Deprecated in actual type")
    companion object : CStructVar.Type
}