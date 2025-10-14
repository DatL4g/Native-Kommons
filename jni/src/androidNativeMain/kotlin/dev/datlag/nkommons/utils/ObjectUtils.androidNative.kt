package dev.datlag.nkommons.utils

import dev.datlag.nkommons.models.Locale
import kotlinx.cinterop.ByteVar
import kotlinx.cinterop.ExperimentalForeignApi
import kotlinx.cinterop.allocArray
import kotlinx.cinterop.memScoped
import kotlinx.cinterop.toKString
import platform.posix.__system_property_get
import platform.posix.getenv
import sysprop.PROP_VALUE_MAX

@OptIn(ExperimentalForeignApi::class)
actual operator fun Locale.Companion.invoke(): Locale? {
    fun systemProperty(key: String): String? = memScoped {
        val buffer = allocArray<ByteVar>(PROP_VALUE_MAX)
        val len = __system_property_get(key, buffer)

        if (len > 0) {
            buffer.toKString().ifBlank { null }
        } else {
            null
        }
    }

    fun systemLocaleFromProperty(): Locale? {
        systemProperty(Locale.ANDROID_PROP_LOCALE)?.let(::forLocaleTag)?.let {
            return it
        }

        val lang = systemProperty(Locale.ANDROID_PROP_LANGUAGE)
        val country = systemProperty(Locale.ANDROID_PROP_COUNTRY)

        return if (!lang.isNullOrBlank()) {
            forLocaleTag("$lang-$country")
        } else {
            null
        }
    }

    fun systemLocaleFromEnvironment(): Locale? {
        getenv(Locale.POSIX_ENV_LC_ALL)?.toKString()?.ifBlank { null }?.let(::forPosixString)?.let {
            return it
        }

        return getenv(Locale.POSIX_ENV_LANG)?.toKString()?.ifBlank { null }?.let(::forPosixString)
    }

    return systemLocaleFromProperty() ?: systemLocaleFromEnvironment()
}