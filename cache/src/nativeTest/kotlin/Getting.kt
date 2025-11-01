import dev.datlag.kommons.InMemoryCache
import io.kotest.core.spec.style.FunSpec
import io.kotest.matchers.booleans.shouldBeFalse
import io.kotest.matchers.booleans.shouldBeTrue

class Getting : FunSpec({
    test("not empty") {
        val cache = cache()

        cache.put("one", 1)
        cache["two"] = 2

        cache.isEmpty().shouldBeFalse()
        cache.isNotEmpty().shouldBeTrue()
    }
}) {
    companion object {
        private fun cache(maxSize: Int = 0) = InMemoryCache<String, Int>(maxSize.toLong())
    }
}