package dev.vincenzocostagliola.data.domain


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import org.threeten.bp.OffsetDateTime

data class CoinData(
    val blockTimeInMinutes: Int,
    val countryOrigin: String,
    val description: Description,
    val genesisDate: String,
    val hashingAlgorithm: String,
    val id: String,
    val image: Image,
    val lastUpdated: OffsetDateTime,
    val links: Links,
    val localization: Localization,
    val marketCapRank: Int,
    val marketData: MarketData,
    val name: String,
    val previewListing: Boolean,
    val symbol: String,
) {
    data class Description(
        val en: String,
        val it: String
    )

    data class Image(
        val large: String,
        val small: String,
        val thumb: String
    )

    data class Links(
        val homepage: List<String>,
    )

    data class Localization(
        val ar: String,
        val bg: String,
        val cs: String,
        val da: String,
        val de: String,
        val el: String,
        val en: String,
        val es: String,
        val fi: String,
        val fr: String,
        val he: String,
        val hi: String,
        val hr: String,
        val hu: String,
        val id: String,
        val it: String,
        val ja: String,
        val ko: String,
        val lt: String,
        val nl: String,
        val no: String,
        val pl: String,
        val pt: String,
        val ro: String,
        val ru: String,
        val sk: String,
        val sl: String,
        val sv: String,
        val th: String,
        val tr: String,
        val uk: String,
        val vi: String,
        val zh: String,
        val zhTw: String
    )

    data class MarketData(
        val circulatingSupply: Double,
        val currentPrice: CurrentPrice,
        val high24h: High24h,
        val lastUpdated: OffsetDateTime,
        val low24h: Low24h,
        val marketCap: MarketCap,
        val marketCapChange24h: Double,
        val marketCapRank: Int,
        val priceChange24h: Double,
        val totalSupply: Double,
    ) {
        //TODO Improve with more currencies
        data class CurrentPrice(
            val eur: Double
        )

        data class High24h(
            val eur: Double
        )

        data class Low24h(
            val eur: Double
        )

        data class MarketCap(
            val eur: Double
        )
    }
}