package dev.datlag.kommons

import kotlin.jvm.JvmOverloads
import kotlin.jvm.JvmStatic

interface Quote {

    val Char.doubleQuoted
        get() = quote(DOUBLE_QUOTATION)

    val Char.singleQuoted
        get() = quote(SINGLE_QUOTATION)

    val CharSequence.doubleQuoted
        get() = quote(DOUBLE_QUOTATION)

    val CharSequence.singleQuoted
        get() = quote(SINGLE_QUOTATION)

    fun Char.quote(start: Char = DOUBLE_QUOTATION, end: Char = DOUBLE_QUOTATION) = buildString {
        append(start)
        append(this@quote)
        append(end)
    }

    fun CharSequence.quote(start: Char = DOUBLE_QUOTATION, end: Char = DOUBLE_QUOTATION) = buildString {
        append(start)
        for (char in this@quote) {
            when (char) {
                '\\' -> append("\\\\")
                '\n' -> append("\\n")
                '\r' -> append("\\r")
                '\t' -> append("\\t")
                '\"' -> append("\\\"")
                else -> append(char)
            }
        }
        append(end)
    }

    companion object {
        const val DOUBLE_QUOTATION = '"'
        const val SINGLE_QUOTATION = '\''
    }
}