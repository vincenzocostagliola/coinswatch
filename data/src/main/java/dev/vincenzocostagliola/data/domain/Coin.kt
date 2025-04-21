package dev.vincenzocostagliola.data.domain

data class Coin(
    val ath: Double,
    val athChangePercentage: Double,
    val athDate: String,
    val atl: Double,
    val atlChangePercentage: Double,
    val atlDate: String,
    val circulatingSupply: Double,
    val currentPrice: Double,
    val fullyDilutedValuation: Long,
    val high24h: Double,
    val id: String,
    val image: String,
    val lastUpdated: String,
    val low24h: Double,
    val marketCap: Long,
    val marketCapChange24h: Long,
    val marketCapChangePercentage24h: Double,
    val marketCapRank: Int,
    val maxSupply: Double,
    val name: String,
    val priceChange24h: Double,
    val priceChangePercentage24h: Double,
    val symbol: String,
    val totalSupply: Double,
    val totalVolume: Long
)