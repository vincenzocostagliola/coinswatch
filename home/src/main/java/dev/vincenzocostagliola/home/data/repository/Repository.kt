package dev.vincenzocostagliola.home.data.repository

import dev.vincenzocostagliola.home.data.domain.result.GetCoinsResult
import kotlinx.coroutines.flow.Flow

internal interface Repository {
    suspend fun getCoinsWithMarketData(currency: String, howManyCoins: Int): Flow<GetCoinsResult>
}