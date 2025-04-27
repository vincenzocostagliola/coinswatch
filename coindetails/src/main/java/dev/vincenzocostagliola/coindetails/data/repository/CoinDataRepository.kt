package dev.vincenzocostagliola.coindetails.data.repository

import dev.vincenzocostagliola.data.domain.result.GetCoinDataResult
import dev.vincenzocostagliola.data.domain.result.GetCoinHistoricalDataResult
import dev.vincenzocostagliola.data.domain.result.GetCoinsResult
import kotlinx.coroutines.flow.Flow

interface CoinDataRepository {
    suspend fun getCoinData(coinId : String) : Flow<GetCoinDataResult>
    suspend fun getCoinHistoricalData(
        coinId: String,
        currency: String,
        days: Int
    ): Flow<GetCoinHistoricalDataResult>
}