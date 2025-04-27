package dev.vincenzocostagliola.coindetails.data.repository

import dev.vincenzocostagliola.coindetails.data.domain.result.GetCoinDataResult
import dev.vincenzocostagliola.coindetails.data.domain.result.GetCoinHistoricalDataResult
import kotlinx.coroutines.flow.Flow

internal interface CoinDataRepository {
    suspend fun getCoinData(coinId : String) : Flow<GetCoinDataResult>
    suspend fun getCoinHistoricalData(
        coinId: String,
        currency: String,
        days: Int
    ): Flow<GetCoinHistoricalDataResult>
}