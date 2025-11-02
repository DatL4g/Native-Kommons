package dev.datlag.kommons

import kotlinx.cinterop.ExperimentalForeignApi
import kotlinx.cinterop.allocArray
import kotlinx.cinterop.memScoped
import kotlinx.cinterop.toKString
import platform.posix.getenv
import platform.windows.GetLocaleInfoW
import platform.windows.GetUserDefaultLangID
import platform.windows.GetUserDefaultLocaleName
import platform.windows.LOCALE_NAME_MAX_LENGTH
import platform.windows.LOCALE_SISO3166CTRYNAME
import platform.windows.LOCALE_SISO639LANGNAME
import platform.windows.WCHARVar

@OptIn(ExperimentalForeignApi::class)
internal actual fun Locale.Companion.systemDefault(): Locale? {
    fun systemLocaleFromEnvironment(): Locale? {
        getenv(POSIX_ENV_LC_ALL)?.toKString()?.ifBlank { null }?.let(::forPosixString)?.let {
            return it
        }

        return getenv(POSIX_ENV_LANG)?.toKString()?.ifBlank { null }?.let(::forPosixString)
    }

    fun systemLocaleModern(): Locale? = memScoped {
        val bufferSize = LOCALE_NAME_MAX_LENGTH
        val localeNameBuffer = allocArray<WCHARVar>(bufferSize)
        val length = GetUserDefaultLocaleName(localeNameBuffer, bufferSize)

        return@memScoped if (length > 0) {
            val localeTag = localeNameBuffer.toKString()
            forLanguageTag(localeTag)
        } else {
            null
        }
    }

    fun systemLocaleLegacy(): Locale? = memScoped {
        val langId = GetUserDefaultLangID()
        val langBuffer = allocArray<WCHARVar>(10)
        GetLocaleInfoW(langId.toUInt(), LOCALE_SISO639LANGNAME.toUInt(), langBuffer, 10)

        val language = langBuffer.toKString()
        if (language.isBlank()) {
            return@memScoped null
        }

        val regionBuffer = allocArray<WCHARVar>(10)
        GetLocaleInfoW(langId.toUInt(), LOCALE_SISO3166CTRYNAME.toUInt(), regionBuffer, 10)

        val region = regionBuffer.toKString()
        forLanguageTag("$language-$region")
    }

    return systemLocaleModern() ?: systemLocaleLegacy() ?: systemLocaleFromEnvironment()
}