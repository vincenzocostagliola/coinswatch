package dev.vincenzocostagliola.coindetails.data.domain


import org.threeten.bp.OffsetDateTime

data class CoinHistoricalData(
    val prices: List<PriceChartPoint>,
) {
    data class PriceChartPoint(
        val date: OffsetDateTime,
        val value: Double
    )
}