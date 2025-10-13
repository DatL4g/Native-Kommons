package dev.datlag.nkommons

import dev.datlag.nkommons.binding.jboolean
import dev.datlag.nkommons.binding.jbyte
import dev.datlag.nkommons.binding.jchar
import dev.datlag.nkommons.binding.jdouble
import dev.datlag.nkommons.binding.jfloat
import dev.datlag.nkommons.binding.jint
import dev.datlag.nkommons.binding.jlong
import dev.datlag.nkommons.binding.jobject
import dev.datlag.nkommons.binding.jshort
import kotlinx.cinterop.ExperimentalForeignApi

@OptIn(ExperimentalForeignApi::class)
expect class CommonJValue {
    val platform: jvalue

    var f: jfloat
    var c: jchar
    var d: jdouble
    var b: jbyte
    var j: jlong
    var l: jobject?
    var s: jshort
    var z: jboolean
    var i: jint

    fun asJValue(): jvalue

    companion object {
        operator fun invoke(platform: jvalue): CommonJValue
    }
}