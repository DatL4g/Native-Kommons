package dev.datlag.nkommons.binding

import kotlinx.cinterop.ExperimentalForeignApi
import kotlinx.cinterop.UShortVarOf
import platform.posix.uint16_t

typealias jchar = uint16_t

@OptIn(ExperimentalForeignApi::class)
typealias jcharVar = UShortVarOf<jchar>

@OptIn(ExperimentalForeignApi::class)
typealias jcharArray = jarray

fun jchar.toKChar(): Char {
    return Char(this)
}

fun Char.toJChar(): jchar {
    return this.code.toUShort()
}