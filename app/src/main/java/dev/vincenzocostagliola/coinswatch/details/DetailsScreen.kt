package dev.vincenzocostagliola.coinswatch.details

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyListScope
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.State
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import dev.vincenzocostagliola.data.domain.CoinHistoricalData
import dev.vincenzocostagliola.designsystem.composables.CoinHistoryListItem
import dev.vincenzocostagliola.designsystem.composables.Progress
import dev.vincenzocostagliola.designsystem.composables.TopBar
import dev.vincenzocostagliola.designsystem.theme.ExtraLight
import dev.vincenzocostagliola.designsystem.values.Dimens
import dev.vincenzocostagliola.designsystem.values.Dimens.iconDimensRegular


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
        modifier = modifier
            .background(ExtraLight),
        topBar = {
            TopBar(
                title = data.name + " - Market Cap Rank " + data.marketCapRank,
                onBackButton = onBackPressed
            )
        }
    ) {
        LazyColumn(
            modifier = modifier
                .padding(it)
                .fillMaxSize()
                .padding(Dimens.XRegular)
        ) {
            ShowImage(data.image.large, data.name)
            ShowDescription(data.description)
            ShowHistory(data.history)
        }
    }
}

fun LazyListScope.ShowDescription(description: String) {
    items(1) {
        Text(description)
    }
}


fun LazyListScope.ShowHistory(data: CoinHistoricalData) {
    items(data.prices.size) { item ->
        CoinHistoryListItem(
            history = data.prices[item]
        )
    }
}


fun LazyListScope.ShowImage(imageUrl: String, name: String) {
    items(1) {
        // TODO a placeholder is needed
        Column(
            modifier = Modifier.fillMaxWidth(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            AsyncImage(
                model = imageUrl,
                modifier = Modifier
                    .size(iconDimensRegular),
                contentScale = ContentScale.Fit,
                contentDescription = name,
                alignment = Alignment.Center

            )
        }
    }
}

@Preview
@Composable
fun ShowImagePreview() {
    /*ShowImage(
        imageUrl = "https://assets.coingecko.com/coins/images/1/large/bitcoin.png?1696501400",
        name = "Bitcoin"
    )*/
}
