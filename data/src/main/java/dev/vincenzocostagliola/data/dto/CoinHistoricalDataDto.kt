package dev.vincenzocostagliola.data.dto


import dev.vincenzocostagliola.data.domain.CoinHistoricalData
import dev.vincenzocostagliola.data.net.serializer.OffsetDateTimeSerializer
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import org.threeten.bp.OffsetDateTime

@Serializable
data class CoinHistoricalDataDto(
    @SerialName("market_caps")
    val marketCaps: List<MarketCapsChartPointDto>,
    @SerialName("prices")
    val prices: List<PriceChartPointDto>,
    @SerialName("total_volumes")
    val totalVolumes: List<TotalVolumeChartPointDto>
) {
    @Serializable
    data class MarketCapsChartPointDto(
        @Serializable(with = OffsetDateTimeSerializer::class)
        val date: OffsetDateTime,
        @Serializable
        val value: Double
    ) {
        fun toDomain(): CoinHistoricalData.MarketCapsChartPoint {
            return CoinHistoricalData.MarketCapsChartPoint(
                date = date,
                value = value
            )
        }
    }

    @Serializable
    data class PriceChartPointDto(
        @Serializable(with = OffsetDateTimeSerializer::class)
        val date: OffsetDateTime,
        @Serializable
        val value: Double
    ) {
        fun toDomain(): CoinHistoricalData.PriceChartPoint {
            return CoinHistoricalData.PriceChartPoint(
                date = date,
                value = value
            )
        }
    }

    @Serializable
    data class TotalVolumeChartPointDto(
        @Serializable(with = OffsetDateTimeSerializer::class)
        val date: OffsetDateTime,
        @Serializable
        val value: Double
    ) {
        fun toDomain(): CoinHistoricalData.TotalVolumeChartPoint {
            return CoinHistoricalData.TotalVolumeChartPoint(
                date = date,
                value = value
            )
        }
    }

    fun toDomain(): CoinHistoricalData {
        return CoinHistoricalData(
            marketCaps = marketCaps.map { it.toDomain() },
            prices = prices.map { it.toDomain() },
            totalVolumes = totalVolumes.map { it.toDomain() }
        )
    }
}