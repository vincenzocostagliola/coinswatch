package dev.vincenzocostagliola.coindetails.ui

import org.threeten.bp.OffsetDateTime

data class CoinHistory(
    val chartPricesPoints: List<Float>,
    val chartDates: List<OffsetDateTime>,
    val chartFormattedPrices: List<String>
)