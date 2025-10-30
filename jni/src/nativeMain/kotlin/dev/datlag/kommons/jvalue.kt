package dev.datlag.kommons

import dev.datlag.kommons.binding.jboolean
import dev.datlag.kommons.binding.jbyte
import dev.datlag.kommons.binding.jchar
import dev.datlag.kommons.binding.jdouble
import dev.datlag.kommons.binding.jfloat
import dev.datlag.kommons.binding.jint
import dev.datlag.kommons.binding.jlong
import dev.datlag.kommons.binding.jshort
import kotlinx.cinterop.CStructVar
import kotlinx.cinterop.ExperimentalForeignApi

@OptIn(ExperimentalForeignApi::class)
expect class jvalue : CStructVar {

    var f: jfloat
    var c: jchar
    var d: jdouble
    var b: jbyte
    var j: jlong
    var s: jshort
    var z: jboolean
    var i: jint

    @Deprecated("Deprecated in actual type")
    companion object : CStructVar.Type
}