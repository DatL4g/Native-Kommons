package dev.datlag.kommons

import kotlinx.coroutines.CancellationException as CoroutineCancelException
import kotlin.coroutines.cancellation.CancellationException

actual object Kommons {

    actual inline fun <T> suspendCatching(block: () -> T): Result<T> = try {
        Result.success(block())
    } catch (e: Throwable) {
        if (e is CancellationException || e is CoroutineCancelException) {
            throw e
        }

        Result.failure(e)
    }

    actual data object Platform {
        actual val isIOS: Boolean = false
        actual val isTVOS: Boolean = false
        actual val isWatchOS: Boolean = true
        actual val isMacOSNative: Boolean = false
        actual val isApple: Boolean = isIOS || isTVOS || isWatchOS || isMacOSNative
        actual val isLinuxNative: Boolean = false
        actual val isWindowsNative: Boolean = false
        actual val isAndroidNative: Boolean= false
        actual val isJs: Boolean = false
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