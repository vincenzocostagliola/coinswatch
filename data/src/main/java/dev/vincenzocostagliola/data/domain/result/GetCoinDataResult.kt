package dev.vincenzocostagliola.data.domain.result

import dev.vincenzocostagliola.data.domain.Coin
import dev.vincenzocostagliola.data.error.CoinSwatchError

sealed class GetCoinDataResult {
    data class Success(val coinList: List<Coin>) : GetCoinDataResult()
    data class Failure(val error: CoinSwatchError) : GetCoinDataResult()
}