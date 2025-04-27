package dev.vincenzocostagliola.coindetails.data.domain.result

import dev.vincenzocostagliola.data.domain.Coin
import dev.vincenzocostagliola.data.error.CoinSwatchError

sealed class GetCoinsResult {
    data class Success(val coinList: List<Coin>) : GetCoinsResult()
    data class Failure(val error: CoinSwatchError) : GetCoinsResult()
}