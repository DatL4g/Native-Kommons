package dev.datlag.kommons

import platform.Foundation.NSLocale
import platform.Foundation.autoupdatingCurrentLocale
import platform.Foundation.countryCode
import platform.Foundation.languageCode
import platform.Foundation.scriptCode
import platform.Foundation.variantCode

operator fun Locale.Companion.invoke(
    locale: NSLocale
): Locale = Locale(
    language = locale.languageCode,
    country = locale.countryCode?.ifBlank { null },
    script = locale.scriptCode?.ifBlank { null },
    variant = locale.variantCode?.ifBlank { null }
)

actual operator fun Locale.Companion.invoke(): Locale? {
    return invoke(NSLocale.autoupdatingCurrentLocale)
}