package dev.datlag.nkommons

import java.io.File

fun main() {
    System.load(File("build/bin/linuxX64/debugShared/libdemo.so").absolutePath.also { println(it) })

    println("Hello World!")
    println(nativeHello())
}

external fun nativeHello(): String