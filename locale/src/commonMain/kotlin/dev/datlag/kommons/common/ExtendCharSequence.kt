package dev.datlag.kommons.common

internal fun Char.isLatinLetter() = this in 'a' .. 'z' || this in 'A' .. 'Z'

internal fun CharSequence.isLatinLetters() = this.all { it.isLatinLetter() }