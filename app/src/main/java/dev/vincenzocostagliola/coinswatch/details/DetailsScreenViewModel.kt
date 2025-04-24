package dev.vincenzocostagliola.coinswatch.details

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import dev.vincenzocostagliola.data.domain.Coin
import dev.vincenzocostagliola.data.error.CoinSwatchError
import dev.vincenzocostagliola.data.net.repository.Repository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

sealed class DetailsScreenState {
    data object Loading : DetailsScreenState()
    data class Success(val list: List<Coin>) : DetailsScreenState()
    data class Error(val error: CoinSwatchError) : DetailsScreenState()
}

sealed class DetailsScreenEvents {
    data class GetCoinData(val coinId: String?) : DetailsScreenEvents()
}

@HiltViewModel
class DetailsScreenViewModel @Inject constructor(
    private val repository: Repository
) : ViewModel() {

    private val _detailsScreenState: MutableStateFlow<DetailsScreenState> =
        MutableStateFlow(DetailsScreenState.Loading)
    val detailsScreenState: StateFlow<DetailsScreenState>
        get() = _detailsScreenState

    fun sendEvent(event: DetailsScreenEvents) {
        viewModelScope.launch() {
            when (event) {
                is DetailsScreenEvents.GetCoinData -> Unit
            }
        }
    }
}