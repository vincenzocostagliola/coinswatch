package dev.vincenzocostagliola.coindetails.data.domain.result

import dev.vincenzocostagliola.coindetails.data.domain.CoinHistoricalData
import dev.vincenzocostagliola.data.error.CoinSwatchError

sealed class GetCoinHistoricalDataResult {
    data class Success(val coinData: CoinHistoricalData) : GetCoinHistoricalDataResult()
    data class Failure(val error: CoinSwatchError) : GetCoinHistoricalDataResult()
}