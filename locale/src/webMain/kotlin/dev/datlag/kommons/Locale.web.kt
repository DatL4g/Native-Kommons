package dev.datlag.kommons

import kotlinx.browser.window
import kotlin.js.ExperimentalWasmJsInterop
import kotlin.js.JsAny
import kotlin.js.JsString
import kotlin.js.js
import kotlin.js.unsafeCast

@OptIn(ExperimentalWasmJsInterop::class)
@Suppress("UNREACHABLE_CODE")
internal actual fun Locale.Companion.systemDefault(): Locale? {
    fun Any?.asString(): String? {
        return this?.let {
            when (it) {
                is String -> it
                is CharSequence -> it.toString()
                else -> try {
                    (it as JsAny).unsafeCast<JsString>().toString()
                } catch (_: Throwable) {
                    it.toString()
                }
            }
        }?.trim()?.ifBlank { null }?.takeUnless {
            it.equals("null", ignoreCase = true) || it.equals("undefined", ignoreCase = true)
        }
    }

    if (window.exists() && window.navigator.exists()) {
        val language = window.navigator.language
        forLanguageTag(language)?.let {
            return it
        }
    }

    if (process().exists() && processEnv().exists()) {
        val lcAll = environmentProperty(POSIX_ENV_LC_ALL).asString()
        val lang = environmentProperty(POSIX_ENV_LANG).asString()
        val tag = lcAll ?: lang

        tag?.let(::forPosixString)?.let {
            return it
        }
    }

    return null
}

private fun environmentProperty(key: String): Nothing = js("process.env[key]")
private fun process(): Nothing = js("process")
private fun processEnv(): Nothing = js("process.env")

internal expect fun Any?.exists(): Boolean