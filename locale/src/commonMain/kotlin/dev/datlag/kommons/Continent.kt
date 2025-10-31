package dev.datlag.kommons

import dev.datlag.kommons.serializer.ContinentAsGeoNameStringSerializer
import kotlinx.serialization.Serializable

@Serializable(with = ContinentAsGeoNameStringSerializer::class)
sealed interface Continent {

    val geoName: Code.GeoName

    @Serializable
    data object Africa : Continent {
        override val geoName: Code.GeoName = Code.GeoName("AF")
    }

    @Serializable
    data object Antarctica : Continent {
        override val geoName: Code.GeoName = Code.GeoName("AN")
    }

    @Serializable
    data object Asia : Continent {
        override val geoName: Code.GeoName = Code.GeoName("AS")
    }

    @Serializable
    data object Europe : Continent {
        override val geoName: Code.GeoName = Code.GeoName("EU")
    }

    @Serializable
    data object NorthAmerica : Continent {
        override val geoName: Code.GeoName = Code.GeoName("NA")
    }

    @Serializable
    data object Oceania : Continent {
        override val geoName: Code.GeoName = Code.GeoName("OC")
    }

    @Serializable
    data object SouthAmerica : Continent {
        override val geoName: Code.GeoName = Code.GeoName("SA")
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
    }

    companion object {

        fun forCodeOrNull(code: String): Continent? {
            val trimmed = code.trim().ifBlank { null } ?: return null
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
    }
}