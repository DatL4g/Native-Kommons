package dev.datlag.kommons

import dev.datlag.kommons.serializer.ContinentAsGeoNameStringSerializer
import kotlinx.serialization.Serializable
import kotlin.jvm.JvmStatic

@Serializable(with = ContinentAsGeoNameStringSerializer::class)
sealed interface Continent {

    /**
     * Continent code in GeoName format
     */
    val geoName: Code.GeoName

    /**
     * Continent code in STANAG 1059 format
     */
    val stanag: Code.STANAG?

    /**
     * Continent code in UN M49 format
     */
    val numeric: Code.Numeric

    @Serializable
    data object Africa : Continent {
        override val geoName: Code.GeoName = Code.GeoName("AF")
        override val stanag: Code.STANAG = Code.STANAG("FFF")
        override val numeric: Code.Numeric = Code.Numeric(2)
    }

    @Serializable
    data object Antarctica : Continent {
        override val geoName: Code.GeoName = Code.GeoName("AN")
        override val stanag: Code.STANAG? = null
        override val numeric: Code.Numeric = Code.Numeric(10)
    }

    @Serializable
    data object Asia : Continent {
        override val geoName: Code.GeoName = Code.GeoName("AS")
        override val stanag: Code.STANAG = Code.STANAG("ABB")
        override val numeric: Code.Numeric = Code.Numeric(142)
    }

    @Serializable
    data object Europe : Continent {
        override val geoName: Code.GeoName = Code.GeoName("EU")
        override val stanag: Code.STANAG = Code.STANAG("EEE")
        override val numeric: Code.Numeric = Code.Numeric(150)
    }

    @Serializable
    data object NorthAmerica : Continent {
        override val geoName: Code.GeoName = Code.GeoName("NA")
        override val stanag: Code.STANAG = Code.STANAG("NNN")
        override val numeric: Code.Numeric = Code.Numeric(3)
    }

    @Serializable
    data object Oceania : Continent {
        override val geoName: Code.GeoName = Code.GeoName("OC")
        override val stanag: Code.STANAG = Code.STANAG("UUU")
        override val numeric: Code.Numeric = Code.Numeric(9)
    }

    @Serializable
    data object SouthAmerica : Continent {
        override val geoName: Code.GeoName = Code.GeoName("SA")
        override val stanag: Code.STANAG = Code.STANAG("SRR")
        override val numeric: Code.Numeric = Code.Numeric(5)
    }

    @Serializable
    sealed interface Code {

        @Serializable
        @ConsistentCopyVisibility
        data class GeoName internal constructor(
            val code: String
        ) : Code, CharSequence by code {

            override fun toString(): String {
                return code
            }
        }

        @Serializable
        @ConsistentCopyVisibility
        data class STANAG internal constructor(
            val code: String
        ) : Code, CharSequence by code {

            override fun toString(): String {
                return code
            }
        }

        @Serializable
        @ConsistentCopyVisibility
        data class Numeric internal constructor(
            val code: Int
        ) : Code, Number() {

            override fun toDouble(): Double {
                return code.toDouble()
            }

            override fun toFloat(): Float {
                return code.toFloat()
            }

            override fun toLong(): Long {
                return code.toLong()
            }

            override fun toInt(): Int {
                return code
            }

            override fun toShort(): Short {
                return code.toShort()
            }

            override fun toByte(): Byte {
                return code.toByte()
            }

            override fun toString(): String {
                return code.toString()
            }
        }
    }

    companion object {

        @JvmStatic
        fun forCodeOrNull(code: String): Continent? {
            val trimmed = code.trim().ifBlank { null } ?: return null

            fun parseGeoName(): Continent? {
                return when {
                    Africa.geoName.contentEquals(trimmed, ignoreCase = true) -> Africa
                    Antarctica.geoName.contentEquals(trimmed, ignoreCase = true) -> Antarctica
                    Asia.geoName.contentEquals(trimmed, ignoreCase = true) -> Asia
                    Europe.geoName.contentEquals(trimmed, ignoreCase = true) -> Europe
                    NorthAmerica.geoName.contentEquals(trimmed, ignoreCase = true) -> NorthAmerica
                    Oceania.geoName.contentEquals(trimmed, ignoreCase = true) -> Oceania
                    SouthAmerica.geoName.contentEquals(trimmed, ignoreCase = true) -> SouthAmerica
                    else -> null
                }
            }

            fun parseSTANAG(): Continent? {
                return when {
                    Africa.stanag.contentEquals(trimmed, ignoreCase = true) -> Africa
                    Antarctica.stanag.contentEquals(trimmed, ignoreCase = true) -> Antarctica
                    Asia.stanag.contentEquals(trimmed, ignoreCase = true) -> Asia
                    Europe.stanag.contentEquals(trimmed, ignoreCase = true) -> Europe
                    NorthAmerica.stanag.contentEquals(trimmed, ignoreCase = true) -> NorthAmerica
                    Oceania.stanag.contentEquals(trimmed, ignoreCase = true) -> Oceania
                    SouthAmerica.stanag.contentEquals(trimmed, ignoreCase = true) -> SouthAmerica
                    else -> null
                }
            }

            return trimmed.toIntOrNull()?.let(::forCodeOrNull) ?: parseGeoName() ?: parseSTANAG()
        }

        @JvmStatic
        fun forCodeOrNull(code: Int): Continent? {
            return when (code) {
                Africa.numeric.toInt() -> Africa
                Antarctica.numeric.toInt() -> Antarctica
                Asia.numeric.toInt() -> Asia
                Europe.numeric.toInt() -> Europe
                NorthAmerica.numeric.toInt() -> NorthAmerica
                SouthAmerica.numeric.toInt() -> SouthAmerica
                Oceania.numeric.toInt() -> Oceania
                else -> null
            }
        }
    }
}