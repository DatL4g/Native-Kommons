package dev.datlag.nkommons.utils

import dev.datlag.nkommons.models.Locale
import platform.Foundation.NSLocale
import platform.Foundation.countryCode
import platform.Foundation.autoupdatingCurrentLocale
import platform.Foundation.languageCode
import platform.Foundation.variantCode

actual operator fun Locale.Companion.invoke(): Locale? {
    val locale = NSLocale.autoupdatingCurrentLocale
    return Locale(
        language = locale.languageCode,
        region = locale.countryCode.ifBlank { null },
        variant = locale.variantCode.ifBlank { null }
    )
}