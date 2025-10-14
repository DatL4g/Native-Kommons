package dev.datlag.nkommons.utils

import dev.datlag.nkommons.models.Locale
import kotlinx.cinterop.ByteVar
import kotlinx.cinterop.ExperimentalForeignApi
import kotlinx.cinterop.allocArray
import kotlinx.cinterop.memScoped
import kotlinx.cinterop.toKString
import platform.posix.fclose
import platform.posix.fgets
import platform.posix.fopen
import platform.posix.getenv

@OptIn(ExperimentalForeignApi::class)
actual operator fun Locale.Companion.invoke(): Locale? {
    fun systemLocaleFromEnvironment(): Locale? {
        getenv(Locale.POSIX_ENV_LC_ALL)?.toKString()?.ifBlank { null }?.let(::forPosixString)?.let {
            return it
        }

        return getenv(Locale.POSIX_ENV_LANG)?.toKString()?.ifBlank { null }?.let(::forPosixString)
    }

    fun systemLocaleFromConfigFile(): Locale? {
        val filePath = "/etc/locale.conf"
        val file = fopen(filePath, "r") ?: return null

        try {
            memScoped {
                val buffer = allocArray<ByteVar>(1024)
                while (fgets(buffer, 1024, file) != null) {
                    val line = buffer.toKString()

                    if (line.startsWith("LANG=")) {
                        val value = line.substringAfter('=').trim().removeSurrounding("\"").removeSurrounding("\'")
                        return forPosixString(value)
                    }
                }
            }
        } finally {
            fclose(file)
        }

        return null
    }

    return systemLocaleFromEnvironment() ?: systemLocaleFromConfigFile()
}