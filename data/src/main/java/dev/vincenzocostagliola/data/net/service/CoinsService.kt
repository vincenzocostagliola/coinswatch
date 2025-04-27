package dev.vincenzocostagliola.data.net.service

import com.skydoves.sandwich.ApiResponse
import dev.vincenzocostagliola.data.dto.CoinDto
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface CoinsService {
    /*---COINS with market data---*/
    @GET("coins/markets")
    suspend fun getCoinsWithMarketData(@Query("vs_currency") currency: String): ApiResponse<List<CoinDto>>
}