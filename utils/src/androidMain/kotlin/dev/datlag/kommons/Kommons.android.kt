package dev.datlag.kommons

import android.content.Context
import android.content.pm.PackageManager
import android.content.res.Configuration
import android.os.Build
import kotlinx.coroutines.CancellationException as CoroutineCancelException
import kotlin.coroutines.cancellation.CancellationException
import kotlin.reflect.KClass
import kotlin.reflect.full.isSubclassOf

actual object Kommons : Quote {

    actual inline fun <T> suspendCatching(block: () -> T): Result<T> = try {
        Result.success(block())
    } catch (e: Throwable) {
        if (e is CancellationException || e is CoroutineCancelException) {
            throw e
        }

        Result.failure(e)
    }

    actual infix fun <T : Any> KClass<T>.typeOf(base: KClass<*>): Boolean {
        return this == base || this.isSubclassOf(base)
    }

    @JvmStatic
    fun systemProperty(key: String): String? = suspendCatching {
        System.getProperty(key).ifBlank { null }
    }.getOrNull()


    @JvmStatic
    fun systemEnv(key: String): String? = suspendCatching {
        System.getenv(key).ifBlank { null }
    }.getOrNull()


    @JvmStatic
    fun isTelevision(packageManager: PackageManager): Boolean {
        val leanbackOnly = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            packageManager.hasSystemFeature(PackageManager.FEATURE_LEANBACK_ONLY)
        } else {
            false
        }

        return leanbackOnly
                || packageManager.hasSystemFeature(PackageManager.FEATURE_TELEVISION)
                || packageManager.hasSystemFeature(PackageManager.FEATURE_LEANBACK)
    }

    @JvmStatic
    fun isTelevision(configuration: Configuration): Boolean {
        return (configuration.uiMode and Configuration.UI_MODE_TYPE_MASK) == Configuration.UI_MODE_TYPE_TELEVISION
    }

    @JvmStatic
    fun isTelevision(context: Context): Boolean {
        return isTelevision(context.packageManager) || context.resources.configuration?.let(::isTelevision) ?: false
    }

    @JvmStatic
    fun isWatch(packageManager: PackageManager): Boolean {
        return packageManager.hasSystemFeature(PackageManager.FEATURE_WATCH)
    }

    @JvmStatic
    fun isWatch(configuration: Configuration): Boolean {
        return (configuration.uiMode and Configuration.UI_MODE_TYPE_MASK) == Configuration.UI_MODE_TYPE_WATCH
    }

    @JvmStatic
    fun isWatch(context: Context): Boolean {
        return isWatch(context.packageManager) || context.resources.configuration?.let(::isWatch) ?: false
    }

    actual data object Platform {

        @JvmField
        actual val isIOS: Boolean = false

        @JvmField
        actual val isTVOS: Boolean = false

        @JvmField
        actual val isWatchOS: Boolean = false

        @JvmField
        actual val isMacOSNative: Boolean = false

        @JvmField
        actual val isApple: Boolean = isIOS || isTVOS || isWatchOS || isMacOSNative

        @JvmField
        actual val isLinuxNative: Boolean = false

        @JvmField
        actual val isWindowsNative: Boolean = false

        @JvmField
        actual val isAndroidNative: Boolean= false

        @JvmField
        actual val isJs: Boolean = false

        @JvmField
        actual val isWasmJS: Boolean = false

        @JvmField
        actual val isAndroidJVM: Boolean = true

        @JvmField
        actual val isWasmWASI: Boolean = false

        @JvmField
        actual val isDesktopJVM: Boolean = false

        @JvmField
        actual val isWeb: Boolean = isJs || isWasmJS

        @JvmField
        actual val isNative: Boolean = isApple || isLinuxNative || isWindowsNative || isAndroidNative

        @JvmField
        actual val isAndroid: Boolean = isAndroidJVM || isAndroidNative

        @JvmField
        actual val isWasm: Boolean = isWasmJS || isWasmWASI

        @JvmField
        actual val isJVM: Boolean = isDesktopJVM || isAndroidJVM

        @JvmField
        actual val isLinux: Boolean = isLinuxNative

        @JvmField
        actual val isWindows: Boolean = isWindowsNative

        @JvmField
        actual val isMacOS: Boolean = isMacOSNative
    }
}