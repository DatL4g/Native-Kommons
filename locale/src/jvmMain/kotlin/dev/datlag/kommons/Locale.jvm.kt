package dev.datlag.kommons

fun Locale.asJavaLocale() = java.util.Locale.Builder()
    .setLanguage(getLanguage())
    .setRegion(getCountry()?.codeAlpha2?.toString())
    .setScript(getScript())
    .setVariant(getVariant())
    .build()

operator fun Locale.Companion.invoke(locale: java.util.Locale) = Locale(
    language = locale.language,
    country = Country.forCodeOrNull(locale.country),
    script = locale.script,
    variant = locale.variant
)

actual operator fun Locale.Companion.invoke(): Locale? {
    return invoke(java.util.Locale.getDefault())
}