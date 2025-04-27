package dev.vincenzocostagliola.coinswatch.details

import org.threeten.bp.OffsetDateTime

data class CoinHistory(
    val chartPricesPoints: List<Float>,
    val chartDates: List<OffsetDateTime>,
    val chartFormattedPrices: List<String>
)