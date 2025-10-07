import dev.datlag.nkommons.binding.jboolean
import dev.datlag.nkommons.binding.toJBoolean
import dev.datlag.nkommons.binding.toKBoolean
import io.kotest.core.spec.style.DescribeSpec
import io.kotest.matchers.shouldBe
import kotlinx.cinterop.ExperimentalForeignApi
import kotlinx.cinterop.toByte

@OptIn(ExperimentalForeignApi::class)
class BoolTypes : DescribeSpec({
    describe("jboolean") {
        it("positive") {
            val a: jboolean = true.toByte().toUByte()

            a shouldBe 1u
        }
        it("negative") {
            val b: jboolean = false.toByte().toUByte()

            b shouldBe 0u
        }
    }
    describe("utils") {
        it("positive toKBoolean") {
            val a: jboolean = 1u

            a.toKBoolean() shouldBe true
        }
        it("negative toKBoolean") {
            val b: jboolean = 0u

            b.toKBoolean() shouldBe false
        }

        it("positive toJBoolean") {
            val a: Boolean = true

            a.toJBoolean() shouldBe 1u
        }
        it("negative toJBoolean") {
            val b: Boolean = false

            b.toJBoolean() shouldBe 0u
        }
    }
})