package dev.vincenzocostagliola.coindetails.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import dev.vincenzocostagliola.coindetails.ui.CoinDataWithHistoryResult.CoinDataWithHistory
import dev.vincenzocostagliola.data.error.CoinSwatchError
import dev.vincenzocostagliola.data.error.DialogAction
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import timber.log.Timber
import javax.inject.Inject

 sealed class DetailsScreenState {
    data object Loading : DetailsScreenState()
    data class Success(val data: CoinDataWithHistory) : DetailsScreenState()
    data class Error(val error: CoinSwatchError) : DetailsScreenState()
    data object GoBack : DetailsScreenState()
}

 sealed class DetailsScreenEvents {
    data class GetCoinData(val coinId: String?) : DetailsScreenEvents()
    data class PerformDialogAction(val dialogAction: DialogAction) : DetailsScreenEvents()
}

@HiltViewModel
class DetailsScreenViewModel @Inject constructor(
    private val useCase: DetailsUseCase
) : ViewModel() {

    //TODO improve currency and days management with user preferences
    private val currency = "eur"
    private val days = 7

    //TODO remove, need to be passed together with dialog Action
    private var savedCoinId: String? = null

    private val _detailsScreenState: MutableStateFlow<DetailsScreenState> =
        MutableStateFlow(DetailsScreenState.Loading)
    val detailsScreenState: StateFlow<DetailsScreenState>
        get() = _detailsScreenState

    fun sendEvent(event: DetailsScreenEvents) {
        Timber.d("DetailsScreen - DetailsScreenEvents: $event")

        viewModelScope.launch() {
            when (event) {
                is DetailsScreenEvents.GetCoinData -> getCoinDataWithHistory(event.coinId)
                is DetailsScreenEvents.PerformDialogAction -> performDialogAction(event.dialogAction)
            }
        }
    }

    private suspend fun performDialogAction(action: DialogAction) {
        when (action) {
            DialogAction.Leave -> {
                _detailsScreenState.update { DetailsScreenState.GoBack }
            }
            DialogAction.Quit -> {
                // Perform a logout if signed or go out from the app
                Unit
            }

            DialogAction.Retry -> getCoinDataWithHistory(savedCoinId)
        }
    }

    private suspend fun getCoinDataWithHistory(coinId: String?) {
        _detailsScreenState.update {
            DetailsScreenState.Loading
        }

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
        with(Dispatchers.Main) {
            when (result) {
                is CoinDataWithHistoryResult.Error -> _detailsScreenState.update {
                    DetailsScreenState.Error(result.error)
                }

                is CoinDataWithHistory -> _detailsScreenState.update {
                    DetailsScreenState.Success(result)
                }
            }
        }
    }
}