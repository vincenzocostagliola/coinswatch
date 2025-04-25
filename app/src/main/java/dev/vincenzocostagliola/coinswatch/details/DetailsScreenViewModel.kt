package dev.vincenzocostagliola.coinswatch.details

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import dev.vincenzocostagliola.coinswatch.details.CoinDataWithHistoryResult.CoinDataWithHistory
import dev.vincenzocostagliola.data.error.CoinSwatchError
import dev.vincenzocostagliola.data.error.DialogAction
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import timber.log.Timber
import javax.inject.Inject

internal sealed class DetailsScreenState {
    data object Loading : DetailsScreenState()
    data class Success(val data: CoinDataWithHistory) : DetailsScreenState()
    data class Error(val error: CoinSwatchError) : DetailsScreenState()
}

internal sealed class DetailsScreenEvents {
    data class GetCoinData(val coinId: String?) : DetailsScreenEvents()
    data class PerformDialogAction(val dialogAction: DialogAction) : DetailsScreenEvents()
}

@HiltViewModel
internal class DetailsScreenViewModel @Inject constructor(
    private val useCase: DetailsUseCase
) : ViewModel() {

    //TODO improve currency and days management with user preferences
    private val currency = "eur"
    private val days = 7

    //TODO remove, need to be passed toghether with dialog Action
    private var savedCoinId: String? = null

    private val _detailsScreenState: MutableStateFlow<DetailsScreenState> =
        MutableStateFlow(DetailsScreenState.Loading)
    val detailsScreenState: StateFlow<DetailsScreenState>
        get() = _detailsScreenState

    fun sendEvent(event: DetailsScreenEvents) {
        viewModelScope.launch() {
            when (event) {
                is DetailsScreenEvents.GetCoinData -> getCoinDataWithHistory(event.coinId)
                is DetailsScreenEvents.PerformDialogAction -> performDialogAction(event.dialogAction)
            }
        }
    }

    private suspend fun performDialogAction(action: DialogAction) {
        when (action) {
            DialogAction.Leave -> Unit
            DialogAction.Quit -> {
                // Perform a logout if signed or go out from the app
                Unit
            }

            DialogAction.Retry -> getCoinDataWithHistory(savedCoinId)
        }
    }

    private suspend fun getCoinDataWithHistory(coinId: String?) {
        savedCoinId = coinId
        coinId?.let {
            useCase.getCoinDataWithHistory(
                coinId = coinId,
                currency = currency,
                days = days
            ).collect { result ->
                executeCollect(result)
            }
        } ?: {
            Timber.e("getCoinDataWithHistory - No coinId available")
            _detailsScreenState.update { DetailsScreenState.Error(CoinSwatchError.GenericError) }
        }
    }

    private fun executeCollect(result: CoinDataWithHistoryResult) {
        when (result) {
            is CoinDataWithHistoryResult.Error -> _detailsScreenState.update {
                DetailsScreenState.Error(result.error)
            }

            is CoinDataWithHistoryResult.CoinDataWithHistory -> _detailsScreenState.update {
                DetailsScreenState.Success(result)
            }
        }
    }
}