package dev.vincenzocostagliola.data.domain


import org.threeten.bp.OffsetDateTime

data class CoinHistoricalData(
    val marketCaps: List<MarketCapsChartPoint>,
    val prices: List<PriceChartPoint>,
    val totalVolumes: List<TotalVolumeChartPoint>
) {
    data class MarketCapsChartPoint(
        val date: OffsetDateTime,
        val value: Double
    )

    data class PriceChartPoint(
        val date: OffsetDateTime,
        val value: Double
    )

    data class TotalVolumeChartPoint(
        val date: OffsetDateTime,
        val value: Double
    )
}