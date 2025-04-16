package dev.vincenzocostagliola.data.dto


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class CoinDataDto(
    @SerialName("additional_notices")
    val additionalNotices: List<Any?>,
    @SerialName("asset_platform_id")
    val assetPlatformId: Any?,
    @SerialName("block_time_in_minutes")
    val blockTimeInMinutes: Int,
    @SerialName("categories")
    val categories: List<String>,
    @SerialName("community_data")
    val communityData: CommunityData,
    @SerialName("country_origin")
    val countryOrigin: String,
    @SerialName("description")
    val description: Description,
    @SerialName("detail_platforms")
    val detailPlatforms: DetailPlatforms,
    @SerialName("developer_data")
    val developerData: DeveloperData,
    @SerialName("genesis_date")
    val genesisDate: String,
    @SerialName("hashing_algorithm")
    val hashingAlgorithm: String,
    @SerialName("id")
    val id: String,
    @SerialName("image")
    val image: Image,
    @SerialName("last_updated")
    val lastUpdated: String,
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
    @SerialName("platforms")
    val platforms: Platforms,
    @SerialName("preview_listing")
    val previewListing: Boolean,
    @SerialName("public_notice")
    val publicNotice: Any?,
    @SerialName("sentiment_votes_down_percentage")
    val sentimentVotesDownPercentage: Double,
    @SerialName("sentiment_votes_up_percentage")
    val sentimentVotesUpPercentage: Double,
    @SerialName("status_updates")
    val statusUpdates: List<Any?>,
    @SerialName("symbol")
    val symbol: String,
    @SerialName("tickers")
    val tickers: List<Ticker>,
    @SerialName("watchlist_portfolio_users")
    val watchlistPortfolioUsers: Int,
    @SerialName("web_slug")
    val webSlug: String
) {
    @Serializable
    data class CommunityData(
        @SerialName("facebook_likes")
        val facebookLikes: Any?,
        @SerialName("reddit_accounts_active_48h")
        val redditAccountsActive48h: Int,
        @SerialName("reddit_average_comments_48h")
        val redditAverageComments48h: Int,
        @SerialName("reddit_average_posts_48h")
        val redditAveragePosts48h: Int,
        @SerialName("reddit_subscribers")
        val redditSubscribers: Int,
        @SerialName("telegram_channel_user_count")
        val telegramChannelUserCount: Any?,
        @SerialName("twitter_followers")
        val twitterFollowers: Int
    )

    @Serializable
    data class Description(
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
        val `it`: String,
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
    )

    @Serializable
    data class DetailPlatforms(
        @SerialName("")
        val x: X
    ) {
        @Serializable
        data class X(
            @SerialName("contract_address")
            val contractAddress: String,
            @SerialName("decimal_place")
            val decimalPlace: Any?
        )
    }

    @Serializable
    data class DeveloperData(
        @SerialName("closed_issues")
        val closedIssues: Int,
        @SerialName("code_additions_deletions_4_weeks")
        val codeAdditionsDeletions4Weeks: CodeAdditionsDeletions4Weeks,
        @SerialName("commit_count_4_weeks")
        val commitCount4Weeks: Int,
        @SerialName("forks")
        val forks: Int,
        @SerialName("last_4_weeks_commit_activity_series")
        val last4WeeksCommitActivitySeries: List<Any?>,
        @SerialName("pull_request_contributors")
        val pullRequestContributors: Int,
        @SerialName("pull_requests_merged")
        val pullRequestsMerged: Int,
        @SerialName("stars")
        val stars: Int,
        @SerialName("subscribers")
        val subscribers: Int,
        @SerialName("total_issues")
        val totalIssues: Int
    ) {
        @Serializable
        data class CodeAdditionsDeletions4Weeks(
            @SerialName("additions")
            val additions: Int,
            @SerialName("deletions")
            val deletions: Int
        )
    }

    @Serializable
    data class Image(
        @SerialName("large")
        val large: String,
        @SerialName("small")
        val small: String,
        @SerialName("thumb")
        val thumb: String
    )

    @Serializable
    data class Links(
        @SerialName("announcement_url")
        val announcementUrl: List<Any?>,
        @SerialName("bitcointalk_thread_identifier")
        val bitcointalkThreadIdentifier: Any?,
        @SerialName("blockchain_site")
        val blockchainSite: List<String>,
        @SerialName("chat_url")
        val chatUrl: List<Any?>,
        @SerialName("facebook_username")
        val facebookUsername: String,
        @SerialName("homepage")
        val homepage: List<String>,
        @SerialName("official_forum_url")
        val officialForumUrl: List<String>,
        @SerialName("repos_url")
        val reposUrl: ReposUrl,
        @SerialName("snapshot_url")
        val snapshotUrl: Any?,
        @SerialName("subreddit_url")
        val subredditUrl: String,
        @SerialName("telegram_channel_identifier")
        val telegramChannelIdentifier: String,
        @SerialName("twitter_screen_name")
        val twitterScreenName: String,
        @SerialName("whitepaper")
        val whitepaper: String
    ) {
        @Serializable
        data class ReposUrl(
            @SerialName("bitbucket")
            val bitbucket: List<Any?>,
            @SerialName("github")
            val github: List<String>
        )
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
        val `it`: String,
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
    )

    @Serializable
    data class MarketData(
        @SerialName("ath")
        val ath: Ath,
        @SerialName("ath_change_percentage")
        val athChangePercentage: AthChangePercentage,
        @SerialName("ath_date")
        val athDate: AthDate,
        @SerialName("atl")
        val atl: Atl,
        @SerialName("atl_change_percentage")
        val atlChangePercentage: AtlChangePercentage,
        @SerialName("atl_date")
        val atlDate: AtlDate,
        @SerialName("circulating_supply")
        val circulatingSupply: Int,
        @SerialName("current_price")
        val currentPrice: CurrentPrice,
        @SerialName("fdv_to_tvl_ratio")
        val fdvToTvlRatio: Any?,
        @SerialName("fully_diluted_valuation")
        val fullyDilutedValuation: FullyDilutedValuation,
        @SerialName("high_24h")
        val high24h: High24h,
        @SerialName("last_updated")
        val lastUpdated: String,
        @SerialName("low_24h")
        val low24h: Low24h,
        @SerialName("market_cap")
        val marketCap: MarketCap,
        @SerialName("market_cap_change_24h")
        val marketCapChange24h: Double,
        @SerialName("market_cap_change_24h_in_currency")
        val marketCapChange24hInCurrency: MarketCapChange24hInCurrency,
        @SerialName("market_cap_change_percentage_24h")
        val marketCapChangePercentage24h: Double,
        @SerialName("market_cap_change_percentage_24h_in_currency")
        val marketCapChangePercentage24hInCurrency: MarketCapChangePercentage24hInCurrency,
        @SerialName("market_cap_fdv_ratio")
        val marketCapFdvRatio: Int,
        @SerialName("market_cap_rank")
        val marketCapRank: Int,
        @SerialName("max_supply")
        val maxSupply: Int,
        @SerialName("max_supply_infinite")
        val maxSupplyInfinite: Boolean,
        @SerialName("mcap_to_tvl_ratio")
        val mcapToTvlRatio: Any?,
        @SerialName("price_change_24h")
        val priceChange24h: Double,
        @SerialName("price_change_24h_in_currency")
        val priceChange24hInCurrency: PriceChange24hInCurrency,
        @SerialName("price_change_percentage_14d")
        val priceChangePercentage14d: Double,
        @SerialName("price_change_percentage_14d_in_currency")
        val priceChangePercentage14dInCurrency: PriceChangePercentage14dInCurrency,
        @SerialName("price_change_percentage_1h_in_currency")
        val priceChangePercentage1hInCurrency: PriceChangePercentage1hInCurrency,
        @SerialName("price_change_percentage_1y")
        val priceChangePercentage1y: Double,
        @SerialName("price_change_percentage_1y_in_currency")
        val priceChangePercentage1yInCurrency: PriceChangePercentage1yInCurrency,
        @SerialName("price_change_percentage_200d")
        val priceChangePercentage200d: Double,
        @SerialName("price_change_percentage_200d_in_currency")
        val priceChangePercentage200dInCurrency: PriceChangePercentage200dInCurrency,
        @SerialName("price_change_percentage_24h")
        val priceChangePercentage24h: Double,
        @SerialName("price_change_percentage_24h_in_currency")
        val priceChangePercentage24hInCurrency: PriceChangePercentage24hInCurrency,
        @SerialName("price_change_percentage_30d")
        val priceChangePercentage30d: Double,
        @SerialName("price_change_percentage_30d_in_currency")
        val priceChangePercentage30dInCurrency: PriceChangePercentage30dInCurrency,
        @SerialName("price_change_percentage_60d")
        val priceChangePercentage60d: Double,
        @SerialName("price_change_percentage_60d_in_currency")
        val priceChangePercentage60dInCurrency: PriceChangePercentage60dInCurrency,
        @SerialName("price_change_percentage_7d")
        val priceChangePercentage7d: Double,
        @SerialName("price_change_percentage_7d_in_currency")
        val priceChangePercentage7dInCurrency: PriceChangePercentage7dInCurrency,
        @SerialName("roi")
        val roi: Any?,
        @SerialName("total_supply")
        val totalSupply: Int,
        @SerialName("total_value_locked")
        val totalValueLocked: Any?,
        @SerialName("total_volume")
        val totalVolume: TotalVolume
    ) {
        @Serializable
        data class Ath(
            @SerialName("aed")
            val aed: Int,
            @SerialName("ars")
            val ars: Int,
            @SerialName("aud")
            val aud: Int,
            @SerialName("bch")
            val bch: Double,
            @SerialName("bdt")
            val bdt: Int,
            @SerialName("bhd")
            val bhd: Int,
            @SerialName("bits")
            val bits: Int,
            @SerialName("bmd")
            val bmd: Int,
            @SerialName("bnb")
            val bnb: Int,
            @SerialName("brl")
            val brl: Int,
            @SerialName("btc")
            val btc: Double,
            @SerialName("cad")
            val cad: Int,
            @SerialName("chf")
            val chf: Int,
            @SerialName("clp")
            val clp: Int,
            @SerialName("cny")
            val cny: Int,
            @SerialName("czk")
            val czk: Int,
            @SerialName("dkk")
            val dkk: Int,
            @SerialName("dot")
            val dot: Int,
            @SerialName("eos")
            val eos: Int,
            @SerialName("eth")
            val eth: Double,
            @SerialName("eur")
            val eur: Int,
            @SerialName("gbp")
            val gbp: Int,
            @SerialName("gel")
            val gel: Int,
            @SerialName("hkd")
            val hkd: Int,
            @SerialName("huf")
            val huf: Int,
            @SerialName("idr")
            val idr: Int,
            @SerialName("ils")
            val ils: Int,
            @SerialName("inr")
            val inr: Int,
            @SerialName("jpy")
            val jpy: Int,
            @SerialName("krw")
            val krw: Int,
            @SerialName("kwd")
            val kwd: Int,
            @SerialName("link")
            val link: Int,
            @SerialName("lkr")
            val lkr: Int,
            @SerialName("ltc")
            val ltc: Int,
            @SerialName("mmk")
            val mmk: Int,
            @SerialName("mxn")
            val mxn: Int,
            @SerialName("myr")
            val myr: Int,
            @SerialName("ngn")
            val ngn: Int,
            @SerialName("nok")
            val nok: Int,
            @SerialName("nzd")
            val nzd: Int,
            @SerialName("php")
            val php: Int,
            @SerialName("pkr")
            val pkr: Int,
            @SerialName("pln")
            val pln: Int,
            @SerialName("rub")
            val rub: Int,
            @SerialName("sar")
            val sar: Int,
            @SerialName("sats")
            val sats: Int,
            @SerialName("sek")
            val sek: Int,
            @SerialName("sgd")
            val sgd: Int,
            @SerialName("thb")
            val thb: Int,
            @SerialName("try")
            val tryX: Int,
            @SerialName("twd")
            val twd: Int,
            @SerialName("uah")
            val uah: Int,
            @SerialName("usd")
            val usd: Int,
            @SerialName("vef")
            val vef: Long,
            @SerialName("vnd")
            val vnd: Long,
            @SerialName("xag")
            val xag: Double,
            @SerialName("xau")
            val xau: Double,
            @SerialName("xdr")
            val xdr: Int,
            @SerialName("xlm")
            val xlm: Int,
            @SerialName("xrp")
            val xrp: Int,
            @SerialName("yfi")
            val yfi: Double,
            @SerialName("zar")
            val zar: Int
        )

        @Serializable
        data class AthChangePercentage(
            @SerialName("aed")
            val aed: Double,
            @SerialName("ars")
            val ars: Double,
            @SerialName("aud")
            val aud: Double,
            @SerialName("bch")
            val bch: Double,
            @SerialName("bdt")
            val bdt: Double,
            @SerialName("bhd")
            val bhd: Double,
            @SerialName("bits")
            val bits: Double,
            @SerialName("bmd")
            val bmd: Double,
            @SerialName("bnb")
            val bnb: Double,
            @SerialName("brl")
            val brl: Double,
            @SerialName("btc")
            val btc: Double,
            @SerialName("cad")
            val cad: Double,
            @SerialName("chf")
            val chf: Double,
            @SerialName("clp")
            val clp: Double,
            @SerialName("cny")
            val cny: Double,
            @SerialName("czk")
            val czk: Double,
            @SerialName("dkk")
            val dkk: Double,
            @SerialName("dot")
            val dot: Double,
            @SerialName("eos")
            val eos: Double,
            @SerialName("eth")
            val eth: Double,
            @SerialName("eur")
            val eur: Double,
            @SerialName("gbp")
            val gbp: Double,
            @SerialName("gel")
            val gel: Double,
            @SerialName("hkd")
            val hkd: Double,
            @SerialName("huf")
            val huf: Double,
            @SerialName("idr")
            val idr: Double,
            @SerialName("ils")
            val ils: Double,
            @SerialName("inr")
            val inr: Double,
            @SerialName("jpy")
            val jpy: Double,
            @SerialName("krw")
            val krw: Double,
            @SerialName("kwd")
            val kwd: Double,
            @SerialName("link")
            val link: Double,
            @SerialName("lkr")
            val lkr: Double,
            @SerialName("ltc")
            val ltc: Double,
            @SerialName("mmk")
            val mmk: Double,
            @SerialName("mxn")
            val mxn: Double,
            @SerialName("myr")
            val myr: Double,
            @SerialName("ngn")
            val ngn: Double,
            @SerialName("nok")
            val nok: Double,
            @SerialName("nzd")
            val nzd: Double,
            @SerialName("php")
            val php: Double,
            @SerialName("pkr")
            val pkr: Double,
            @SerialName("pln")
            val pln: Double,
            @SerialName("rub")
            val rub: Double,
            @SerialName("sar")
            val sar: Double,
            @SerialName("sats")
            val sats: Double,
            @SerialName("sek")
            val sek: Double,
            @SerialName("sgd")
            val sgd: Double,
            @SerialName("thb")
            val thb: Double,
            @SerialName("try")
            val tryX: Double,
            @SerialName("twd")
            val twd: Double,
            @SerialName("uah")
            val uah: Double,
            @SerialName("usd")
            val usd: Double,
            @SerialName("vef")
            val vef: Double,
            @SerialName("vnd")
            val vnd: Double,
            @SerialName("xag")
            val xag: Double,
            @SerialName("xau")
            val xau: Double,
            @SerialName("xdr")
            val xdr: Double,
            @SerialName("xlm")
            val xlm: Double,
            @SerialName("xrp")
            val xrp: Double,
            @SerialName("yfi")
            val yfi: Double,
            @SerialName("zar")
            val zar: Double
        )

        @Serializable
        data class AthDate(
            @SerialName("aed")
            val aed: String,
            @SerialName("ars")
            val ars: String,
            @SerialName("aud")
            val aud: String,
            @SerialName("bch")
            val bch: String,
            @SerialName("bdt")
            val bdt: String,
            @SerialName("bhd")
            val bhd: String,
            @SerialName("bits")
            val bits: String,
            @SerialName("bmd")
            val bmd: String,
            @SerialName("bnb")
            val bnb: String,
            @SerialName("brl")
            val brl: String,
            @SerialName("btc")
            val btc: String,
            @SerialName("cad")
            val cad: String,
            @SerialName("chf")
            val chf: String,
            @SerialName("clp")
            val clp: String,
            @SerialName("cny")
            val cny: String,
            @SerialName("czk")
            val czk: String,
            @SerialName("dkk")
            val dkk: String,
            @SerialName("dot")
            val dot: String,
            @SerialName("eos")
            val eos: String,
            @SerialName("eth")
            val eth: String,
            @SerialName("eur")
            val eur: String,
            @SerialName("gbp")
            val gbp: String,
            @SerialName("gel")
            val gel: String,
            @SerialName("hkd")
            val hkd: String,
            @SerialName("huf")
            val huf: String,
            @SerialName("idr")
            val idr: String,
            @SerialName("ils")
            val ils: String,
            @SerialName("inr")
            val inr: String,
            @SerialName("jpy")
            val jpy: String,
            @SerialName("krw")
            val krw: String,
            @SerialName("kwd")
            val kwd: String,
            @SerialName("link")
            val link: String,
            @SerialName("lkr")
            val lkr: String,
            @SerialName("ltc")
            val ltc: String,
            @SerialName("mmk")
            val mmk: String,
            @SerialName("mxn")
            val mxn: String,
            @SerialName("myr")
            val myr: String,
            @SerialName("ngn")
            val ngn: String,
            @SerialName("nok")
            val nok: String,
            @SerialName("nzd")
            val nzd: String,
            @SerialName("php")
            val php: String,
            @SerialName("pkr")
            val pkr: String,
            @SerialName("pln")
            val pln: String,
            @SerialName("rub")
            val rub: String,
            @SerialName("sar")
            val sar: String,
            @SerialName("sats")
            val sats: String,
            @SerialName("sek")
            val sek: String,
            @SerialName("sgd")
            val sgd: String,
            @SerialName("thb")
            val thb: String,
            @SerialName("try")
            val tryX: String,
            @SerialName("twd")
            val twd: String,
            @SerialName("uah")
            val uah: String,
            @SerialName("usd")
            val usd: String,
            @SerialName("vef")
            val vef: String,
            @SerialName("vnd")
            val vnd: String,
            @SerialName("xag")
            val xag: String,
            @SerialName("xau")
            val xau: String,
            @SerialName("xdr")
            val xdr: String,
            @SerialName("xlm")
            val xlm: String,
            @SerialName("xrp")
            val xrp: String,
            @SerialName("yfi")
            val yfi: String,
            @SerialName("zar")
            val zar: String
        )

        @Serializable
        data class Atl(
            @SerialName("aed")
            val aed: Double,
            @SerialName("ars")
            val ars: Double,
            @SerialName("aud")
            val aud: Double,
            @SerialName("bch")
            val bch: Double,
            @SerialName("bdt")
            val bdt: Double,
            @SerialName("bhd")
            val bhd: Double,
            @SerialName("bits")
            val bits: Int,
            @SerialName("bmd")
            val bmd: Double,
            @SerialName("bnb")
            val bnb: Double,
            @SerialName("brl")
            val brl: Double,
            @SerialName("btc")
            val btc: Double,
            @SerialName("cad")
            val cad: Double,
            @SerialName("chf")
            val chf: Double,
            @SerialName("clp")
            val clp: Int,
            @SerialName("cny")
            val cny: Double,
            @SerialName("czk")
            val czk: Double,
            @SerialName("dkk")
            val dkk: Double,
            @SerialName("dot")
            val dot: Double,
            @SerialName("eos")
            val eos: Double,
            @SerialName("eth")
            val eth: Double,
            @SerialName("eur")
            val eur: Double,
            @SerialName("gbp")
            val gbp: Double,
            @SerialName("gel")
            val gel: Int,
            @SerialName("hkd")
            val hkd: Double,
            @SerialName("huf")
            val huf: Int,
            @SerialName("idr")
            val idr: Int,
            @SerialName("ils")
            val ils: Double,
            @SerialName("inr")
            val inr: Double,
            @SerialName("jpy")
            val jpy: Double,
            @SerialName("krw")
            val krw: Int,
            @SerialName("kwd")
            val kwd: Double,
            @SerialName("link")
            val link: Double,
            @SerialName("lkr")
            val lkr: Int,
            @SerialName("ltc")
            val ltc: Double,
            @SerialName("mmk")
            val mmk: Int,
            @SerialName("mxn")
            val mxn: Double,
            @SerialName("myr")
            val myr: Double,
            @SerialName("ngn")
            val ngn: Double,
            @SerialName("nok")
            val nok: Double,
            @SerialName("nzd")
            val nzd: Double,
            @SerialName("php")
            val php: Double,
            @SerialName("pkr")
            val pkr: Double,
            @SerialName("pln")
            val pln: Double,
            @SerialName("rub")
            val rub: Double,
            @SerialName("sar")
            val sar: Double,
            @SerialName("sats")
            val sats: Int,
            @SerialName("sek")
            val sek: Double,
            @SerialName("sgd")
            val sgd: Double,
            @SerialName("thb")
            val thb: Double,
            @SerialName("try")
            val tryX: Double,
            @SerialName("twd")
            val twd: Double,
            @SerialName("uah")
            val uah: Double,
            @SerialName("usd")
            val usd: Double,
            @SerialName("vef")
            val vef: Double,
            @SerialName("vnd")
            val vnd: Int,
            @SerialName("xag")
            val xag: Double,
            @SerialName("xau")
            val xau: Double,
            @SerialName("xdr")
            val xdr: Double,
            @SerialName("xlm")
            val xlm: Int,
            @SerialName("xrp")
            val xrp: Int,
            @SerialName("yfi")
            val yfi: Double,
            @SerialName("zar")
            val zar: Double
        )

        @Serializable
        data class AtlChangePercentage(
            @SerialName("aed")
            val aed: Double,
            @SerialName("ars")
            val ars: Double,
            @SerialName("aud")
            val aud: Double,
            @SerialName("bch")
            val bch: Double,
            @SerialName("bdt")
            val bdt: Double,
            @SerialName("bhd")
            val bhd: Double,
            @SerialName("bits")
            val bits: Double,
            @SerialName("bmd")
            val bmd: Double,
            @SerialName("bnb")
            val bnb: Double,
            @SerialName("brl")
            val brl: Double,
            @SerialName("btc")
            val btc: Double,
            @SerialName("cad")
            val cad: Double,
            @SerialName("chf")
            val chf: Double,
            @SerialName("clp")
            val clp: Double,
            @SerialName("cny")
            val cny: Double,
            @SerialName("czk")
            val czk: Double,
            @SerialName("dkk")
            val dkk: Double,
            @SerialName("dot")
            val dot: Double,
            @SerialName("eos")
            val eos: Double,
            @SerialName("eth")
            val eth: Double,
            @SerialName("eur")
            val eur: Double,
            @SerialName("gbp")
            val gbp: Double,
            @SerialName("gel")
            val gel: Double,
            @SerialName("hkd")
            val hkd: Double,
            @SerialName("huf")
            val huf: Double,
            @SerialName("idr")
            val idr: Double,
            @SerialName("ils")
            val ils: Double,
            @SerialName("inr")
            val inr: Double,
            @SerialName("jpy")
            val jpy: Double,
            @SerialName("krw")
            val krw: Double,
            @SerialName("kwd")
            val kwd: Double,
            @SerialName("link")
            val link: Double,
            @SerialName("lkr")
            val lkr: Double,
            @SerialName("ltc")
            val ltc: Double,
            @SerialName("mmk")
            val mmk: Double,
            @SerialName("mxn")
            val mxn: Double,
            @SerialName("myr")
            val myr: Double,
            @SerialName("ngn")
            val ngn: Double,
            @SerialName("nok")
            val nok: Double,
            @SerialName("nzd")
            val nzd: Double,
            @SerialName("php")
            val php: Double,
            @SerialName("pkr")
            val pkr: Double,
            @SerialName("pln")
            val pln: Double,
            @SerialName("rub")
            val rub: Double,
            @SerialName("sar")
            val sar: Double,
            @SerialName("sats")
            val sats: Double,
            @SerialName("sek")
            val sek: Double,
            @SerialName("sgd")
            val sgd: Double,
            @SerialName("thb")
            val thb: Double,
            @SerialName("try")
            val tryX: Double,
            @SerialName("twd")
            val twd: Double,
            @SerialName("uah")
            val uah: Double,
            @SerialName("usd")
            val usd: Double,
            @SerialName("vef")
            val vef: Double,
            @SerialName("vnd")
            val vnd: Double,
            @SerialName("xag")
            val xag: Double,
            @SerialName("xau")
            val xau: Double,
            @SerialName("xdr")
            val xdr: Double,
            @SerialName("xlm")
            val xlm: Double,
            @SerialName("xrp")
            val xrp: Double,
            @SerialName("yfi")
            val yfi: Double,
            @SerialName("zar")
            val zar: Double
        )

        @Serializable
        data class AtlDate(
            @SerialName("aed")
            val aed: String,
            @SerialName("ars")
            val ars: String,
            @SerialName("aud")
            val aud: String,
            @SerialName("bch")
            val bch: String,
            @SerialName("bdt")
            val bdt: String,
            @SerialName("bhd")
            val bhd: String,
            @SerialName("bits")
            val bits: String,
            @SerialName("bmd")
            val bmd: String,
            @SerialName("bnb")
            val bnb: String,
            @SerialName("brl")
            val brl: String,
            @SerialName("btc")
            val btc: String,
            @SerialName("cad")
            val cad: String,
            @SerialName("chf")
            val chf: String,
            @SerialName("clp")
            val clp: String,
            @SerialName("cny")
            val cny: String,
            @SerialName("czk")
            val czk: String,
            @SerialName("dkk")
            val dkk: String,
            @SerialName("dot")
            val dot: String,
            @SerialName("eos")
            val eos: String,
            @SerialName("eth")
            val eth: String,
            @SerialName("eur")
            val eur: String,
            @SerialName("gbp")
            val gbp: String,
            @SerialName("gel")
            val gel: String,
            @SerialName("hkd")
            val hkd: String,
            @SerialName("huf")
            val huf: String,
            @SerialName("idr")
            val idr: String,
            @SerialName("ils")
            val ils: String,
            @SerialName("inr")
            val inr: String,
            @SerialName("jpy")
            val jpy: String,
            @SerialName("krw")
            val krw: String,
            @SerialName("kwd")
            val kwd: String,
            @SerialName("link")
            val link: String,
            @SerialName("lkr")
            val lkr: String,
            @SerialName("ltc")
            val ltc: String,
            @SerialName("mmk")
            val mmk: String,
            @SerialName("mxn")
            val mxn: String,
            @SerialName("myr")
            val myr: String,
            @SerialName("ngn")
            val ngn: String,
            @SerialName("nok")
            val nok: String,
            @SerialName("nzd")
            val nzd: String,
            @SerialName("php")
            val php: String,
            @SerialName("pkr")
            val pkr: String,
            @SerialName("pln")
            val pln: String,
            @SerialName("rub")
            val rub: String,
            @SerialName("sar")
            val sar: String,
            @SerialName("sats")
            val sats: String,
            @SerialName("sek")
            val sek: String,
            @SerialName("sgd")
            val sgd: String,
            @SerialName("thb")
            val thb: String,
            @SerialName("try")
            val tryX: String,
            @SerialName("twd")
            val twd: String,
            @SerialName("uah")
            val uah: String,
            @SerialName("usd")
            val usd: String,
            @SerialName("vef")
            val vef: String,
            @SerialName("vnd")
            val vnd: String,
            @SerialName("xag")
            val xag: String,
            @SerialName("xau")
            val xau: String,
            @SerialName("xdr")
            val xdr: String,
            @SerialName("xlm")
            val xlm: String,
            @SerialName("xrp")
            val xrp: String,
            @SerialName("yfi")
            val yfi: String,
            @SerialName("zar")
            val zar: String
        )

        @Serializable
        data class CurrentPrice(
            @SerialName("aed")
            val aed: Int,
            @SerialName("ars")
            val ars: Int,
            @SerialName("aud")
            val aud: Int,
            @SerialName("bch")
            val bch: Double,
            @SerialName("bdt")
            val bdt: Int,
            @SerialName("bhd")
            val bhd: Int,
            @SerialName("bits")
            val bits: Int,
            @SerialName("bmd")
            val bmd: Int,
            @SerialName("bnb")
            val bnb: Double,
            @SerialName("brl")
            val brl: Int,
            @SerialName("btc")
            val btc: Int,
            @SerialName("cad")
            val cad: Int,
            @SerialName("chf")
            val chf: Int,
            @SerialName("clp")
            val clp: Int,
            @SerialName("cny")
            val cny: Int,
            @SerialName("czk")
            val czk: Int,
            @SerialName("dkk")
            val dkk: Int,
            @SerialName("dot")
            val dot: Int,
            @SerialName("eos")
            val eos: Int,
            @SerialName("eth")
            val eth: Double,
            @SerialName("eur")
            val eur: Int,
            @SerialName("gbp")
            val gbp: Int,
            @SerialName("gel")
            val gel: Int,
            @SerialName("hkd")
            val hkd: Int,
            @SerialName("huf")
            val huf: Int,
            @SerialName("idr")
            val idr: Int,
            @SerialName("ils")
            val ils: Int,
            @SerialName("inr")
            val inr: Int,
            @SerialName("jpy")
            val jpy: Int,
            @SerialName("krw")
            val krw: Int,
            @SerialName("kwd")
            val kwd: Int,
            @SerialName("link")
            val link: Int,
            @SerialName("lkr")
            val lkr: Int,
            @SerialName("ltc")
            val ltc: Int,
            @SerialName("mmk")
            val mmk: Int,
            @SerialName("mxn")
            val mxn: Int,
            @SerialName("myr")
            val myr: Int,
            @SerialName("ngn")
            val ngn: Int,
            @SerialName("nok")
            val nok: Int,
            @SerialName("nzd")
            val nzd: Int,
            @SerialName("php")
            val php: Int,
            @SerialName("pkr")
            val pkr: Int,
            @SerialName("pln")
            val pln: Int,
            @SerialName("rub")
            val rub: Int,
            @SerialName("sar")
            val sar: Int,
            @SerialName("sats")
            val sats: Int,
            @SerialName("sek")
            val sek: Int,
            @SerialName("sgd")
            val sgd: Int,
            @SerialName("thb")
            val thb: Int,
            @SerialName("try")
            val tryX: Int,
            @SerialName("twd")
            val twd: Int,
            @SerialName("uah")
            val uah: Int,
            @SerialName("usd")
            val usd: Int,
            @SerialName("vef")
            val vef: Double,
            @SerialName("vnd")
            val vnd: Long,
            @SerialName("xag")
            val xag: Double,
            @SerialName("xau")
            val xau: Double,
            @SerialName("xdr")
            val xdr: Int,
            @SerialName("xlm")
            val xlm: Int,
            @SerialName("xrp")
            val xrp: Int,
            @SerialName("yfi")
            val yfi: Double,
            @SerialName("zar")
            val zar: Int
        )

        @Serializable
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

        @Serializable
        data class High24h(
            @SerialName("aed")
            val aed: Int,
            @SerialName("ars")
            val ars: Int,
            @SerialName("aud")
            val aud: Int,
            @SerialName("bch")
            val bch: Double,
            @SerialName("bdt")
            val bdt: Int,
            @SerialName("bhd")
            val bhd: Int,
            @SerialName("bits")
            val bits: Int,
            @SerialName("bmd")
            val bmd: Int,
            @SerialName("bnb")
            val bnb: Double,
            @SerialName("brl")
            val brl: Int,
            @SerialName("btc")
            val btc: Int,
            @SerialName("cad")
            val cad: Int,
            @SerialName("chf")
            val chf: Int,
            @SerialName("clp")
            val clp: Int,
            @SerialName("cny")
            val cny: Int,
            @SerialName("czk")
            val czk: Int,
            @SerialName("dkk")
            val dkk: Int,
            @SerialName("dot")
            val dot: Int,
            @SerialName("eos")
            val eos: Int,
            @SerialName("eth")
            val eth: Double,
            @SerialName("eur")
            val eur: Int,
            @SerialName("gbp")
            val gbp: Int,
            @SerialName("gel")
            val gel: Int,
            @SerialName("hkd")
            val hkd: Int,
            @SerialName("huf")
            val huf: Int,
            @SerialName("idr")
            val idr: Int,
            @SerialName("ils")
            val ils: Int,
            @SerialName("inr")
            val inr: Int,
            @SerialName("jpy")
            val jpy: Int,
            @SerialName("krw")
            val krw: Int,
            @SerialName("kwd")
            val kwd: Int,
            @SerialName("link")
            val link: Int,
            @SerialName("lkr")
            val lkr: Int,
            @SerialName("ltc")
            val ltc: Int,
            @SerialName("mmk")
            val mmk: Int,
            @SerialName("mxn")
            val mxn: Int,
            @SerialName("myr")
            val myr: Int,
            @SerialName("ngn")
            val ngn: Int,
            @SerialName("nok")
            val nok: Int,
            @SerialName("nzd")
            val nzd: Int,
            @SerialName("php")
            val php: Int,
            @SerialName("pkr")
            val pkr: Int,
            @SerialName("pln")
            val pln: Int,
            @SerialName("rub")
            val rub: Int,
            @SerialName("sar")
            val sar: Int,
            @SerialName("sats")
            val sats: Int,
            @SerialName("sek")
            val sek: Int,
            @SerialName("sgd")
            val sgd: Int,
            @SerialName("thb")
            val thb: Int,
            @SerialName("try")
            val tryX: Int,
            @SerialName("twd")
            val twd: Int,
            @SerialName("uah")
            val uah: Int,
            @SerialName("usd")
            val usd: Int,
            @SerialName("vef")
            val vef: Double,
            @SerialName("vnd")
            val vnd: Long,
            @SerialName("xag")
            val xag: Double,
            @SerialName("xau")
            val xau: Double,
            @SerialName("xdr")
            val xdr: Int,
            @SerialName("xlm")
            val xlm: Int,
            @SerialName("xrp")
            val xrp: Int,
            @SerialName("yfi")
            val yfi: Double,
            @SerialName("zar")
            val zar: Int
        )

        @Serializable
        data class Low24h(
            @SerialName("aed")
            val aed: Int,
            @SerialName("ars")
            val ars: Int,
            @SerialName("aud")
            val aud: Int,
            @SerialName("bch")
            val bch: Double,
            @SerialName("bdt")
            val bdt: Int,
            @SerialName("bhd")
            val bhd: Int,
            @SerialName("bits")
            val bits: Int,
            @SerialName("bmd")
            val bmd: Int,
            @SerialName("bnb")
            val bnb: Double,
            @SerialName("brl")
            val brl: Int,
            @SerialName("btc")
            val btc: Int,
            @SerialName("cad")
            val cad: Int,
            @SerialName("chf")
            val chf: Int,
            @SerialName("clp")
            val clp: Int,
            @SerialName("cny")
            val cny: Int,
            @SerialName("czk")
            val czk: Int,
            @SerialName("dkk")
            val dkk: Int,
            @SerialName("dot")
            val dot: Int,
            @SerialName("eos")
            val eos: Int,
            @SerialName("eth")
            val eth: Double,
            @SerialName("eur")
            val eur: Int,
            @SerialName("gbp")
            val gbp: Int,
            @SerialName("gel")
            val gel: Int,
            @SerialName("hkd")
            val hkd: Int,
            @SerialName("huf")
            val huf: Int,
            @SerialName("idr")
            val idr: Int,
            @SerialName("ils")
            val ils: Int,
            @SerialName("inr")
            val inr: Int,
            @SerialName("jpy")
            val jpy: Int,
            @SerialName("krw")
            val krw: Int,
            @SerialName("kwd")
            val kwd: Int,
            @SerialName("link")
            val link: Int,
            @SerialName("lkr")
            val lkr: Int,
            @SerialName("ltc")
            val ltc: Int,
            @SerialName("mmk")
            val mmk: Int,
            @SerialName("mxn")
            val mxn: Int,
            @SerialName("myr")
            val myr: Int,
            @SerialName("ngn")
            val ngn: Int,
            @SerialName("nok")
            val nok: Int,
            @SerialName("nzd")
            val nzd: Int,
            @SerialName("php")
            val php: Int,
            @SerialName("pkr")
            val pkr: Int,
            @SerialName("pln")
            val pln: Int,
            @SerialName("rub")
            val rub: Int,
            @SerialName("sar")
            val sar: Int,
            @SerialName("sats")
            val sats: Int,
            @SerialName("sek")
            val sek: Int,
            @SerialName("sgd")
            val sgd: Int,
            @SerialName("thb")
            val thb: Int,
            @SerialName("try")
            val tryX: Int,
            @SerialName("twd")
            val twd: Int,
            @SerialName("uah")
            val uah: Int,
            @SerialName("usd")
            val usd: Int,
            @SerialName("vef")
            val vef: Double,
            @SerialName("vnd")
            val vnd: Long,
            @SerialName("xag")
            val xag: Double,
            @SerialName("xau")
            val xau: Double,
            @SerialName("xdr")
            val xdr: Int,
            @SerialName("xlm")
            val xlm: Int,
            @SerialName("xrp")
            val xrp: Int,
            @SerialName("yfi")
            val yfi: Double,
            @SerialName("zar")
            val zar: Int
        )

        @Serializable
        data class MarketCap(
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

        @Serializable
        data class MarketCapChange24hInCurrency(
            @SerialName("aed")
            val aed: Double,
            @SerialName("ars")
            val ars: Double,
            @SerialName("aud")
            val aud: Double,
            @SerialName("bch")
            val bch: Int,
            @SerialName("bdt")
            val bdt: Double,
            @SerialName("bhd")
            val bhd: Double,
            @SerialName("bits")
            val bits: Long,
            @SerialName("bmd")
            val bmd: Double,
            @SerialName("bnb")
            val bnb: Double,
            @SerialName("brl")
            val brl: Double,
            @SerialName("btc")
            val btc: Int,
            @SerialName("cad")
            val cad: Double,
            @SerialName("chf")
            val chf: Double,
            @SerialName("clp")
            val clp: Double,
            @SerialName("cny")
            val cny: Double,
            @SerialName("czk")
            val czk: Double,
            @SerialName("dkk")
            val dkk: Double,
            @SerialName("dot")
            val dot: Long,
            @SerialName("eos")
            val eos: Double,
            @SerialName("eth")
            val eth: Int,
            @SerialName("eur")
            val eur: Double,
            @SerialName("gbp")
            val gbp: Double,
            @SerialName("gel")
            val gel: Double,
            @SerialName("hkd")
            val hkd: Double,
            @SerialName("huf")
            val huf: Double,
            @SerialName("idr")
            val idr: Long,
            @SerialName("ils")
            val ils: Double,
            @SerialName("inr")
            val inr: Double,
            @SerialName("jpy")
            val jpy: Double,
            @SerialName("krw")
            val krw: Long,
            @SerialName("kwd")
            val kwd: Double,
            @SerialName("link")
            val link: Long,
            @SerialName("lkr")
            val lkr: Double,
            @SerialName("ltc")
            val ltc: Int,
            @SerialName("mmk")
            val mmk: Double,
            @SerialName("mxn")
            val mxn: Double,
            @SerialName("myr")
            val myr: Double,
            @SerialName("ngn")
            val ngn: Double,
            @SerialName("nok")
            val nok: Double,
            @SerialName("nzd")
            val nzd: Double,
            @SerialName("php")
            val php: Double,
            @SerialName("pkr")
            val pkr: Double,
            @SerialName("pln")
            val pln: Double,
            @SerialName("rub")
            val rub: Double,
            @SerialName("sar")
            val sar: Double,
            @SerialName("sats")
            val sats: Long,
            @SerialName("sek")
            val sek: Double,
            @SerialName("sgd")
            val sgd: Double,
            @SerialName("thb")
            val thb: Double,
            @SerialName("try")
            val tryX: Double,
            @SerialName("twd")
            val twd: Double,
            @SerialName("uah")
            val uah: Double,
            @SerialName("usd")
            val usd: Double,
            @SerialName("vef")
            val vef: Double,
            @SerialName("vnd")
            val vnd: Long,
            @SerialName("xag")
            val xag: Double,
            @SerialName("xau")
            val xau: Double,
            @SerialName("xdr")
            val xdr: Double,
            @SerialName("xlm")
            val xlm: Long,
            @SerialName("xrp")
            val xrp: Long,
            @SerialName("yfi")
            val yfi: Double,
            @SerialName("zar")
            val zar: Double
        )

        @Serializable
        data class MarketCapChangePercentage24hInCurrency(
            @SerialName("aed")
            val aed: Double,
            @SerialName("ars")
            val ars: Double,
            @SerialName("aud")
            val aud: Double,
            @SerialName("bch")
            val bch: Double,
            @SerialName("bdt")
            val bdt: Double,
            @SerialName("bhd")
            val bhd: Double,
            @SerialName("bits")
            val bits: Double,
            @SerialName("bmd")
            val bmd: Double,
            @SerialName("bnb")
            val bnb: Double,
            @SerialName("brl")
            val brl: Double,
            @SerialName("btc")
            val btc: Double,
            @SerialName("cad")
            val cad: Double,
            @SerialName("chf")
            val chf: Double,
            @SerialName("clp")
            val clp: Double,
            @SerialName("cny")
            val cny: Double,
            @SerialName("czk")
            val czk: Double,
            @SerialName("dkk")
            val dkk: Double,
            @SerialName("dot")
            val dot: Double,
            @SerialName("eos")
            val eos: Double,
            @SerialName("eth")
            val eth: Double,
            @SerialName("eur")
            val eur: Double,
            @SerialName("gbp")
            val gbp: Double,
            @SerialName("gel")
            val gel: Double,
            @SerialName("hkd")
            val hkd: Double,
            @SerialName("huf")
            val huf: Double,
            @SerialName("idr")
            val idr: Double,
            @SerialName("ils")
            val ils: Double,
            @SerialName("inr")
            val inr: Double,
            @SerialName("jpy")
            val jpy: Double,
            @SerialName("krw")
            val krw: Double,
            @SerialName("kwd")
            val kwd: Double,
            @SerialName("link")
            val link: Double,
            @SerialName("lkr")
            val lkr: Double,
            @SerialName("ltc")
            val ltc: Double,
            @SerialName("mmk")
            val mmk: Double,
            @SerialName("mxn")
            val mxn: Double,
            @SerialName("myr")
            val myr: Double,
            @SerialName("ngn")
            val ngn: Double,
            @SerialName("nok")
            val nok: Double,
            @SerialName("nzd")
            val nzd: Double,
            @SerialName("php")
            val php: Double,
            @SerialName("pkr")
            val pkr: Double,
            @SerialName("pln")
            val pln: Double,
            @SerialName("rub")
            val rub: Double,
            @SerialName("sar")
            val sar: Double,
            @SerialName("sats")
            val sats: Double,
            @SerialName("sek")
            val sek: Double,
            @SerialName("sgd")
            val sgd: Double,
            @SerialName("thb")
            val thb: Double,
            @SerialName("try")
            val tryX: Double,
            @SerialName("twd")
            val twd: Double,
            @SerialName("uah")
            val uah: Double,
            @SerialName("usd")
            val usd: Double,
            @SerialName("vef")
            val vef: Double,
            @SerialName("vnd")
            val vnd: Double,
            @SerialName("xag")
            val xag: Double,
            @SerialName("xau")
            val xau: Double,
            @SerialName("xdr")
            val xdr: Double,
            @SerialName("xlm")
            val xlm: Double,
            @SerialName("xrp")
            val xrp: Double,
            @SerialName("yfi")
            val yfi: Double,
            @SerialName("zar")
            val zar: Double
        )

        @Serializable
        data class PriceChange24hInCurrency(
            @SerialName("aed")
            val aed: Double,
            @SerialName("ars")
            val ars: Double,
            @SerialName("aud")
            val aud: Double,
            @SerialName("bch")
            val bch: Double,
            @SerialName("bdt")
            val bdt: Double,
            @SerialName("bhd")
            val bhd: Double,
            @SerialName("bits")
            val bits: Double,
            @SerialName("bmd")
            val bmd: Double,
            @SerialName("bnb")
            val bnb: Double,
            @SerialName("brl")
            val brl: Double,
            @SerialName("btc")
            val btc: Int,
            @SerialName("cad")
            val cad: Double,
            @SerialName("chf")
            val chf: Double,
            @SerialName("clp")
            val clp: Double,
            @SerialName("cny")
            val cny: Double,
            @SerialName("czk")
            val czk: Double,
            @SerialName("dkk")
            val dkk: Double,
            @SerialName("dot")
            val dot: Double,
            @SerialName("eos")
            val eos: Double,
            @SerialName("eth")
            val eth: Double,
            @SerialName("eur")
            val eur: Double,
            @SerialName("gbp")
            val gbp: Double,
            @SerialName("gel")
            val gel: Double,
            @SerialName("hkd")
            val hkd: Double,
            @SerialName("huf")
            val huf: Double,
            @SerialName("idr")
            val idr: Double,
            @SerialName("ils")
            val ils: Double,
            @SerialName("inr")
            val inr: Double,
            @SerialName("jpy")
            val jpy: Double,
            @SerialName("krw")
            val krw: Double,
            @SerialName("kwd")
            val kwd: Double,
            @SerialName("link")
            val link: Double,
            @SerialName("lkr")
            val lkr: Double,
            @SerialName("ltc")
            val ltc: Double,
            @SerialName("mmk")
            val mmk: Double,
            @SerialName("mxn")
            val mxn: Double,
            @SerialName("myr")
            val myr: Double,
            @SerialName("ngn")
            val ngn: Double,
            @SerialName("nok")
            val nok: Double,
            @SerialName("nzd")
            val nzd: Double,
            @SerialName("php")
            val php: Double,
            @SerialName("pkr")
            val pkr: Double,
            @SerialName("pln")
            val pln: Double,
            @SerialName("rub")
            val rub: Double,
            @SerialName("sar")
            val sar: Double,
            @SerialName("sats")
            val sats: Int,
            @SerialName("sek")
            val sek: Double,
            @SerialName("sgd")
            val sgd: Double,
            @SerialName("thb")
            val thb: Double,
            @SerialName("try")
            val tryX: Double,
            @SerialName("twd")
            val twd: Double,
            @SerialName("uah")
            val uah: Double,
            @SerialName("usd")
            val usd: Double,
            @SerialName("vef")
            val vef: Double,
            @SerialName("vnd")
            val vnd: Double,
            @SerialName("xag")
            val xag: Double,
            @SerialName("xau")
            val xau: Double,
            @SerialName("xdr")
            val xdr: Double,
            @SerialName("xlm")
            val xlm: Int,
            @SerialName("xrp")
            val xrp: Double,
            @SerialName("yfi")
            val yfi: Double,
            @SerialName("zar")
            val zar: Double
        )

        @Serializable
        data class PriceChangePercentage14dInCurrency(
            @SerialName("aed")
            val aed: Double,
            @SerialName("ars")
            val ars: Double,
            @SerialName("aud")
            val aud: Double,
            @SerialName("bch")
            val bch: Double,
            @SerialName("bdt")
            val bdt: Double,
            @SerialName("bhd")
            val bhd: Double,
            @SerialName("bits")
            val bits: Double,
            @SerialName("bmd")
            val bmd: Double,
            @SerialName("bnb")
            val bnb: Double,
            @SerialName("brl")
            val brl: Double,
            @SerialName("btc")
            val btc: Int,
            @SerialName("cad")
            val cad: Double,
            @SerialName("chf")
            val chf: Double,
            @SerialName("clp")
            val clp: Double,
            @SerialName("cny")
            val cny: Double,
            @SerialName("czk")
            val czk: Double,
            @SerialName("dkk")
            val dkk: Double,
            @SerialName("dot")
            val dot: Double,
            @SerialName("eos")
            val eos: Double,
            @SerialName("eth")
            val eth: Double,
            @SerialName("eur")
            val eur: Double,
            @SerialName("gbp")
            val gbp: Double,
            @SerialName("gel")
            val gel: Double,
            @SerialName("hkd")
            val hkd: Double,
            @SerialName("huf")
            val huf: Double,
            @SerialName("idr")
            val idr: Double,
            @SerialName("ils")
            val ils: Double,
            @SerialName("inr")
            val inr: Double,
            @SerialName("jpy")
            val jpy: Double,
            @SerialName("krw")
            val krw: Double,
            @SerialName("kwd")
            val kwd: Double,
            @SerialName("link")
            val link: Double,
            @SerialName("lkr")
            val lkr: Double,
            @SerialName("ltc")
            val ltc: Double,
            @SerialName("mmk")
            val mmk: Double,
            @SerialName("mxn")
            val mxn: Double,
            @SerialName("myr")
            val myr: Double,
            @SerialName("ngn")
            val ngn: Double,
            @SerialName("nok")
            val nok: Double,
            @SerialName("nzd")
            val nzd: Double,
            @SerialName("php")
            val php: Double,
            @SerialName("pkr")
            val pkr: Double,
            @SerialName("pln")
            val pln: Double,
            @SerialName("rub")
            val rub: Double,
            @SerialName("sar")
            val sar: Double,
            @SerialName("sats")
            val sats: Double,
            @SerialName("sek")
            val sek: Double,
            @SerialName("sgd")
            val sgd: Double,
            @SerialName("thb")
            val thb: Double,
            @SerialName("try")
            val tryX: Double,
            @SerialName("twd")
            val twd: Double,
            @SerialName("uah")
            val uah: Double,
            @SerialName("usd")
            val usd: Double,
            @SerialName("vef")
            val vef: Double,
            @SerialName("vnd")
            val vnd: Double,
            @SerialName("xag")
            val xag: Double,
            @SerialName("xau")
            val xau: Double,
            @SerialName("xdr")
            val xdr: Double,
            @SerialName("xlm")
            val xlm: Double,
            @SerialName("xrp")
            val xrp: Double,
            @SerialName("yfi")
            val yfi: Double,
            @SerialName("zar")
            val zar: Double
        )

        @Serializable
        data class PriceChangePercentage1hInCurrency(
            @SerialName("aed")
            val aed: Double,
            @SerialName("ars")
            val ars: Double,
            @SerialName("aud")
            val aud: Double,
            @SerialName("bch")
            val bch: Double,
            @SerialName("bdt")
            val bdt: Double,
            @SerialName("bhd")
            val bhd: Double,
            @SerialName("bits")
            val bits: Double,
            @SerialName("bmd")
            val bmd: Double,
            @SerialName("bnb")
            val bnb: Double,
            @SerialName("brl")
            val brl: Double,
            @SerialName("btc")
            val btc: Int,
            @SerialName("cad")
            val cad: Double,
            @SerialName("chf")
            val chf: Double,
            @SerialName("clp")
            val clp: Double,
            @SerialName("cny")
            val cny: Double,
            @SerialName("czk")
            val czk: Double,
            @SerialName("dkk")
            val dkk: Double,
            @SerialName("dot")
            val dot: Double,
            @SerialName("eos")
            val eos: Double,
            @SerialName("eth")
            val eth: Double,
            @SerialName("eur")
            val eur: Double,
            @SerialName("gbp")
            val gbp: Double,
            @SerialName("gel")
            val gel: Double,
            @SerialName("hkd")
            val hkd: Double,
            @SerialName("huf")
            val huf: Double,
            @SerialName("idr")
            val idr: Double,
            @SerialName("ils")
            val ils: Double,
            @SerialName("inr")
            val inr: Double,
            @SerialName("jpy")
            val jpy: Double,
            @SerialName("krw")
            val krw: Double,
            @SerialName("kwd")
            val kwd: Double,
            @SerialName("link")
            val link: Double,
            @SerialName("lkr")
            val lkr: Double,
            @SerialName("ltc")
            val ltc: Double,
            @SerialName("mmk")
            val mmk: Double,
            @SerialName("mxn")
            val mxn: Double,
            @SerialName("myr")
            val myr: Double,
            @SerialName("ngn")
            val ngn: Double,
            @SerialName("nok")
            val nok: Double,
            @SerialName("nzd")
            val nzd: Double,
            @SerialName("php")
            val php: Double,
            @SerialName("pkr")
            val pkr: Double,
            @SerialName("pln")
            val pln: Double,
            @SerialName("rub")
            val rub: Double,
            @SerialName("sar")
            val sar: Double,
            @SerialName("sats")
            val sats: Double,
            @SerialName("sek")
            val sek: Double,
            @SerialName("sgd")
            val sgd: Double,
            @SerialName("thb")
            val thb: Double,
            @SerialName("try")
            val tryX: Double,
            @SerialName("twd")
            val twd: Double,
            @SerialName("uah")
            val uah: Double,
            @SerialName("usd")
            val usd: Double,
            @SerialName("vef")
            val vef: Double,
            @SerialName("vnd")
            val vnd: Double,
            @SerialName("xag")
            val xag: Double,
            @SerialName("xau")
            val xau: Double,
            @SerialName("xdr")
            val xdr: Double,
            @SerialName("xlm")
            val xlm: Double,
            @SerialName("xrp")
            val xrp: Double,
            @SerialName("yfi")
            val yfi: Double,
            @SerialName("zar")
            val zar: Double
        )

        @Serializable
        data class PriceChangePercentage1yInCurrency(
            @SerialName("aed")
            val aed: Double,
            @SerialName("ars")
            val ars: Double,
            @SerialName("aud")
            val aud: Double,
            @SerialName("bch")
            val bch: Double,
            @SerialName("bdt")
            val bdt: Double,
            @SerialName("bhd")
            val bhd: Double,
            @SerialName("bits")
            val bits: Double,
            @SerialName("bmd")
            val bmd: Double,
            @SerialName("bnb")
            val bnb: Double,
            @SerialName("brl")
            val brl: Double,
            @SerialName("btc")
            val btc: Int,
            @SerialName("cad")
            val cad: Double,
            @SerialName("chf")
            val chf: Double,
            @SerialName("clp")
            val clp: Double,
            @SerialName("cny")
            val cny: Double,
            @SerialName("czk")
            val czk: Double,
            @SerialName("dkk")
            val dkk: Double,
            @SerialName("dot")
            val dot: Double,
            @SerialName("eos")
            val eos: Double,
            @SerialName("eth")
            val eth: Double,
            @SerialName("eur")
            val eur: Double,
            @SerialName("gbp")
            val gbp: Double,
            @SerialName("gel")
            val gel: Double,
            @SerialName("hkd")
            val hkd: Double,
            @SerialName("huf")
            val huf: Double,
            @SerialName("idr")
            val idr: Double,
            @SerialName("ils")
            val ils: Double,
            @SerialName("inr")
            val inr: Double,
            @SerialName("jpy")
            val jpy: Double,
            @SerialName("krw")
            val krw: Double,
            @SerialName("kwd")
            val kwd: Double,
            @SerialName("link")
            val link: Double,
            @SerialName("lkr")
            val lkr: Double,
            @SerialName("ltc")
            val ltc: Double,
            @SerialName("mmk")
            val mmk: Double,
            @SerialName("mxn")
            val mxn: Double,
            @SerialName("myr")
            val myr: Double,
            @SerialName("ngn")
            val ngn: Double,
            @SerialName("nok")
            val nok: Double,
            @SerialName("nzd")
            val nzd: Double,
            @SerialName("php")
            val php: Double,
            @SerialName("pkr")
            val pkr: Double,
            @SerialName("pln")
            val pln: Double,
            @SerialName("rub")
            val rub: Double,
            @SerialName("sar")
            val sar: Double,
            @SerialName("sats")
            val sats: Double,
            @SerialName("sek")
            val sek: Double,
            @SerialName("sgd")
            val sgd: Double,
            @SerialName("thb")
            val thb: Double,
            @SerialName("try")
            val tryX: Double,
            @SerialName("twd")
            val twd: Double,
            @SerialName("uah")
            val uah: Double,
            @SerialName("usd")
            val usd: Double,
            @SerialName("vef")
            val vef: Double,
            @SerialName("vnd")
            val vnd: Double,
            @SerialName("xag")
            val xag: Double,
            @SerialName("xau")
            val xau: Double,
            @SerialName("xdr")
            val xdr: Double,
            @SerialName("xlm")
            val xlm: Double,
            @SerialName("xrp")
            val xrp: Double,
            @SerialName("yfi")
            val yfi: Double,
            @SerialName("zar")
            val zar: Double
        )

        @Serializable
        data class PriceChangePercentage200dInCurrency(
            @SerialName("aed")
            val aed: Double,
            @SerialName("ars")
            val ars: Double,
            @SerialName("aud")
            val aud: Double,
            @SerialName("bch")
            val bch: Double,
            @SerialName("bdt")
            val bdt: Double,
            @SerialName("bhd")
            val bhd: Double,
            @SerialName("bits")
            val bits: Double,
            @SerialName("bmd")
            val bmd: Double,
            @SerialName("bnb")
            val bnb: Double,
            @SerialName("brl")
            val brl: Double,
            @SerialName("btc")
            val btc: Int,
            @SerialName("cad")
            val cad: Double,
            @SerialName("chf")
            val chf: Double,
            @SerialName("clp")
            val clp: Double,
            @SerialName("cny")
            val cny: Double,
            @SerialName("czk")
            val czk: Double,
            @SerialName("dkk")
            val dkk: Double,
            @SerialName("dot")
            val dot: Double,
            @SerialName("eos")
            val eos: Double,
            @SerialName("eth")
            val eth: Double,
            @SerialName("eur")
            val eur: Double,
            @SerialName("gbp")
            val gbp: Double,
            @SerialName("gel")
            val gel: Double,
            @SerialName("hkd")
            val hkd: Double,
            @SerialName("huf")
            val huf: Double,
            @SerialName("idr")
            val idr: Double,
            @SerialName("ils")
            val ils: Double,
            @SerialName("inr")
            val inr: Double,
            @SerialName("jpy")
            val jpy: Double,
            @SerialName("krw")
            val krw: Double,
            @SerialName("kwd")
            val kwd: Double,
            @SerialName("link")
            val link: Double,
            @SerialName("lkr")
            val lkr: Double,
            @SerialName("ltc")
            val ltc: Double,
            @SerialName("mmk")
            val mmk: Double,
            @SerialName("mxn")
            val mxn: Double,
            @SerialName("myr")
            val myr: Double,
            @SerialName("ngn")
            val ngn: Double,
            @SerialName("nok")
            val nok: Double,
            @SerialName("nzd")
            val nzd: Double,
            @SerialName("php")
            val php: Double,
            @SerialName("pkr")
            val pkr: Double,
            @SerialName("pln")
            val pln: Double,
            @SerialName("rub")
            val rub: Double,
            @SerialName("sar")
            val sar: Double,
            @SerialName("sats")
            val sats: Double,
            @SerialName("sek")
            val sek: Double,
            @SerialName("sgd")
            val sgd: Double,
            @SerialName("thb")
            val thb: Double,
            @SerialName("try")
            val tryX: Double,
            @SerialName("twd")
            val twd: Double,
            @SerialName("uah")
            val uah: Double,
            @SerialName("usd")
            val usd: Double,
            @SerialName("vef")
            val vef: Double,
            @SerialName("vnd")
            val vnd: Double,
            @SerialName("xag")
            val xag: Double,
            @SerialName("xau")
            val xau: Double,
            @SerialName("xdr")
            val xdr: Double,
            @SerialName("xlm")
            val xlm: Double,
            @SerialName("xrp")
            val xrp: Double,
            @SerialName("yfi")
            val yfi: Double,
            @SerialName("zar")
            val zar: Double
        )

        @Serializable
        data class PriceChangePercentage24hInCurrency(
            @SerialName("aed")
            val aed: Double,
            @SerialName("ars")
            val ars: Double,
            @SerialName("aud")
            val aud: Double,
            @SerialName("bch")
            val bch: Double,
            @SerialName("bdt")
            val bdt: Double,
            @SerialName("bhd")
            val bhd: Double,
            @SerialName("bits")
            val bits: Double,
            @SerialName("bmd")
            val bmd: Double,
            @SerialName("bnb")
            val bnb: Double,
            @SerialName("brl")
            val brl: Double,
            @SerialName("btc")
            val btc: Int,
            @SerialName("cad")
            val cad: Double,
            @SerialName("chf")
            val chf: Double,
            @SerialName("clp")
            val clp: Double,
            @SerialName("cny")
            val cny: Double,
            @SerialName("czk")
            val czk: Double,
            @SerialName("dkk")
            val dkk: Double,
            @SerialName("dot")
            val dot: Double,
            @SerialName("eos")
            val eos: Double,
            @SerialName("eth")
            val eth: Double,
            @SerialName("eur")
            val eur: Double,
            @SerialName("gbp")
            val gbp: Double,
            @SerialName("gel")
            val gel: Double,
            @SerialName("hkd")
            val hkd: Double,
            @SerialName("huf")
            val huf: Double,
            @SerialName("idr")
            val idr: Double,
            @SerialName("ils")
            val ils: Double,
            @SerialName("inr")
            val inr: Double,
            @SerialName("jpy")
            val jpy: Double,
            @SerialName("krw")
            val krw: Double,
            @SerialName("kwd")
            val kwd: Double,
            @SerialName("link")
            val link: Double,
            @SerialName("lkr")
            val lkr: Double,
            @SerialName("ltc")
            val ltc: Double,
            @SerialName("mmk")
            val mmk: Double,
            @SerialName("mxn")
            val mxn: Double,
            @SerialName("myr")
            val myr: Double,
            @SerialName("ngn")
            val ngn: Double,
            @SerialName("nok")
            val nok: Double,
            @SerialName("nzd")
            val nzd: Double,
            @SerialName("php")
            val php: Double,
            @SerialName("pkr")
            val pkr: Double,
            @SerialName("pln")
            val pln: Double,
            @SerialName("rub")
            val rub: Double,
            @SerialName("sar")
            val sar: Double,
            @SerialName("sats")
            val sats: Double,
            @SerialName("sek")
            val sek: Double,
            @SerialName("sgd")
            val sgd: Double,
            @SerialName("thb")
            val thb: Double,
            @SerialName("try")
            val tryX: Double,
            @SerialName("twd")
            val twd: Double,
            @SerialName("uah")
            val uah: Double,
            @SerialName("usd")
            val usd: Double,
            @SerialName("vef")
            val vef: Double,
            @SerialName("vnd")
            val vnd: Double,
            @SerialName("xag")
            val xag: Double,
            @SerialName("xau")
            val xau: Double,
            @SerialName("xdr")
            val xdr: Double,
            @SerialName("xlm")
            val xlm: Double,
            @SerialName("xrp")
            val xrp: Double,
            @SerialName("yfi")
            val yfi: Double,
            @SerialName("zar")
            val zar: Double
        )

        @Serializable
        data class PriceChangePercentage30dInCurrency(
            @SerialName("aed")
            val aed: Double,
            @SerialName("ars")
            val ars: Double,
            @SerialName("aud")
            val aud: Double,
            @SerialName("bch")
            val bch: Double,
            @SerialName("bdt")
            val bdt: Double,
            @SerialName("bhd")
            val bhd: Double,
            @SerialName("bits")
            val bits: Double,
            @SerialName("bmd")
            val bmd: Double,
            @SerialName("bnb")
            val bnb: Double,
            @SerialName("brl")
            val brl: Double,
            @SerialName("btc")
            val btc: Int,
            @SerialName("cad")
            val cad: Double,
            @SerialName("chf")
            val chf: Double,
            @SerialName("clp")
            val clp: Double,
            @SerialName("cny")
            val cny: Double,
            @SerialName("czk")
            val czk: Double,
            @SerialName("dkk")
            val dkk: Double,
            @SerialName("dot")
            val dot: Double,
            @SerialName("eos")
            val eos: Double,
            @SerialName("eth")
            val eth: Double,
            @SerialName("eur")
            val eur: Double,
            @SerialName("gbp")
            val gbp: Double,
            @SerialName("gel")
            val gel: Double,
            @SerialName("hkd")
            val hkd: Double,
            @SerialName("huf")
            val huf: Double,
            @SerialName("idr")
            val idr: Double,
            @SerialName("ils")
            val ils: Double,
            @SerialName("inr")
            val inr: Double,
            @SerialName("jpy")
            val jpy: Double,
            @SerialName("krw")
            val krw: Double,
            @SerialName("kwd")
            val kwd: Double,
            @SerialName("link")
            val link: Double,
            @SerialName("lkr")
            val lkr: Double,
            @SerialName("ltc")
            val ltc: Double,
            @SerialName("mmk")
            val mmk: Double,
            @SerialName("mxn")
            val mxn: Double,
            @SerialName("myr")
            val myr: Double,
            @SerialName("ngn")
            val ngn: Double,
            @SerialName("nok")
            val nok: Double,
            @SerialName("nzd")
            val nzd: Double,
            @SerialName("php")
            val php: Double,
            @SerialName("pkr")
            val pkr: Double,
            @SerialName("pln")
            val pln: Double,
            @SerialName("rub")
            val rub: Double,
            @SerialName("sar")
            val sar: Double,
            @SerialName("sats")
            val sats: Double,
            @SerialName("sek")
            val sek: Double,
            @SerialName("sgd")
            val sgd: Double,
            @SerialName("thb")
            val thb: Double,
            @SerialName("try")
            val tryX: Double,
            @SerialName("twd")
            val twd: Double,
            @SerialName("uah")
            val uah: Double,
            @SerialName("usd")
            val usd: Double,
            @SerialName("vef")
            val vef: Double,
            @SerialName("vnd")
            val vnd: Double,
            @SerialName("xag")
            val xag: Double,
            @SerialName("xau")
            val xau: Double,
            @SerialName("xdr")
            val xdr: Double,
            @SerialName("xlm")
            val xlm: Double,
            @SerialName("xrp")
            val xrp: Double,
            @SerialName("yfi")
            val yfi: Double,
            @SerialName("zar")
            val zar: Double
        )

        @Serializable
        data class PriceChangePercentage60dInCurrency(
            @SerialName("aed")
            val aed: Double,
            @SerialName("ars")
            val ars: Double,
            @SerialName("aud")
            val aud: Double,
            @SerialName("bch")
            val bch: Double,
            @SerialName("bdt")
            val bdt: Double,
            @SerialName("bhd")
            val bhd: Double,
            @SerialName("bits")
            val bits: Double,
            @SerialName("bmd")
            val bmd: Double,
            @SerialName("bnb")
            val bnb: Double,
            @SerialName("brl")
            val brl: Double,
            @SerialName("btc")
            val btc: Int,
            @SerialName("cad")
            val cad: Double,
            @SerialName("chf")
            val chf: Double,
            @SerialName("clp")
            val clp: Double,
            @SerialName("cny")
            val cny: Double,
            @SerialName("czk")
            val czk: Double,
            @SerialName("dkk")
            val dkk: Double,
            @SerialName("dot")
            val dot: Double,
            @SerialName("eos")
            val eos: Double,
            @SerialName("eth")
            val eth: Double,
            @SerialName("eur")
            val eur: Double,
            @SerialName("gbp")
            val gbp: Double,
            @SerialName("gel")
            val gel: Double,
            @SerialName("hkd")
            val hkd: Double,
            @SerialName("huf")
            val huf: Double,
            @SerialName("idr")
            val idr: Double,
            @SerialName("ils")
            val ils: Double,
            @SerialName("inr")
            val inr: Double,
            @SerialName("jpy")
            val jpy: Double,
            @SerialName("krw")
            val krw: Double,
            @SerialName("kwd")
            val kwd: Double,
            @SerialName("link")
            val link: Double,
            @SerialName("lkr")
            val lkr: Double,
            @SerialName("ltc")
            val ltc: Double,
            @SerialName("mmk")
            val mmk: Double,
            @SerialName("mxn")
            val mxn: Double,
            @SerialName("myr")
            val myr: Double,
            @SerialName("ngn")
            val ngn: Double,
            @SerialName("nok")
            val nok: Double,
            @SerialName("nzd")
            val nzd: Double,
            @SerialName("php")
            val php: Double,
            @SerialName("pkr")
            val pkr: Double,
            @SerialName("pln")
            val pln: Double,
            @SerialName("rub")
            val rub: Double,
            @SerialName("sar")
            val sar: Double,
            @SerialName("sats")
            val sats: Double,
            @SerialName("sek")
            val sek: Double,
            @SerialName("sgd")
            val sgd: Double,
            @SerialName("thb")
            val thb: Double,
            @SerialName("try")
            val tryX: Double,
            @SerialName("twd")
            val twd: Double,
            @SerialName("uah")
            val uah: Double,
            @SerialName("usd")
            val usd: Double,
            @SerialName("vef")
            val vef: Double,
            @SerialName("vnd")
            val vnd: Double,
            @SerialName("xag")
            val xag: Double,
            @SerialName("xau")
            val xau: Double,
            @SerialName("xdr")
            val xdr: Double,
            @SerialName("xlm")
            val xlm: Double,
            @SerialName("xrp")
            val xrp: Double,
            @SerialName("yfi")
            val yfi: Double,
            @SerialName("zar")
            val zar: Double
        )

        @Serializable
        data class PriceChangePercentage7dInCurrency(
            @SerialName("aed")
            val aed: Double,
            @SerialName("ars")
            val ars: Double,
            @SerialName("aud")
            val aud: Double,
            @SerialName("bch")
            val bch: Double,
            @SerialName("bdt")
            val bdt: Double,
            @SerialName("bhd")
            val bhd: Double,
            @SerialName("bits")
            val bits: Double,
            @SerialName("bmd")
            val bmd: Double,
            @SerialName("bnb")
            val bnb: Double,
            @SerialName("brl")
            val brl: Double,
            @SerialName("btc")
            val btc: Int,
            @SerialName("cad")
            val cad: Double,
            @SerialName("chf")
            val chf: Double,
            @SerialName("clp")
            val clp: Double,
            @SerialName("cny")
            val cny: Double,
            @SerialName("czk")
            val czk: Double,
            @SerialName("dkk")
            val dkk: Double,
            @SerialName("dot")
            val dot: Double,
            @SerialName("eos")
            val eos: Double,
            @SerialName("eth")
            val eth: Double,
            @SerialName("eur")
            val eur: Double,
            @SerialName("gbp")
            val gbp: Double,
            @SerialName("gel")
            val gel: Double,
            @SerialName("hkd")
            val hkd: Double,
            @SerialName("huf")
            val huf: Double,
            @SerialName("idr")
            val idr: Double,
            @SerialName("ils")
            val ils: Double,
            @SerialName("inr")
            val inr: Double,
            @SerialName("jpy")
            val jpy: Double,
            @SerialName("krw")
            val krw: Double,
            @SerialName("kwd")
            val kwd: Double,
            @SerialName("link")
            val link: Double,
            @SerialName("lkr")
            val lkr: Double,
            @SerialName("ltc")
            val ltc: Double,
            @SerialName("mmk")
            val mmk: Double,
            @SerialName("mxn")
            val mxn: Double,
            @SerialName("myr")
            val myr: Double,
            @SerialName("ngn")
            val ngn: Double,
            @SerialName("nok")
            val nok: Double,
            @SerialName("nzd")
            val nzd: Double,
            @SerialName("php")
            val php: Double,
            @SerialName("pkr")
            val pkr: Double,
            @SerialName("pln")
            val pln: Double,
            @SerialName("rub")
            val rub: Double,
            @SerialName("sar")
            val sar: Double,
            @SerialName("sats")
            val sats: Double,
            @SerialName("sek")
            val sek: Double,
            @SerialName("sgd")
            val sgd: Double,
            @SerialName("thb")
            val thb: Double,
            @SerialName("try")
            val tryX: Double,
            @SerialName("twd")
            val twd: Double,
            @SerialName("uah")
            val uah: Double,
            @SerialName("usd")
            val usd: Double,
            @SerialName("vef")
            val vef: Double,
            @SerialName("vnd")
            val vnd: Double,
            @SerialName("xag")
            val xag: Double,
            @SerialName("xau")
            val xau: Double,
            @SerialName("xdr")
            val xdr: Double,
            @SerialName("xlm")
            val xlm: Double,
            @SerialName("xrp")
            val xrp: Double,
            @SerialName("yfi")
            val yfi: Double,
            @SerialName("zar")
            val zar: Double
        )

        @Serializable
        data class TotalVolume(
            @SerialName("aed")
            val aed: Long,
            @SerialName("ars")
            val ars: Long,
            @SerialName("aud")
            val aud: Long,
            @SerialName("bch")
            val bch: Int,
            @SerialName("bdt")
            val bdt: Long,
            @SerialName("bhd")
            val bhd: Long,
            @SerialName("bits")
            val bits: Long,
            @SerialName("bmd")
            val bmd: Long,
            @SerialName("bnb")
            val bnb: Int,
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
            val link: Int,
            @SerialName("lkr")
            val lkr: Long,
            @SerialName("ltc")
            val ltc: Int,
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
            val xag: Int,
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
    }

    @Serializable
    data class Platforms(
        @SerialName("")
        val x: String
    )

    @Serializable
    data class Ticker(
        @SerialName("base")
        val base: String,
        @SerialName("bid_ask_spread_percentage")
        val bidAskSpreadPercentage: Double,
        @SerialName("coin_id")
        val coinId: String,
        @SerialName("converted_last")
        val convertedLast: ConvertedLast,
        @SerialName("converted_volume")
        val convertedVolume: ConvertedVolume,
        @SerialName("is_anomaly")
        val isAnomaly: Boolean,
        @SerialName("is_stale")
        val isStale: Boolean,
        @SerialName("last")
        val last: Double,
        @SerialName("last_fetch_at")
        val lastFetchAt: String,
        @SerialName("last_traded_at")
        val lastTradedAt: String,
        @SerialName("market")
        val market: Market,
        @SerialName("target")
        val target: String,
        @SerialName("target_coin_id")
        val targetCoinId: String?,
        @SerialName("timestamp")
        val timestamp: String,
        @SerialName("token_info_url")
        val tokenInfoUrl: Any?,
        @SerialName("trade_url")
        val tradeUrl: String?,
        @SerialName("trust_score")
        val trustScore: String,
        @SerialName("volume")
        val volume: Double
    ) {
        @Serializable
        data class ConvertedLast(
            @SerialName("btc")
            val btc: Double,
            @SerialName("eth")
            val eth: Double,
            @SerialName("usd")
            val usd: Int
        )

        @Serializable
        data class ConvertedVolume(
            @SerialName("btc")
            val btc: Double,
            @SerialName("eth")
            val eth: Int,
            @SerialName("usd")
            val usd: Int
        )

        @Serializable
        data class Market(
            @SerialName("has_trading_incentive")
            val hasTradingIncentive: Boolean,
            @SerialName("identifier")
            val identifier: String,
            @SerialName("name")
            val name: String
        )
    }
}