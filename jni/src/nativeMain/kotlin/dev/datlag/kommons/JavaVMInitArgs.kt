package dev.datlag.kommons

import dev.datlag.kommons.binding.jboolean
import dev.datlag.kommons.binding.jint
import kotlinx.cinterop.CPointer
import kotlinx.cinterop.CStructVar
import kotlinx.cinterop.ExperimentalForeignApi

@OptIn(ExperimentalForeignApi::class)
expect class JavaVMInitArgs : CStructVar {

    var version: jint
    var nOptions: jint
    var options: CPointer<JavaVMOption>?
    var ignoreUnrecognized: jboolean

    @Deprecated("Deprecated in actual type")
    companion object : CStructVar.Type
}