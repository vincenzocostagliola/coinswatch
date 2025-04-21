package dev.vincenzocostagliola.data.net.service

import com.skydoves.sandwich.ApiResponse
import dev.vincenzocostagliola.data.dto.CoinDataDto
import dev.vincenzocostagliola.data.dto.CoinDto
import dev.vincenzocostagliola.data.dto.CoinHistoricalDataDto
import retrofit2.http.GET
import retrofit2.http.Query

interface CoinsService {
    /*---COINS with market data---*/
    @GET("coins/markets")
    suspend fun getCoinsWithMarketData(@Query("vs_currency") currency: String): ApiResponse<List<CoinDto>>

    /*---COIN data---*/
    @GET("coins/id")
    suspend fun getCoinData(@Query("id") coinId: String): ApiResponse<CoinDataDto>

    /*---COIN Historical data---*/
    @GET("coins/{id}/market_char?precision=2")
    suspend fun getCoinHistoricalData(
        @Query("id") coinId: String,
        @Query("vs_currency") currency: String,
        @Query("days") days: Int
    ): ApiResponse<List<CoinHistoricalDataDto>>
}