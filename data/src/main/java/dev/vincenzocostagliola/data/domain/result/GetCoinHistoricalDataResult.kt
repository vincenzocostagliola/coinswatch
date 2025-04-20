package dev.vincenzocostagliola.data.domain.result

import dev.vincenzocostagliola.data.domain.CoinHistoricalData
import dev.vincenzocostagliola.data.error.CoinSwatchError

sealed class GetCoinHistoricalDataResult {
    data class Success(val coinData: List<CoinHistoricalData>) : GetCoinHistoricalDataResult()
    data class Failure(val error: CoinSwatchError) : GetCoinHistoricalDataResult()
}