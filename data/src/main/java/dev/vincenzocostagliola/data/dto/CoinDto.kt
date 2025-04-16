package dev.vincenzocostagliola.data.dto


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class CoinDto(
    @SerialName("ath")
    val ath: Int,
    @SerialName("ath_change_percentage")
    val athChangePercentage: Double,
    @SerialName("ath_date")
    val athDate: String,
    @SerialName("atl")
    val atl: Double,
    @SerialName("atl_change_percentage")
    val atlChangePercentage: Double,
    @SerialName("atl_date")
    val atlDate: String,
    @SerialName("circulating_supply")
    val circulatingSupply: Int,
    @SerialName("current_price")
    val currentPrice: Int,
    @SerialName("fully_diluted_valuation")
    val fullyDilutedValuation: Long,
    @SerialName("high_24h")
    val high24h: Int,
    @SerialName("id")
    val id: String,
    @SerialName("image")
    val image: String,
    @SerialName("last_updated")
    val lastUpdated: String,
    @SerialName("low_24h")
    val low24h: Int,
    @SerialName("market_cap")
    val marketCap: Long,
    @SerialName("market_cap_change_24h")
    val marketCapChange24h: Long,
    @SerialName("market_cap_change_percentage_24h")
    val marketCapChangePercentage24h: Double,
    @SerialName("market_cap_rank")
    val marketCapRank: Int,
    @SerialName("max_supply")
    val maxSupply: Int,
    @SerialName("name")
    val name: String,
    @SerialName("price_change_24h")
    val priceChange24h: Double,
    @SerialName("price_change_percentage_24h")
    val priceChangePercentage24h: Double,
    @SerialName("roi")
    val roi: Any?,
    @SerialName("symbol")
    val symbol: String,
    @SerialName("total_supply")
    val totalSupply: Int,
    @SerialName("total_volume")
    val totalVolume: Long
)