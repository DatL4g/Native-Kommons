package dev.datlag.nkommons.binding

import kotlinx.cinterop.ExperimentalForeignApi
import kotlinx.cinterop.UByteVarOf
import kotlinx.cinterop.toBoolean
import kotlinx.cinterop.toByte
import platform.posix.uint8_t

typealias jboolean = uint8_t

@OptIn(ExperimentalForeignApi::class)
typealias jbooleanVar = UByteVarOf<jboolean>

@OptIn(ExperimentalForeignApi::class)
fun jboolean.toKBoolean(): Boolean {
    return this.toByte().toBoolean()
}

@OptIn(ExperimentalForeignApi::class)
fun Boolean.toJBoolean(): jboolean {
    return this.toByte().toUByte()
}