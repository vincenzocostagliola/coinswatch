package dev.vincenzocostagliola.data.net.service

import com.skydoves.sandwich.ApiResponse
import dev.vincenzocostagliola.data.dto.CoinDataDto
import dev.vincenzocostagliola.data.dto.CoinDto
import dev.vincenzocostagliola.data.dto.CoinHistoricalDataDto
import dev.vincenzocostagliola.data.net.NetHelper
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Path

interface CoinsService {
    /*---COINS with market data---*/
    @Headers(NetHelper.APIKEY)
    @GET("coins/markets")
    suspend fun getCoinsWithMarketData(@Path("vs_currency") currency: String): ApiResponse<List<CoinDto>>

    /*---COIN data---*/
    @Headers(NetHelper.APIKEY)
    @GET("coins/id")
    suspend fun getCoinData(@Path("id") coinId: String): ApiResponse<CoinDataDto>

    /*---COIN Historical data---*/
    @Headers(NetHelper.APIKEY)
    @GET("coins/{id}/market_char?precision=2")
    suspend fun getCoinHistoricalData(
        @Path("id") coinId: String,
        @Path("vs_currency") currency: String,
        @Path("days") days: Int
    ): ApiResponse<List<CoinHistoricalDataDto>>
}