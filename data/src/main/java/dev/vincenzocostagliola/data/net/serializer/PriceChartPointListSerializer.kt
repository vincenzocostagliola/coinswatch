package dev.vincenzocostagliola.data.net.serializer

import dev.vincenzocostagliola.data.dto.CoinHistoricalDataDto.PriceChartPointDto
import kotlinx.serialization.InternalSerializationApi
import kotlinx.serialization.KSerializer
import kotlinx.serialization.Serializable
import kotlinx.serialization.SerializationException
import kotlinx.serialization.builtins.ListSerializer
import kotlinx.serialization.descriptors.SerialDescriptor
import kotlinx.serialization.encoding.Decoder
import kotlinx.serialization.encoding.Encoder
import kotlinx.serialization.json.JsonArray
import kotlinx.serialization.json.JsonDecoder
import kotlinx.serialization.json.JsonEncoder
import kotlinx.serialization.json.JsonPrimitive
import kotlinx.serialization.json.double
import kotlinx.serialization.json.jsonArray
import kotlinx.serialization.json.jsonPrimitive
import kotlinx.serialization.json.long
import kotlinx.serialization.serializer
import org.threeten.bp.Instant
import org.threeten.bp.ZoneOffset

@Serializable
private data class PricePointSurrogate(
    val timestamp: Long,
    val price: Double
)

class PriceChartPointListSerializer : KSerializer<List<PriceChartPointDto>> {
    @OptIn(InternalSerializationApi::class)
    override val descriptor: SerialDescriptor =
        ListSerializer(PricePointSurrogate::class.serializer()).descriptor

    override fun deserialize(decoder: Decoder): List<PriceChartPointDto> {
        val input = decoder as? JsonDecoder
            ?: throw SerializationException("This class can be loaded only by JSON")
        val jsonArray = input.decodeJsonElement().jsonArray

        return jsonArray.map { element ->
            val array = element.jsonArray
            val timestampMillis = array[0].jsonPrimitive.long
            val price = array[1].jsonPrimitive.double

            PriceChartPointDto(
                date = Instant.ofEpochMilli(timestampMillis).atOffset(ZoneOffset.UTC),
                value = price
            )
        }
    }

    override fun serialize(encoder: Encoder, value: List<PriceChartPointDto>) {
        val jsonEncoder = encoder as? JsonEncoder
            ?: throw SerializationException("This class can be saved only by JSON")

        val jsonArray = JsonArray(value.map {
            JsonArray(
                listOf(
                    JsonPrimitive(it.date.toInstant().toEpochMilli()),
                    JsonPrimitive(it.value)
                )
            )
        })

        jsonEncoder.encodeJsonElement(jsonArray)
    }
}
