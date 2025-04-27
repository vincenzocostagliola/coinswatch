package dev.vincenzocostagliola.coindetails.data.service

import com.skydoves.sandwich.ApiResponse
import dev.vincenzocostagliola.coindetails.data.dto.CoinDataDto
import dev.vincenzocostagliola.coindetails.data.dto.CoinHistoricalDataDto
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

internal interface CoinDataService {
    /*---COIN data---*/
    @GET("coins/{id}")
    suspend fun getCoinData(@Path("id") coinId: String): ApiResponse<CoinDataDto>

    /*---COIN Historical data---*/
    @GET("coins/{id}/market_chart?")
    suspend fun getCoinHistoricalData(
        @Path("id") coinId: String,
        @Query("vs_currency") currency: String,
        @Query("days") days: Int
    ): ApiResponse<CoinHistoricalDataDto>
}