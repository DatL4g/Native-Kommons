import dev.datlag.nkommons.binding.jbyte
import io.kotest.core.spec.style.DescribeSpec
import io.kotest.matchers.shouldBe

class ByteTypes : DescribeSpec({
    describe("jbyte") {
        it("positive") {
            val a: jbyte = 2

            a shouldBe 2
        }
        it("negative") {
            val a: jbyte = -4

            a shouldBe -4
        }
    }
})