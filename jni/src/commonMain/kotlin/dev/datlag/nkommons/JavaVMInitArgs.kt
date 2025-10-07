package dev.datlag.nkommons

import dev.datlag.nkommons.binding.jboolean
import dev.datlag.nkommons.binding.jint
import kotlinx.cinterop.CPointer
import kotlinx.cinterop.CStructVar
import kotlinx.cinterop.ExperimentalForeignApi

@OptIn(ExperimentalForeignApi::class)
expect class JavaVMInitArgs : CStructVar {

    var version: jint
    var nOptions: jint
    var options: CPointer<JavaVMOption>?
    var ignoreUnrecognized: jboolean

}