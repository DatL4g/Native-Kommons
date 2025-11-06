package dev.datlag.kommons

import kotlin.coroutines.cancellation.CancellationException
import kotlin.jvm.JvmField
import kotlin.jvm.JvmStatic
import kotlinx.coroutines.CancellationException as CoroutineCancelException

data object Kommons {

    inline fun <T> suspendCatching(block: () -> T): Result<T> = try {
        Result.success(block())
    } catch (e: Throwable) {
        if (e is CancellationException || e is CoroutineCancelException) {
            throw e
        }

        Result.failure(e)
    }

    data object Platform {
        private val current = PlatformIdentifier.current

        // Level 3
        @JvmField
        @JvmStatic
        val isIOS: Boolean = current == PlatformIdentifier.IOS

        @JvmField
        @JvmStatic
        val isTVOS: Boolean = current == PlatformIdentifier.TVOS

        @JvmField
        @JvmStatic
        val isWatchOS: Boolean = current == PlatformIdentifier.WatchOS

        @JvmField
        @JvmStatic
        val isMacOSNative: Boolean = current == PlatformIdentifier.MacOS

        // Level 2
        @JvmField
        @JvmStatic
        val isApple: Boolean = isIOS || isTVOS || isWatchOS || isMacOSNative

        @JvmField
        @JvmStatic
        val isLinuxNative: Boolean = current == PlatformIdentifier.Linux

        @JvmField
        @JvmStatic
        val isWindowsNative: Boolean = current == PlatformIdentifier.MingW

        @JvmField
        @JvmStatic
        val isAndroidNative: Boolean = current == PlatformIdentifier.AndroidNative

        @JvmField
        @JvmStatic
        val isJs: Boolean = current == PlatformIdentifier.JS

        @JvmField
        @JvmStatic
        val isWasmJS: Boolean = current == PlatformIdentifier.WASM_JS

        @JvmField
        @JvmStatic
        val isAndroidJVM: Boolean = current == PlatformIdentifier.Android

        @JvmField
        @JvmStatic
        val isWasmWASI: Boolean = current == PlatformIdentifier.WASM_WASI

        @JvmField
        @JvmStatic
        val isDesktopJVM: Boolean = current == PlatformIdentifier.JVM

        // Level 1
        @JvmField
        @JvmStatic
        val isWeb: Boolean = isJs || current == PlatformIdentifier.WASM_JS

        @JvmField
        @JvmStatic
        val isNative: Boolean = isApple || isLinuxNative || isWindowsNative || isAndroidNative

        @JvmField
        @JvmStatic
        val isAndroid: Boolean = isAndroidJVM || isAndroidNative

        @JvmField
        @JvmStatic
        val isWasm: Boolean = isWasmJS || isWasmWASI

        @JvmField
        @JvmStatic
        val isJVM: Boolean = isAndroidJVM || isDesktopJVM
    }
}