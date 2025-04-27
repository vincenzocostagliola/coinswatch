package dev.vincenzocostagliola.coindetails.data.dto


import dev.vincenzocostagliola.coindetails.data.domain.CoinHistoricalData
import dev.vincenzocostagliola.coindetails.data.serializer.PriceChartPointListSerializer
import dev.vincenzocostagliola.data.net.serializer.OffsetDateTimeSerializer
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import org.threeten.bp.OffsetDateTime

@Serializable
data class CoinHistoricalDataDto(
    @Serializable(with = PriceChartPointListSerializer::class)
    @SerialName("prices")
    val prices: List<PriceChartPointDto>
) {

    @Serializable
    data class PriceChartPointDto(
        @Serializable(with = OffsetDateTimeSerializer::class)
        val date: OffsetDateTime,
        val value: Double
    ) {
        fun toDomain(): CoinHistoricalData.PriceChartPoint {
            return CoinHistoricalData.PriceChartPoint(
                date = date,
                value = value
            )
        }
    }

    fun toDomain(): CoinHistoricalData {
        return CoinHistoricalData(
            prices = prices.map { it.toDomain() }
        )
    }
}
