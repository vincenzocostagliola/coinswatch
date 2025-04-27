package dev.vincenzocostagliola.home.data.service

import com.skydoves.sandwich.ApiResponse
import dev.vincenzocostagliola.home.data.dto.CoinDto
import retrofit2.http.GET
import retrofit2.http.Query

internal interface CoinsService {
    /*---COINS with market data---*/
    @GET("coins/markets")
    suspend fun getCoinsWithMarketData(@Query("vs_currency") currency: String): ApiResponse<List<CoinDto>>
}