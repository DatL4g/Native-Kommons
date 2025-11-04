package benchmark

import com.mayakapps.kache.InMemoryKache
import com.mayakapps.kache.KacheStrategy
import dev.datlag.kommons.EvictionPolicy
import dev.datlag.kommons.InMemoryCache
import io.github.reactivecircus.cache4k.Cache
import kotlinx.benchmark.Benchmark
import kotlinx.benchmark.BenchmarkMode
import kotlinx.benchmark.Blackhole
import kotlinx.benchmark.Measurement
import kotlinx.benchmark.Mode
import kotlinx.benchmark.OutputTimeUnit
import kotlinx.benchmark.Param
import kotlinx.benchmark.Scope
import kotlinx.benchmark.Setup
import kotlinx.benchmark.State
import kotlinx.benchmark.TearDown
import kotlinx.benchmark.Warmup
import kotlinx.coroutines.runBlocking
import java.util.concurrent.TimeUnit

@State(Scope.Benchmark)
@Warmup(iterations = 5, time = 1, timeUnit = TimeUnit.SECONDS)
@Measurement(iterations = 5, time = 1, timeUnit = TimeUnit.SECONDS)
@BenchmarkMode(Mode.AverageTime)
@OutputTimeUnit(TimeUnit.NANOSECONDS)
class InMemoryBenchmark {

    @Param("100", "1000", "10000")
    var size: Int = 0

    private lateinit var keys: List<Int>
    private lateinit var myCache: InMemoryCache<Int, String>
    private lateinit var kache: InMemoryKache<Int, String>
    private lateinit var cache4k: Cache<Int, String>

    @Setup
    fun setup() = runBlocking {
        myCache = InMemoryCache(
            maxSize = size.toLong(),
            evictionPolicy = EvictionPolicy.LRU
        )
        kache = InMemoryKache(
            maxSize = size.toLong()
        ) {
            strategy = KacheStrategy.LRU
        }
        cache4k = Cache.Builder<Int, String>().maximumCacheSize(size.toLong()).build()

        val keysToPopulate = (0 until (size / 2)).toList()
        for (key in keysToPopulate) {
            val value = "Value$key"
            myCache.put(key, value)
            kache.put(key, value)
            cache4k.put(key, value)
        }

        keys = (0 until size).shuffled()
    }

    @TearDown
    fun cleanup() = runBlocking {
        myCache.clear()
    }

    // --- READ --- //

    @Benchmark
    fun getMyCache(bh: Blackhole) {
        val key = keys.random()
        val value = myCache.tryGet(key)
        bh.consume(value)
    }

    @Benchmark
    fun getKache(bh: Blackhole) {
        val key = keys.random()
        val value = kache.getIfAvailable(key)
        bh.consume(value)
    }

    @Benchmark
    fun getCache4K(bh: Blackhole) {
        val key = keys.random()
        val value = cache4k.get(key)
        bh.consume(value)
    }

    // --- WRITE --- //

    @Benchmark
    fun putMyCacheSuspending() = runBlocking {
        myCache.put(keys.random(), "newValue")
    }

    @Benchmark
    fun putKacheSuspending() = runBlocking {
        kache.put(keys.random(), "newValue")
    }
}