package dev.vincenzocostagliola.coinswatch

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import dev.vincenzocostagliola.data.domain.Coin
import dev.vincenzocostagliola.data.domain.result.GetCoinsResult
import dev.vincenzocostagliola.data.error.CoinSwatchError
import dev.vincenzocostagliola.data.net.repository.Repository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject


sealed class MainScreenState {
    data object Loading : MainScreenState()
    data class Success(val list: List<Coin>) : MainScreenState()
    data class Error(val error: CoinSwatchError) : MainScreenState()
}

sealed class MainScreenEvents {
    data object GetCoinsData : MainScreenEvents()
}

@HiltViewModel
class MainViewModel @Inject constructor(
    private val repository: Repository
) : ViewModel() {

    private val howManyCoins = 10
    private val currency = "eur"


    private val _mainScreenState: MutableStateFlow<MainScreenState> =
        MutableStateFlow(MainScreenState.Loading)
    val mainScreenState: StateFlow<MainScreenState>
        get() = _mainScreenState

    fun sendEvent(event: MainScreenEvents) {
        viewModelScope.launch() {
            when (event) {
                MainScreenEvents.GetCoinsData -> getCoinsWithMarketData()
            }
        }
    }

    private suspend fun getCoinsWithMarketData() {
        _mainScreenState.update {
            MainScreenState.Loading
        }

        repository.getCoinsWithMarketData(
            currency = currency,
            howManyCoins = howManyCoins
        ).collect {
            executeCollect(it)
        }
    }

    private fun executeCollect(result: GetCoinsResult) {
        when (result) {
            is GetCoinsResult.Failure -> _mainScreenState.update {
                MainScreenState.Error(result.error)
            }

            is GetCoinsResult.Success -> _mainScreenState.update {
                MainScreenState.Success(result.coinList)
            }
        }
    }

}