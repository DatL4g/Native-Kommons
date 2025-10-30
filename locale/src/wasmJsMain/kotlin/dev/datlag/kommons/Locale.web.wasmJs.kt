package dev.datlag.kommons

@Suppress("UNREACHABLE_CODE")
@OptIn(ExperimentalWasmJsInterop::class)
internal actual fun Any?.exists(): Boolean {
    return this != null && try {
        val obj = this
        val result = isUndefined(this.toJsReference())
        try {
            result.unsafeCast<JsBoolean>().toBoolean()
        } catch (_: Throwable) {
            result as Boolean
        }
    } catch (_: Throwable) {
        false
    }
}

@OptIn(ExperimentalWasmJsInterop::class)
private fun isUndefined(obj: JsAny): Nothing = js("typeof obj !== 'undefined'")