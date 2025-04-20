package dev.vincenzocostagliola.data.domain.result

import dev.vincenzocostagliola.data.domain.CoinData
import dev.vincenzocostagliola.data.error.CoinSwatchError

sealed class GetCoinDataResult {
    data class Success(val coinData: CoinData) : GetCoinDataResult()
    data class Failure(val error: CoinSwatchError) : GetCoinDataResult()
}