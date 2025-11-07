package dev.datlag.kommons

import kotlin.reflect.KClass


expect object NativeKommons : Quote {

    inline fun <T> suspendCatching(block: () -> T): Result<T>
    infix fun <T : Any> KClass<T>.typeOf(base: KClass<*>): Boolean

    object Platform {
        val isIOS: Boolean
        val isTVOS: Boolean
        val isWatchOS: Boolean
        val isMacOSNative: Boolean
        val isApple: Boolean
        val isLinuxNative: Boolean
        val isWindowsNative: Boolean
        val isAndroidNative: Boolean
        val isJs: Boolean
        val isWasmJS: Boolean
        val isAndroidJVM: Boolean
        val isWasmWASI: Boolean
        val isDesktopJVM: Boolean
        val isWeb: Boolean
        val isNative: Boolean
        val isAndroid: Boolean
        val isWasm: Boolean
        val isJVM: Boolean
        val isLinux: Boolean
        val isWindows: Boolean
        val isMacOS: Boolean
    }
}