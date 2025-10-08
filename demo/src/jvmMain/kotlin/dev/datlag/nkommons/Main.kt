package dev.datlag.nkommons

import java.io.File

fun main() {
    System.load(File("build/bin/linuxX64/debugShared/libdemo.so").absolutePath.also { println(it) })

    println("Hello World!")
    println(stringExample())
    println(mixed("One", 2, false, intArrayOf(4, 5), '6'))
}

external fun stringExample(): String
external fun mixed(a: String, b: Int, c: Boolean, d: IntArray, e: Char): String