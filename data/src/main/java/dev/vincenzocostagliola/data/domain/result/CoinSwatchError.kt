package dev.vincenzocostagliola.data.domain.result

sealed class CoinSwatchError {

    data object GenericError : CoinSwatchError()
}