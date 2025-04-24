package dev.vincenzocostagliola.coinswatch.details

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.runtime.State
import dev.vincenzocostagliola.designsystem.composables.Progress
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import coil.compose.AsyncImage
import dev.vincenzocostagliola.designsystem.composables.CoinHistoryListItem
import dev.vincenzocostagliola.designsystem.values.Dimens


@Composable
internal fun DetailsScreen(viewModel: DetailsScreenViewModel, coinId: String?) {
    val state: State<DetailsScreenState> = viewModel.detailsScreenState.collectAsState()
    when (val viewState = state.value) {
        is DetailsScreenState.Error -> Unit
        DetailsScreenState.Loading -> {
            Progress(true)
            viewModel.sendEvent(DetailsScreenEvents.GetCoinData(coinId))
        }

        is DetailsScreenState.Success -> {
            Progress(false)
            ShowDetails(viewState.data)
        }
    }
}

@Composable
fun ShowDetails(data: CoinDataWithHistoryResult.CoinDataWithHistory) {
    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .padding(horizontal = Dimens.XRegular)
    ) {
        items(data.history.prices.size) { item ->
            CoinHistoryListItem(
                history = data.history.prices[item]
            )
        }
    }
}

@Composable
fun ShowImage() {
    AsyncImage(
        model = "coin.image",
        modifier = Modifier,
        contentScale = ContentScale.Fit,
        contentDescription = "coin.name"
    )
}