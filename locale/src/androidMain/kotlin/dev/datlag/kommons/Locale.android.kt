package dev.datlag.kommons

fun Locale.asJavaLocale() = java.util.Locale.Builder()
    .setLanguage(language)
    .setRegion(country?.codeAlpha2?.toString())
    .setScript(script)
    .setVariant(variant)
    .build()

operator fun Locale.Companion.invoke(locale: java.util.Locale) = Locale(
    language = locale.language,
    country = Country.forCodeOrNull(locale.country),
    script = locale.script,
    variant = locale.variant
)

internal actual fun Locale.Companion.systemDefault(): Locale? {
    return invoke(java.util.Locale.getDefault())
}