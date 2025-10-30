package dev.datlag.kommons

import dev.datlag.kommons.binding.jboolean
import dev.datlag.kommons.binding.jbyte
import dev.datlag.kommons.binding.jchar
import dev.datlag.kommons.binding.jdouble
import dev.datlag.kommons.binding.jfloat
import dev.datlag.kommons.binding.jint
import dev.datlag.kommons.binding.jlong
import dev.datlag.kommons.binding.jobject
import dev.datlag.kommons.binding.jshort
import dev.datlag.kommons.utils.forCommon
import dev.datlag.kommons.utils.forPlatform
import kotlinx.cinterop.ExperimentalForeignApi

@OptIn(markerClass = [ExperimentalForeignApi::class])
actual class CommonJValue(
    actual val platform: jvalue
) {
    actual var f: jfloat
        get() = platform.f
        set(value) {
            platform.f = value
        }

    actual var c: jchar
        get() = platform.c
        set(value) {
            platform.c = value
        }

    actual var d: jdouble
        get() = platform.d
        set(value) {
            platform.d = value
        }

    actual var b: jbyte
        get() = platform.b
        set(value) {
            platform.b = value
        }

    actual var j: jlong
        get() = platform.j
        set(value) {
            platform.j = value
        }

    actual var l: jobject?
        get() = platform.l?.forCommon()
        set(value) {
            platform.l = value?.forPlatform()
        }

    actual var s: jshort
        get() = platform.s
        set(value) {
            platform.s = value
        }

    actual var z: jboolean
        get() = platform.z
        set(value) {
            platform.z = value
        }

    actual var i: jint
        get() = platform.i
        set(value) {
            platform.i = value
        }

    actual fun asJValue(): jvalue {
        return platform
    }

    actual companion object {
        actual operator fun invoke(platform: jvalue): CommonJValue = CommonJValue(platform)
    }
}