import dev.datlag.nkommons.binding.jchar
import dev.datlag.nkommons.utils.toJChar
import dev.datlag.nkommons.utils.toKChar
import io.kotest.core.spec.style.DescribeSpec
import io.kotest.matchers.shouldBe

class CharTypes : DescribeSpec({
    describe("jchar") {
        it("latin") {
            val a: jchar = 106u

            a shouldBe 'j'.code.toUShort()
        }
        it("hiragana") {
            val e: jchar = 12360u

            e shouldBe 'え'.code.toUShort()
        }
        it("katakana") {
            val fu: jchar = 12501u

            fu shouldBe 'フ'.code.toUShort()
        }
    }
    describe("utils") {
        it("toKChar") {
            val a: jchar = 106u

            a.toKChar() shouldBe 'j'
        }
        it("toJChar") {
            val b: Char = 'j'

            b.toJChar() shouldBe 106u
        }
    }
})