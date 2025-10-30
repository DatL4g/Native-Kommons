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

@OptIn(markerClass = [ExperimentalForeignApi::class])
actual typealias jvalue = jni.jvalue