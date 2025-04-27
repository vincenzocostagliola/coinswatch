package dev.vincenzocostagliola.coindetails.data.domain.result

import dev.vincenzocostagliola.coindetails.data.domain.CoinData
import dev.vincenzocostagliola.data.error.CoinSwatchError

sealed class GetCoinDataResult {
    data class Success(val coinData: CoinData) : GetCoinDataResult()
    data class Failure(val error: CoinSwatchError) : GetCoinDataResult()
}