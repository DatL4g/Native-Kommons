package dev.datlag.kommons

import kotlinx.serialization.Serializable
import kotlin.jvm.JvmField
import kotlin.jvm.JvmOverloads
import kotlin.jvm.JvmStatic

@Serializable
data class Locale @JvmOverloads constructor(
    @JvmField val language: String,
    @JvmField val country: Country?,
    @JvmField val script: String? = null,
    @JvmField val variant: String? = null
) {

    @JvmOverloads
    constructor(
        language: String,
        country: String,
        script: String? = null,
        variant: String? = null
    ) : this(
        language = language,
        country = Country.forCodeOrNull(country),
        script = script,
        variant = variant
    )

    init {
        require(language.isNotBlank()) {
            "Valid language is required"
        }
    }

    override fun toString(): String = buildString {
        append(language.lowercase())

        script?.takeIf { it.isNotBlank() }?.let {
            append('-')
            append(it.replaceFirstChar { char ->
                if (char.isLowerCase()) {
                    char.titlecaseChar()
                } else {
                    char
                }
            })
        }

        country?.codeAlpha2?.toString()?.takeIf { it.isNotBlank() }?.let {
            append('-')
            append(it.uppercase())
        }

        variant?.takeIf { it.isNotBlank() }?.let {
            append('-')
            append(it.uppercase())
        }
    }

    companion object {

        internal const val ANDROID_PROP_LOCALE = "persist.sys.locale"
        internal const val ANDROID_PROP_LANGUAGE = "persist.sys.language"
        internal const val ANDROID_PROP_COUNTRY = "persist.sys.country"
        internal const val POSIX_ENV_LANG = "LANG"
        internal const val POSIX_ENV_LC_ALL = "LC_ALL"

        @JvmStatic
        @JvmOverloads
        fun forLanguageTag(languageTag: String, vararg separators: Char = charArrayOf('_', '-')): Locale? {
            fun String.isAlpha() = all { it.isLetter() }
            fun String.isDigit() = all { it.isDigit() }
            fun String.isAlphaNumeric() = all { it.isLetterOrDigit() }

            if (languageTag.isBlank()) {
                return null
            }

            val parts = languageTag.trim().split(delimiters = separators).filterNot { it.isBlank() }.map { it.trim() }
            if (parts.isEmpty()) {
                return null
            }

            val language = parts.first().takeIf {
                it.isAlpha() && it.length in 2..8
            } ?: return null

            var region: String? = null
            var script: String? = null
            var variant: String? = null

            parts.drop(1).forEach { part ->
                when {
                    script == null && part.length == 4 && part.isAlpha() -> {
                        script = part
                    }
                    region == null && (part.length == 2 && part.isAlpha() || part.length == 3 && part.isDigit()) -> {
                        region = part
                    }
                    (part.length in 5..8 && part.isAlphaNumeric()) || (part.length == 4 && part[0].isDigit()) -> {
                        variant = if (variant == null) part else "$variant-${part}"
                    }
                }
            }

            return Locale(
                language = language,
                country = region?.let(Country::forCodeOrNull),
                script = script,
                variant = variant
            )
        }

        @JvmStatic
        operator fun invoke() = systemDefault()

        internal fun forPosixString(value: String): Locale? {
            val coreTag = value.substringBefore('.').substringBefore('@')
            return forLanguageTag(coreTag)
        }
    }
}

internal expect fun Locale.Companion.systemDefault(): Locale?



