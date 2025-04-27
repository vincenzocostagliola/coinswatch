package dev.vincenzocostagliola.home.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import dev.vincenzocostagliola.home.data.domain.Coin
import dev.vincenzocostagliola.home.data.domain.result.GetCoinsResult
import dev.vincenzocostagliola.data.error.CoinSwatchError
import dev.vincenzocostagliola.data.error.DialogAction
import dev.vincenzocostagliola.designsystem.composables.CoinUi
import dev.vincenzocostagliola.home.data.repository.Repository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import timber.log.Timber
import javax.inject.Inject


internal sealed class HomeScreenState {
    data object Loading : HomeScreenState()
    data class Success(val list: List<CoinUi>) :
        HomeScreenState()

    data class Error(val error: CoinSwatchError) : HomeScreenState()
}

sealed class HomeScreenEvents {
    data object GetCoinsData : HomeScreenEvents()
    data class PerformDialogAction(val dialogAction: DialogAction) : HomeScreenEvents()

}

@HiltViewModel
class HomeViewModel @Inject internal constructor(
    private val repository: Repository
) : ViewModel() {

    private val howManyCoins = 10
    private val currency = "eur"

    private val _homeScreenState: MutableStateFlow<HomeScreenState> =
        MutableStateFlow(HomeScreenState.Loading)
    internal val homeScreenState: StateFlow<HomeScreenState>
        get() = _homeScreenState

    init {
        sendEvent(HomeScreenEvents.GetCoinsData)
    }

    fun sendEvent(event: HomeScreenEvents) {
        Timber.d("HomeScreen - HomeScreenEvents: $event")
        viewModelScope.launch() {
            when (event) {
                is HomeScreenEvents.GetCoinsData -> getCoinsWithMarketData()
                is HomeScreenEvents.PerformDialogAction -> performDialogAction(event.dialogAction)
            }
        }
    }

    private suspend fun performDialogAction(action: DialogAction) {
        when (action) {
            DialogAction.Leave -> Unit //TBD
            DialogAction.Quit -> {
                // Perform a logout if signed or go out from the app
                Unit
            }

            DialogAction.Retry -> getCoinsWithMarketData()
        }
    }

    private suspend fun getCoinsWithMarketData() {
        _homeScreenState.update {
            HomeScreenState.Loading
        }

        repository.getCoinsWithMarketData(
            currency = currency,
            howManyCoins = howManyCoins
        ).collect {
            executeCollect(it)
        }
    }

    private fun executeCollect(result: GetCoinsResult) {
        with(Dispatchers.Main) {
            when (result) {
                is GetCoinsResult.Failure -> _homeScreenState.update {
                    HomeScreenState.Error(result.error)
                }

                is GetCoinsResult.Success -> _homeScreenState.update {
                    HomeScreenState.Success(result.coinList.map { it.toCoinUi() })
                }
            }
        }
    }

    private fun Coin.toCoinUi(): CoinUi {
        return CoinUi(
            currentPrice = currentPrice,
            id = id,
            image = image,
            marketCap = marketCap,
            marketCapRank = marketCapRank,
            name = name
        )
    }
}