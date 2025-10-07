import dev.datlag.nkommons.binding.jint
import dev.datlag.nkommons.binding.jsize
import io.kotest.core.spec.style.DescribeSpec
import io.kotest.matchers.should
import io.kotest.matchers.shouldBe
import kotlinx.cinterop.ExperimentalForeignApi

@OptIn(ExperimentalForeignApi::class)
class IntTypes : DescribeSpec({
    describe("jint") {
        it("positive") {
            val a: jint = 42
            a shouldBe 42
        }

        it("negative") {
            val b: jint = -10
            b shouldBe -10
        }
    }
    describe("jsize") {
        it("default") {
            val size: jsize = 101
            size shouldBe 101
        }

        it("same as jint") {
            val size: jsize = 33
            val int: jint = 33

            size.should {
                it shouldBe int
                it::class shouldBe int::class
            }
        }
    }
})