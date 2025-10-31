import dev.datlag.kommons.Continent
import io.kotest.core.spec.style.DescribeSpec
import io.kotest.matchers.equals.shouldBeEqual
import io.kotest.matchers.nulls.shouldNotBeNull

class ContinentParsing : DescribeSpec({
    describe("africa is parsed correctly") {
        it("geoname") {
            val tag = "AF"
            val result = Continent.forCodeOrNull(tag)

            result.shouldNotBeNull()
            Continent.Africa.shouldBeEqual(result)
        }
        it("stanag") {
            val tag = "FFF"
            val result = Continent.forCodeOrNull(tag)

            result.shouldNotBeNull()
            Continent.Africa.shouldBeEqual(result)
        }
        it("numeric") {
            val tag = "002"
            val result = Continent.forCodeOrNull(tag)

            result.shouldNotBeNull()
            Continent.Africa.shouldBeEqual(result)
        }
    }

    describe("antarctica is parsed correctly") {
        it("geoname") {
            val tag = "AN"
            val result = Continent.forCodeOrNull(tag)

            result.shouldNotBeNull()
            Continent.Antarctica.shouldBeEqual(result)
        }
        it("numeric") {
            val tag = "010"
            val result = Continent.forCodeOrNull(tag)

            result.shouldNotBeNull()
            Continent.Antarctica.shouldBeEqual(result)
        }
    }

    describe("asia is parsed correctly") {
        it("geoname") {
            val tag = "as"
            val result = Continent.forCodeOrNull(tag)

            result.shouldNotBeNull()
            Continent.Asia.shouldBeEqual(result)
        }
        it("stanag") {
            val tag = "abb"
            val result = Continent.forCodeOrNull(tag)

            result.shouldNotBeNull()
            Continent.Asia.shouldBeEqual(result)
        }
        it("numeric") {
            val tag = 142
            val result = Continent.forCodeOrNull(tag)

            result.shouldNotBeNull()
            Continent.Asia.shouldBeEqual(result)
        }
    }

    describe("europe is parsed correctly") {
        it("geoname") {
            val tag = "eu"
            val result = Continent.forCodeOrNull(tag)

            result.shouldNotBeNull()
            Continent.Europe.shouldBeEqual(result)
        }
        it("stanag") {
            val tag = "eee"
            val result = Continent.forCodeOrNull(tag)

            result.shouldNotBeNull()
            Continent.Europe.shouldBeEqual(result)
        }
        it("numeric") {
            val tag = 150
            val result = Continent.forCodeOrNull(tag)

            result.shouldNotBeNull()
            Continent.Europe.shouldBeEqual(result)
        }
    }

    describe("north america is parsed correctly") {
        it("geoname") {
            val tag = "NA"
            val result = Continent.forCodeOrNull(tag)

            result.shouldNotBeNull()
            Continent.NorthAmerica.shouldBeEqual(result)
        }
        it("stanag") {
            val tag = "NNN"
            val result = Continent.forCodeOrNull(tag)

            result.shouldNotBeNull()
            Continent.NorthAmerica.shouldBeEqual(result)
        }
        it("numeric") {
            val tag = "003"
            val result = Continent.forCodeOrNull(tag)

            result.shouldNotBeNull()
            Continent.NorthAmerica.shouldBeEqual(result)
        }
    }

    describe("oceania is parsed correctly") {
        it("geoname") {
            val tag = "oc"
            val result = Continent.forCodeOrNull(tag)

            result.shouldNotBeNull()
            Continent.Oceania.shouldBeEqual(result)
        }
        it("stanag") {
            val tag = "UUU"
            val result = Continent.forCodeOrNull(tag)

            result.shouldNotBeNull()
            Continent.Oceania.shouldBeEqual(result)
        }
        it("numeric") {
            val tag = "009"
            val result = Continent.forCodeOrNull(tag)

            result.shouldNotBeNull()
            Continent.Oceania.shouldBeEqual(result)
        }
    }

    describe("south america is parsed correctly") {
        it("geoname") {
            val tag = "SA"
            val result = Continent.forCodeOrNull(tag)

            result.shouldNotBeNull()
            Continent.SouthAmerica.shouldBeEqual(result)
        }
        it("stanag") {
            val tag = "SRR"
            val result = Continent.forCodeOrNull(tag)

            result.shouldNotBeNull()
            Continent.SouthAmerica.shouldBeEqual(result)
        }
        it("numeric") {
            val tag = "005"
            val result = Continent.forCodeOrNull(tag)

            result.shouldNotBeNull()
            Continent.SouthAmerica.shouldBeEqual(result)
        }
    }
})