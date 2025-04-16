package dev.vincenzocostagliola.data.error

sealed class CoinSwatchError {

    data object GenericError : CoinSwatchError()
    object ErrorBadRequest : CoinSwatchError() {

    }

    object ErrorAndQuit : CoinSwatchError() {

    }

    object ErrorServerInternalError : CoinSwatchError() {

    }

    object ErrorTimeoutGateWay : CoinSwatchError() {

    }

    object ErrorConnection : CoinSwatchError() {

    }

    object ErrorGenericCause : CoinSwatchError() {

    }

    object ErrorOffline : CoinSwatchError() {

    }
}