package dev.datlag.kommons.utils

import dev.datlag.kommons.CommonJValue
import dev.datlag.kommons.binding.jobject
import dev.datlag.kommons.jvalue
import kotlinx.cinterop.CPointer
import kotlinx.cinterop.ExperimentalForeignApi
import kotlinx.cinterop.MemScope
import kotlinx.cinterop.alloc
import kotlinx.cinterop.ptr

val jvalue.common: CommonJValue
    get() = CommonJValue(this)

@OptIn(ExperimentalForeignApi::class)
fun MemScope.attachToJValue(
    value: jobject?,
    parent: jvalue = alloc<jvalue>(),
): CPointer<jvalue>? {
    if (value == null) {
        return null
    }
    parent.common.l = value

    return parent.ptr
}
