package dev.vincenzocostagliola.data.net.repository

import dev.vincenzocostagliola.data.domain.result.GetCoinDataResult
import dev.vincenzocostagliola.data.domain.result.GetCoinHistoricalDataResult
import dev.vincenzocostagliola.data.domain.result.GetCoinsResult
import kotlinx.coroutines.flow.Flow

interface Repository {
    suspend fun getCoinsWithMarketData(currency: String, howManyCoins: Int): Flow<GetCoinsResult>
}