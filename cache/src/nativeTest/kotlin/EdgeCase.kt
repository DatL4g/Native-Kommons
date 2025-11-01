import dev.datlag.kommons.InMemoryCache
import io.kotest.core.spec.style.DescribeSpec
import io.kotest.matchers.booleans.shouldBeTrue

class EdgeCase : DescribeSpec({
    describe("high concurrency") {
        it("getOrPut directly") {
            val cache = highConcurrencyCache()

            (0..100000).map(Int::toString).forEach {
                cache.getOrPut(it, it)
            }
            cache.isNotEmpty().shouldBeTrue()
        }
        it("getOrPut create") {
            val cache = highConcurrencyCache()

            (0..100000).map(Int::toString).forEach {
                cache.getOrPut(it) { _ -> it }
            }
            cache.isNotEmpty().shouldBeTrue()
        }
    }

}) {
    companion object {
        private fun highConcurrencyCache(maxSize: Long = 1) = InMemoryCache<String, String>(maxSize)
    }
}