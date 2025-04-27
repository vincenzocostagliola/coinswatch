package dev.vincenzocostagliola.home.data.domain.result

import dev.vincenzocostagliola.home.data.domain.Coin
import dev.vincenzocostagliola.data.error.CoinSwatchError

internal sealed class GetCoinsResult {
    data class Success(val coinList: List<Coin>) : GetCoinsResult()
    data class Failure(val error: CoinSwatchError) : GetCoinsResult()
}