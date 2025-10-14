package dev.datlag.nkommons.utils

import dev.datlag.nkommons.CommonJValue
import dev.datlag.nkommons.binding.jobject
import dev.datlag.nkommons.jvalue
import dev.datlag.nkommons.models.Locale
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

expect operator fun Locale.Companion.invoke(): Locale?