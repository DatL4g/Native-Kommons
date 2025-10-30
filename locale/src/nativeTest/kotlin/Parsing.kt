import dev.datlag.kommons.Locale
import io.kotest.core.spec.style.FunSpec
import io.kotest.matchers.equals.shouldBeEqual

class Parsing : FunSpec({
    test("en_US is parsed correctly") {
        val tag = "en_US"
        val result = Locale.forLocaleTag(tag)
        val expected = Locale(language = "en", country = "US")

        result?.shouldBeEqual(expected)
    }

    test("de_DE is parsed correctly") {
        val tag = "de_DE"
        val result = Locale.forLocaleTag(tag)
        val expected = Locale(language = "de", country = "DE")

        result?.shouldBeEqual(expected)
    }

    test("sr-Latn-RS is parsed correctly") {
        val tag = "sr-Latn-RS"
        val result = Locale.forLocaleTag(tag)
        val expected = Locale(language = "sr", country = "RS", script = "Latn")

        result?.shouldBeEqual(expected)
    }
})