package dev.datlag.kommons

import java.net.URI
import java.nio.file.Path
import kotlinx.coroutines.CancellationException as CoroutineCancelException
import kotlin.coroutines.cancellation.CancellationException
import kotlin.io.path.Path
import kotlin.io.path.exists

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

    fun openUri(uri: URI): Boolean {
        val os = Platform.os ?: return OperatingSystem.browseUri(uri)

        return os.openUri(uri)
    }

    fun openUri(uri: String): Boolean = openUri(URI.create(uri))

    actual data object Platform {
        internal val os by lazy {
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

    data object Directories {
        private const val PROPERTY_USER_HOME = "user.home"
        private const val ENV_USER_HOME = "HOME"
        private const val PROPERTY_JAVA_HOME = "java.home"
        private const val ENV_JAVA_HOME = "JAVA_HOME"
        private const val PATH_JAVA_SDK_MAN = ".sdkman/candidates/java/current"
        private const val PATH_JAVA_DEFAULT_RUNTIME = "/usr/lib/jvm/default-runtime"
        private const val PATH_JAVA_FALLBACK_RUNTIME = "/usr/lib/jvm/java"
        private const val PROPERTY_TEMP_DIR = "java.io.tmpdir"
        private const val ENV_TEMP_DIR = "TEMP"

        val Home: Path? by lazy {
            resolveDirectory(systemProperty(PROPERTY_USER_HOME))
                ?: resolveDirectory(systemEnv(ENV_USER_HOME))
        }

        val JavaHome: Path? by lazy {
            resolveDirectory(systemProperty(PROPERTY_JAVA_HOME))
                ?: resolveDirectory(systemEnv(ENV_JAVA_HOME))
                ?: Home?.resolve(PATH_JAVA_SDK_MAN)?.ifExists()
                ?: resolveDirectory(PATH_JAVA_DEFAULT_RUNTIME)
                ?: resolveDirectory(PATH_JAVA_FALLBACK_RUNTIME)
        }

        val Temp: Path? by lazy {
            resolveDirectory(systemProperty(PROPERTY_TEMP_DIR))
                ?: resolveDirectory(systemEnv(ENV_TEMP_DIR))
        }

        private fun resolveDirectory(path: String?): Path? {
            if (path.isNullOrBlank()) {
                return null
            }

            return Path(path).ifExists()
        }

        private fun Path.ifExists(): Path? = if (this.exists()) {
            this
        } else {
            null
        }
    }
}