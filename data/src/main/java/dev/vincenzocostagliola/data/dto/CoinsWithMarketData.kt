package dev.vincenzocostagliola.data.dto

import kotlinx.serialization.Serializable

@Serializable
data class CoinsWithMarketData (
    val coinsList : List<CoinDto>
)