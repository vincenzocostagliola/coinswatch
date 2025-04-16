package dev.vincenzocostagliola.data.net.service

import com.skydoves.sandwich.ApiResponse
import dev.vincenzocostagliola.data.dto.CoinDto
import dev.vincenzocostagliola.data.net.NetHelper
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Path

interface CoinsService {
    /*---COINS with market data---*/
    @Headers(NetHelper.APIKEY)
    @GET("coins/markets")
    suspend fun getCoinsWithMarketData(@Path("vs_currency") currency: String): ApiResponse<List<CoinDto>>
}