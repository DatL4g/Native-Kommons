package dev.datlag.kommons

import java.awt.Desktop
import java.net.URI
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

    fun systemProperty(key: String): String? = suspendCatching {
        System.getProperty(key).ifBlank { null }
    }.getOrNull()

    fun systemEnv(key: String): String? = suspendCatching {
        System.getenv(key).ifBlank { null }
    }.getOrNull()

    fun openUri(uri: String): Boolean {
        val os = Platform.os ?: return when {
            Desktop.isDesktopSupported() && Desktop.getDesktop().isSupported(Desktop.Action.BROWSE) -> {
                Desktop.getDesktop().browse(URI.create(uri))
                true
            }
            else -> false
        }

        return os.openUri(uri)
    }

    actual data object Platform {
        internal val os by lazy(LazyThreadSafetyMode.NONE) {
            OperatingSystem.matching()
        }

        actual val isIOS: Boolean = false
        actual val isTVOS: Boolean = false
        actual val isWatchOS: Boolean = false
        actual val isMacOSNative: Boolean = false
        actual val isApple: Boolean = isIOS || isTVOS || isWatchOS || isMacOSNative
        actual val isLinuxNative: Boolean = false
        actual val isWindowsNative: Boolean = false
        actual val isAndroidNative: Boolean = false
        actual val isJs: Boolean = false
        actual val isWasmJS: Boolean = false
        actual val isAndroidJVM: Boolean = false
        actual val isWasmWASI: Boolean = false
        actual val isDesktopJVM: Boolean = true
        actual val isWeb: Boolean = isJs || isWasmJS
        actual val isNative: Boolean = isApple || isLinuxNative || isWindowsNative || isAndroidNative
        actual val isAndroid: Boolean = isAndroidJVM || isAndroidNative
        actual val isWasm: Boolean = isWasmJS || isWasmWASI
        actual val isJVM: Boolean = isDesktopJVM || isAndroidJVM
        actual val isLinux: Boolean by lazy {
            isLinuxNative || os?.isLinux ?: false
        }
        actual val isWindows: Boolean by lazy {
            isWindowsNative || os?.isWindows ?: false
        }
        actual val isMacOS: Boolean by lazy {
            isMacOSNative || os?.isMacOS ?: false
        }
    }
}