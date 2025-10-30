package dev.datlag.kommons

fun Locale.asJavaLocale() = java.util.Locale.Builder()
    .setLanguage(getLanguage())
    .setRegion(getCountry())
    .setScript(getScript())
    .setVariant(getVariant())
    .build()

operator fun Locale.Companion.invoke(locale: java.util.Locale) = Locale(
    language = locale.language,
    country = locale.country,
    script = locale.script,
    variant = locale.variant
)

actual operator fun Locale.Companion.invoke(): Locale? {
    return invoke(java.util.Locale.getDefault())
}