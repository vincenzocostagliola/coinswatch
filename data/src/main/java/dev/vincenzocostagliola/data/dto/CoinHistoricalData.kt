package dev.vincenzocostagliola.data.dto


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class CoinHistoricalData(
    //TODO List<Double> means a list with only two double.
    //TODO the first represent a date
    //TODO the second represent price, money, whatelse
    @SerialName("market_caps")
    val marketCaps: List<List<Double>>,
    @SerialName("prices")
    val prices: List<List<Double>>,
    @SerialName("total_volumes")
    val totalVolumes: List<List<Double>>
)