package dev.vincenzocostagliola.coinswatch.details

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import dev.vincenzocostagliola.designsystem.theme.ExtraLight
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.State
import dev.vincenzocostagliola.designsystem.composables.Progress
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import coil.compose.AsyncImage
import dev.vincenzocostagliola.data.domain.CoinHistoricalData
import dev.vincenzocostagliola.designsystem.composables.CoinHistoryListItem
import dev.vincenzocostagliola.designsystem.composables.TopBar
import dev.vincenzocostagliola.designsystem.values.Dimens


@Composable
internal fun DetailsScreen(
    viewModel: DetailsScreenViewModel,
    coinId: String?,
    onBackPressed: () -> Unit,
) {
    val state: State<DetailsScreenState> = viewModel.detailsScreenState.collectAsState()
    when (val viewState = state.value) {
        is DetailsScreenState.Error -> Unit
        DetailsScreenState.Loading -> {
            Progress(true)
            viewModel.sendEvent(DetailsScreenEvents.GetCoinData(coinId))
        }

        is DetailsScreenState.Success -> {
            Progress(false)
            ShowDetails(viewState.data, onBackPressed)
        }
    }
}

@Composable
fun ShowDetails(
    data: CoinDataWithHistoryResult.CoinDataWithHistory,
    onBackPressed: () -> Unit,
    modifier: Modifier = Modifier
) {
    Scaffold(
        topBar = {
            TopBar(
                title = data.name + " - " + data.marketCapRank,
                onBackButton = onBackPressed
            )
        }
    ) {

        Column(
            modifier = modifier
                .padding(it)
                .fillMaxSize()
                .background(ExtraLight)

        ) {
            Surface {
                ShowHistory(data.history)
            }
        }
    }
}


@Composable
fun ShowHistory(data: CoinHistoricalData) {
    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .padding(horizontal = Dimens.XRegular)
    ) {
        items(data.prices.size) { item ->
            CoinHistoryListItem(
                history = data.prices[item]
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