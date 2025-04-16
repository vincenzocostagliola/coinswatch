package dev.vincenzocostagliola.data.domain.result

sealed class GetCoinsResult {
    data class Success(val coinList: List<Coin>)
    data class Failure(val error: CoinSwatchError)
}