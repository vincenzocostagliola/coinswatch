package dev.vincenzocostagliola.coindetails.data.dto


import dev.vincenzocostagliola.coindetails.data.domain.CoinData
import dev.vincenzocostagliola.data.net.serializer.OffsetDateTimeSerializer
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import org.threeten.bp.OffsetDateTime

@Serializable
data class CoinDataDto(
    @SerialName("block_time_in_minutes")
    val blockTimeInMinutes: Int,
    @SerialName("country_origin")
    val countryOrigin: String,
    @SerialName("description")
    val description: Description,
    @SerialName("genesis_date")
    val genesisDate: String,
    @SerialName("hashing_algorithm")
    val hashingAlgorithm: String,
    @SerialName("id")
    val id: String,
    @SerialName("image")
    val image: Image,
    @Serializable(with = OffsetDateTimeSerializer::class)
    @SerialName("last_updated")
    val lastUpdated: OffsetDateTime,
    @SerialName("links")
    val links: Links,
    @SerialName("localization")
    val localization: Localization,
    @SerialName("market_cap_rank")
    val marketCapRank: Int,
    @SerialName("market_data")
    val marketData: MarketData,
    @SerialName("name")
    val name: String,
    @SerialName("preview_listing")
    val previewListing: Boolean,
    @SerialName("symbol")
    val symbol: String
) {

    //TODO needs to be improved BE side, giving just the the language choosen by user
    @Serializable
    data class Description(
        @SerialName("en")
        val en: String,
        @SerialName("it")
        val it: String
    ) {
        fun toDomain(): CoinData.Description {
            return CoinData.Description(
                en = en,
                it = it
            )
        }
    }

    @Serializable
    data class Image(
        @SerialName("large")
        val large: String,
        @SerialName("small")
        val small: String,
        @SerialName("thumb")
        val thumb: String
    ) {
        fun toDomain(): CoinData.Image {
            return CoinData.Image(large = large, small = small, thumb = thumb)
        }
    }

    @Serializable
    data class Links(
        @SerialName("blockchain_site")
        val blockchainSite: List<String>,
        @SerialName("facebook_username")
        val facebookUsername: String,
        @SerialName("homepage")
        val homepage: List<String>,
        @SerialName("official_forum_url")
        val officialForumUrl: List<String>,
        @SerialName("subreddit_url")
        val subredditUrl: String,
        @SerialName("telegram_channel_identifier")
        val telegramChannelIdentifier: String,
        @SerialName("twitter_screen_name")
        val twitterScreenName: String,
        @SerialName("whitepaper")
        val whitepaper: String
    ) {

        fun toDomain(): CoinData.Links {
            return CoinData.Links(homepage = homepage)
        }
    }

    @Serializable
    data class Localization(
        @SerialName("ar")
        val ar: String,
        @SerialName("bg")
        val bg: String,
        @SerialName("cs")
        val cs: String,
        @SerialName("da")
        val da: String,
        @SerialName("de")
        val de: String,
        @SerialName("el")
        val el: String,
        @SerialName("en")
        val en: String,
        @SerialName("es")
        val es: String,
        @SerialName("fi")
        val fi: String,
        @SerialName("fr")
        val fr: String,
        @SerialName("he")
        val he: String,
        @SerialName("hi")
        val hi: String,
        @SerialName("hr")
        val hr: String,
        @SerialName("hu")
        val hu: String,
        @SerialName("id")
        val id: String,
        @SerialName("it")
        val it: String,
        @SerialName("ja")
        val ja: String,
        @SerialName("ko")
        val ko: String,
        @SerialName("lt")
        val lt: String,
        @SerialName("nl")
        val nl: String,
        @SerialName("no")
        val no: String,
        @SerialName("pl")
        val pl: String,
        @SerialName("pt")
        val pt: String,
        @SerialName("ro")
        val ro: String,
        @SerialName("ru")
        val ru: String,
        @SerialName("sk")
        val sk: String,
        @SerialName("sl")
        val sl: String,
        @SerialName("sv")
        val sv: String,
        @SerialName("th")
        val th: String,
        @SerialName("tr")
        val tr: String,
        @SerialName("uk")
        val uk: String,
        @SerialName("vi")
        val vi: String,
        @SerialName("zh")
        val zh: String,
        @SerialName("zh-tw")
        val zhTw: String
    ) {
        fun toDomain(): CoinData.Localization {
            return CoinData.Localization(
                ar = ar,
                bg = bg,
                cs = cs,
                da = da,
                de = de,
                el = el,
                en = en,
                es = es,
                fi = fi,
                fr = fr,
                he = he,
                hi = hi,
                hr = hr,
                hu = hu,
                id = id,
                it = it,
                ja = ja,
                ko = ko,
                lt = lt,
                nl = nl,
                no = no,
                pl = pl,
                pt = pt,
                ro = ro,
                ru = ru,
                sk = sk,
                sl = sl,
                sv = sv,
                th = th,
                tr = tr,
                uk = uk,
                vi = vi,
                zh = zh,
                zhTw = zhTw
            )
        }
    }

    @Serializable
    data class MarketData(
        @SerialName("circulating_supply")
        val circulatingSupply: Double,
        @SerialName("current_price")
        val currentPrice: CurrentPrice,
        @SerialName("high_24h")
        val high24h: High24h,
        @Serializable(with = OffsetDateTimeSerializer::class)
        @SerialName("last_updated")
        val lastUpdated: OffsetDateTime,
        @SerialName("low_24h")
        val low24h: Low24h,
        @SerialName("market_cap")
        val marketCap: MarketCap,
        @SerialName("market_cap_change_24h")
        val marketCapChange24h: Double,
        @SerialName("market_cap_change_24h_in_currency")
        val marketCapChange24hInCurrency: MarketCapChange24hInCurrency,
        @SerialName("market_cap_rank")
        val marketCapRank: Int,
        @SerialName("price_change_24h")
        val priceChange24h: Double,
        @SerialName("total_supply")
        val totalSupply: Double,
        @SerialName("total_volume")
        val totalVolume: TotalVolume
    ) {
        @Serializable
        data class CurrentPrice(
            @SerialName("eur")
            val eur: Double
        ) {
            fun toDomain(): CoinData.MarketData.CurrentPrice {
                return CoinData.MarketData.CurrentPrice(
                    eur = eur
                )
            }
        }

        @Serializable
        data class High24h(
            @SerialName("eur")
            val eur: Double
        ) {
            fun toDomain(): CoinData.MarketData.High24h {
                return CoinData.MarketData.High24h(eur = eur)
            }
        }

        @Serializable
        data class Low24h(
            @SerialName("eur")
            val eur: Double
        ){
            fun toDomain(): CoinData.MarketData.Low24h {
                return CoinData.MarketData.Low24h(eur = eur)
            }
        }

        @Serializable
        data class MarketCap(
            @SerialName("eur")
            val eur: Double
        ){
            fun toDomain(): CoinData.MarketData.MarketCap {
                return CoinData.MarketData.MarketCap(eur = eur)
            }
        }

        @Serializable
        data class MarketCapChange24hInCurrency(
            @SerialName("eur")
            val eur: Double
        )

        @Serializable
        data class TotalVolume(
            @SerialName("eur")
            val eur: Double
        )

        fun toDomain(): CoinData.MarketData {
            return CoinData.MarketData(
                circulatingSupply = circulatingSupply,
                currentPrice = currentPrice.toDomain(),
                high24h = high24h.toDomain(),
                lastUpdated = lastUpdated,
                low24h = low24h.toDomain(),
                marketCap = marketCap.toDomain(),
                marketCapChange24h = marketCapChange24h,
                marketCapRank = marketCapRank,
                priceChange24h = priceChange24h,
                totalSupply = totalSupply
            )
        }
    }

    fun toDomain(): CoinData {
        return CoinData(
            blockTimeInMinutes = blockTimeInMinutes,
            countryOrigin = countryOrigin,
            description = description.toDomain(),
            genesisDate = genesisDate,
            hashingAlgorithm = hashingAlgorithm,
            id = id,
            image = image.toDomain(),
            lastUpdated = lastUpdated,
            links = links.toDomain(),
            localization = localization.toDomain(),
            marketCapRank = marketCapRank,
            marketData = marketData.toDomain(),
            name = name,
            previewListing = previewListing,
            symbol = symbol,
            url = links.homepage.firstOrNull(),
        )
    }
}