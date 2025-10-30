package dev.datlag.kommons

internal actual fun Any?.exists(): Boolean {
    return this != null && !jsTypeOf(this).equals("undefined", ignoreCase = true)
}