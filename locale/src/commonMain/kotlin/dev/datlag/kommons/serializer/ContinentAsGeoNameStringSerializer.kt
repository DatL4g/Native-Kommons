package dev.datlag.kommons.serializer

import dev.datlag.kommons.Continent
import kotlinx.serialization.ExperimentalSerializationApi
import kotlinx.serialization.KSerializer
import kotlinx.serialization.descriptors.PrimitiveKind
import kotlinx.serialization.descriptors.PrimitiveSerialDescriptor
import kotlinx.serialization.descriptors.SerialDescriptor
import kotlinx.serialization.encoding.Decoder
import kotlinx.serialization.encoding.Encoder

object ContinentAsGeoNameStringSerializer : KSerializer<Continent?> {
    override val descriptor: SerialDescriptor = PrimitiveSerialDescriptor("Continent", PrimitiveKind.STRING)

    @OptIn(ExperimentalSerializationApi::class)
    override fun deserialize(decoder: Decoder): Continent? {
        return if (decoder.decodeNotNullMark()) {
            Continent.forCodeOrNull(decoder.decodeString())
        } else {
            decoder.decodeNull()
        }
    }

    @OptIn(ExperimentalSerializationApi::class)
    override fun serialize(encoder: Encoder, value: Continent?) {
        if (value != null) {
            encoder.encodeNotNullMark()
            encoder.encodeString(value.geoName.code)
        } else {
            encoder.encodeNull()
        }
    }
}