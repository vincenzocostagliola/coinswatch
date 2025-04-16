package dev.vincenzocostagliola.data.dto


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
[
{
"id": "bitcoin",
"symbol": "btc",
"name": "Bitcoin",
"image": "https://assets.coingecko.com/coins/images/1/large/bitcoin.png?1696501400",
"current_price": 70187,
"market_cap": 1381651251183,
"market_cap_rank": 1,
"fully_diluted_valuation": 1474623675796,
"total_volume": 20154184933,
"high_24h": 70215,
"low_24h": 68060,
"price_change_24h": 2126.88,
"price_change_percentage_24h": 3.12502,
"market_cap_change_24h": 44287678051,
"market_cap_change_percentage_24h": 3.31157,
"circulating_supply": 19675987,
"total_supply": 21000000,
"max_supply": 21000000,
"ath": 73738,
"ath_change_percentage": -4.77063,
"ath_date": "2024-03-14T07:10:36.635Z",
"atl": 67.81,
"atl_change_percentage": 103455.83335,
"atl_date": "2013-07-06T00:00:00.000Z",
"roi": null,
"last_updated": "2024-04-07T16:49:31.736Z"
}
]
 */

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