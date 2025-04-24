package dev.vincenzocostagliola.coinswatch

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.State
import dev.vincenzocostagliola.designsystem.composables.Progress
import androidx.compose.runtime.collectAsState


@Composable
internal fun DetailsScreen(viewModel: DetailsScreenViewModel, coinId: String?) {
    Text("This is details screen. CoinId = $coinId")

    val state: State<DetailScreenState> = viewModel.detailScreenState.collectAsState()
    when (val viewState = state.value) {
        is DetailScreenState.Error -> Unit
        DetailScreenState.Loading -> {
            Progress(true)
            viewModel.sendEvent(DetailScreenEvents.GetCoinData(coinId))
        }

        is DetailScreenState.Success -> {
            Progress(false)
        }
    }

}