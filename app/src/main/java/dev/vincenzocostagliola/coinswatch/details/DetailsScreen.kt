package dev.vincenzocostagliola.coinswatch.details

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.State
import dev.vincenzocostagliola.designsystem.composables.Progress
import androidx.compose.runtime.collectAsState


@Composable
internal fun DetailsScreen(viewModel: DetailsScreenViewModel, coinId: String?) {
    Text("This is details screen. CoinId = $coinId")

    val state: State<DetailsScreenState> = viewModel.detailsScreenState.collectAsState()
    when (val viewState = state.value) {
        is DetailsScreenState.Error -> Unit
        DetailsScreenState.Loading -> {
            Progress(true)
            viewModel.sendEvent(DetailsScreenEvents.GetCoinData(coinId))
        }

        is DetailsScreenState.Success -> {
            Progress(false)
        }
    }
}