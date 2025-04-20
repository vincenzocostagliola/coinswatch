package dev.vincenzocostagliola.data.domain


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

data class CoinData(
    val additionalNotices: List<Any?>,
    val assetPlatformId: Any?,
    val blockTimeInMinutes: Int,
    val categories: List<String>,
    val countryOrigin: String,
    val description: Description,
    val genesisDate: String,
    val hashingAlgorithm: String,
    val id: String,
    val image: Image,
    val lastUpdated: String,
    val links: Links,
    val localization: Localization,
    val marketCapRank: Int,
    val marketData: MarketData,
    val name: String,
    val previewListing: Boolean,
    val publicNotice: Any?,
    val sentimentVotesDownPercentage: Double,
    val sentimentVotesUpPercentage: Double,
    val statusUpdates: List<Any?>,
    val symbol: String,
    val watchlistPortfolioUsers: Int,
    val webSlug: String
) {
    data class Description(
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
        val circulatingSupply: Int,
        val currentPrice: CurrentPrice,
        val fullyDilutedValuation: FullyDilutedValuation,
        val high24h: High24h,
        val lastUpdated: String,
        val low24h: Low24h,
        val marketCap: MarketCap,
        val marketCapChange24h: Double,
        val marketCapChangePercentage24h: Double,
        val marketCapFdvRatio: Int,
        val marketCapRank: Int,
        val maxSupply: Int,
        val maxSupplyInfinite: Boolean,
        val priceChange24h: Double,
        val priceChangePercentage14d: Double,
        val priceChangePercentage1y: Double,
        val priceChangePercentage200d: Double,
        val priceChangePercentage24h: Double,
        val priceChangePercentage30d: Double,
        val priceChangePercentage60d: Double,
        val priceChangePercentage7d: Double,
        val roi: Any?,
        val totalSupply: Int,
        val totalValueLocked: Any?,
    ) {
        //TODO Improve with more currencies
        data class CurrentPrice(
            val eur: Int
        )

        data class FullyDilutedValuation(
            @SerialName("aed")
            val aed: Long,
            @SerialName("ars")
            val ars: Long,
            @SerialName("aud")
            val aud: Long,
            @SerialName("bch")
            val bch: Long,
            @SerialName("bdt")
            val bdt: Long,
            @SerialName("bhd")
            val bhd: Long,
            @SerialName("bits")
            val bits: Long,
            @SerialName("bmd")
            val bmd: Long,
            @SerialName("bnb")
            val bnb: Long,
            @SerialName("brl")
            val brl: Long,
            @SerialName("btc")
            val btc: Int,
            @SerialName("cad")
            val cad: Long,
            @SerialName("chf")
            val chf: Long,
            @SerialName("clp")
            val clp: Long,
            @SerialName("cny")
            val cny: Long,
            @SerialName("czk")
            val czk: Long,
            @SerialName("dkk")
            val dkk: Long,
            @SerialName("dot")
            val dot: Long,
            @SerialName("eos")
            val eos: Long,
            @SerialName("eth")
            val eth: Int,
            @SerialName("eur")
            val eur: Long,
            @SerialName("gbp")
            val gbp: Long,
            @SerialName("gel")
            val gel: Long,
            @SerialName("hkd")
            val hkd: Long,
            @SerialName("huf")
            val huf: Long,
            @SerialName("idr")
            val idr: Long,
            @SerialName("ils")
            val ils: Long,
            @SerialName("inr")
            val inr: Long,
            @SerialName("jpy")
            val jpy: Long,
            @SerialName("krw")
            val krw: Long,
            @SerialName("kwd")
            val kwd: Long,
            @SerialName("link")
            val link: Long,
            @SerialName("lkr")
            val lkr: Long,
            @SerialName("ltc")
            val ltc: Long,
            @SerialName("mmk")
            val mmk: Long,
            @SerialName("mxn")
            val mxn: Long,
            @SerialName("myr")
            val myr: Long,
            @SerialName("ngn")
            val ngn: Long,
            @SerialName("nok")
            val nok: Long,
            @SerialName("nzd")
            val nzd: Long,
            @SerialName("php")
            val php: Long,
            @SerialName("pkr")
            val pkr: Long,
            @SerialName("pln")
            val pln: Long,
            @SerialName("rub")
            val rub: Long,
            @SerialName("sar")
            val sar: Long,
            @SerialName("sats")
            val sats: Long,
            @SerialName("sek")
            val sek: Long,
            @SerialName("sgd")
            val sgd: Long,
            @SerialName("thb")
            val thb: Long,
            @SerialName("try")
            val tryX: Long,
            @SerialName("twd")
            val twd: Long,
            @SerialName("uah")
            val uah: Long,
            @SerialName("usd")
            val usd: Long,
            @SerialName("vef")
            val vef: Long,
            @SerialName("vnd")
            val vnd: Long,
            @SerialName("xag")
            val xag: Long,
            @SerialName("xau")
            val xau: Int,
            @SerialName("xdr")
            val xdr: Long,
            @SerialName("xlm")
            val xlm: Long,
            @SerialName("xrp")
            val xrp: Long,
            @SerialName("yfi")
            val yfi: Int,
            @SerialName("zar")
            val zar: Long
        )

        data class High24h(
            val eur: Int
        )

        data class Low24h(
            val eur: Int
        )

        data class MarketCap(
            val eur: Long
        )
    }
}