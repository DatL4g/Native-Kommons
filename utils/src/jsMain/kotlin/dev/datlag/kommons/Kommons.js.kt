package dev.datlag.kommons

import kotlinx.coroutines.CancellationException as CoroutineCancelException
import kotlin.coroutines.cancellation.CancellationException
import kotlin.reflect.KClass

actual object Kommons : Quote {

    actual inline fun <T> suspendCatching(block: () -> T): Result<T> = try {
        Result.success(block())
    } catch (e: Throwable) {
        if (e is CancellationException || e is CoroutineCancelException) {
            throw e
        }

        Result.failure(e)
    }

    @OptIn(ExperimentalWasmJsInterop::class)
    actual infix fun <T : Any> KClass<T>.typeOf(base: KClass<*>): Boolean {
        return this == base || this.js == base.js || run {
            val jsClass = this.js.asDynamic()
            val baseClass = this.js.asDynamic()

            val result = js("jsClass.prototype instanceof baseClass")
            result.unsafeCast<JsBoolean>().toBoolean() || (result as? Boolean == true)
        }
    }

    actual data object Platform {
        actual val isIOS: Boolean = false
        actual val isTVOS: Boolean = false
        actual val isWatchOS: Boolean = false
        actual val isMacOSNative: Boolean = false
        actual val isApple: Boolean = isIOS || isTVOS || isWatchOS || isMacOSNative
        actual val isLinuxNative: Boolean = false
        actual val isWindowsNative: Boolean = false
        actual val isAndroidNative: Boolean = false
        actual val isJs: Boolean = true
        actual val isWasmJS: Boolean = false
        actual val isAndroidJVM: Boolean = false
        actual val isWasmWASI: Boolean = false
        actual val isDesktopJVM: Boolean = false
        actual val isWeb: Boolean = isJs || isWasmJS
        actual val isNative: Boolean = isApple || isLinuxNative || isWindowsNative || isAndroidNative
        actual val isAndroid: Boolean = isAndroidJVM || isAndroidNative
        actual val isWasm: Boolean = isWasmJS || isWasmWASI
        actual val isJVM: Boolean = isDesktopJVM || isAndroidJVM
        actual val isLinux: Boolean = isLinuxNative
        actual val isWindows: Boolean = isWindowsNative
        actual val isMacOS: Boolean = isMacOSNative
    }
}