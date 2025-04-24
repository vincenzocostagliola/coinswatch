package dev.vincenzocostagliola.coinswatch

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

sealed class DetailScreenState {
    data object Loading : DetailScreenState()
    data class Success(val list: List<Coin>) : DetailScreenState()
    data class Error(val error: CoinSwatchError) : DetailScreenState()
}

sealed class DetailScreenEvents {
    data class GetCoinData(val coinId: String?) : DetailScreenEvents()
}

@HiltViewModel
class DetailScreenViewModel @Inject constructor(
    private val repository: Repository
) : ViewModel() {

    private val _detailScreenState: MutableStateFlow<DetailScreenState> =
        MutableStateFlow(DetailScreenState.Loading)
    val detailScreenState: StateFlow<DetailScreenState>
        get() = _detailScreenState

    fun sendEvent(event: DetailScreenEvents) {
        viewModelScope.launch() {
            when (event) {
                is DetailScreenEvents.GetCoinData -> Unit
            }
        }
    }
}