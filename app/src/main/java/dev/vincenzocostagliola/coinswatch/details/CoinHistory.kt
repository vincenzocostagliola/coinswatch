package dev.vincenzocostagliola.coinswatch.details

import org.threeten.bp.OffsetDateTime

data class CoinHistory(
    val chartPrice : Float,
    val date : OffsetDateTime,
    val significantPrices: Float
)
