package dev.vincenzocostagliola.data.dto


import dev.vincenzocostagliola.data.domain.CoinHistoricalData
import dev.vincenzocostagliola.data.net.serializer.EpochOffsetDateTimeSerializer
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import org.threeten.bp.OffsetDateTime

@Serializable
data class CoinHistoricalDataDto(
    //@SerialName("market_caps")
    //val marketCaps: List<List<MarketCapsChartPointDto>>,
    @SerialName("prices")
    val prices: List<List<Double>>,
    //@SerialName("total_volumes")
    //val totalVolumes: List<List<TotalVolumeChartPointDto>>
) {
    @Serializable
    data class MarketCapsChartPointDto(
        @Serializable(with = EpochOffsetDateTimeSerializer::class)
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
        @Serializable(with = EpochOffsetDateTimeSerializer::class)
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
        @Serializable(with = EpochOffsetDateTimeSerializer::class)
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
            marketCaps = emptyList(), // marketCaps.map { it.map { it.toDomain() }},
            prices = emptyList(), //prices.map { it.toDomain() },
            totalVolumes = emptyList(), //totalVolumes.map { it.toDomain() }
        )
    }
}