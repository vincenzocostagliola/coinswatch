package dev.vincenzocostagliola.coinswatch.details

import android.content.ClipDescription
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyListScope
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.ListItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.State
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavHostController
import coil.compose.AsyncImage
import dev.vincenzocostagliola.coinswatch.NavigationRoute
import dev.vincenzocostagliola.coinswatch.R
import dev.vincenzocostagliola.data.domain.CoinHistoricalData
import dev.vincenzocostagliola.designsystem.composables.CoinHistoryListItem
import dev.vincenzocostagliola.designsystem.composables.Progress
import dev.vincenzocostagliola.designsystem.composables.TopBar
import dev.vincenzocostagliola.designsystem.theme.ExtraLight
import dev.vincenzocostagliola.designsystem.values.Dimens
import dev.vincenzocostagliola.designsystem.values.Dimens.iconDimensRegular
import timber.log.Timber


@Composable
internal fun DetailsScreen(
    viewModel: DetailsScreenViewModel,
    navigationController: NavHostController,
    coinId: String?,
    onBackPressed: () -> Unit,
) {
    val goToDescription: (String) -> Unit = {
        Timber.d("Description Navigation - sent")
        navigationController.navigate(NavigationRoute.DescriptionScreen.createRoute(it))
    }

    val state: State<DetailsScreenState> = viewModel.detailsScreenState.collectAsState()
    when (val viewState = state.value) {
        is DetailsScreenState.Error -> Unit
        DetailsScreenState.Loading -> {
            Progress(true)
            viewModel.sendEvent(DetailsScreenEvents.GetCoinData(coinId))
        }

        is DetailsScreenState.Success -> {
            Progress(false)
            ShowDetails(viewState.data, onBackPressed, goToDescription)
        }
    }
}

@Composable
private fun ShowDetails(
    data: CoinDataWithHistoryResult.CoinDataWithHistory,
    onBackPressed: () -> Unit,
    goToDescription: (String) -> Unit,
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
            ShowDescription(data.description, goToDescription)
            ShowHistory(data.history)
        }
    }
}

private fun LazyListScope.ShowDescription(description: String, goToDescription: (String) -> Unit) {
    // TODO Remove items(1)
    items(1) {
        Column {
            ListItem(
                headlineContent = { Text(stringResource(R.string.description)) },
                trailingContent = {
                    IconButton(
                        onClick = { goToDescription(description) }
                    ) {
                        Icon(
                            painter = painterResource(id = R.drawable.chevron_right),
                            contentDescription = "",
                            tint = Color(0xFF434C59)
                        )
                    }
                }
            )
            HorizontalDivider()
        }
    }
}

private fun LazyListScope.ShowImage(imageUrl: String, name: String) {
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


private fun LazyListScope.ShowHistory(data: CoinHistoricalData) {
    items(data.prices.size) { item ->
        CoinHistoryListItem(
            history = data.prices[item]
        )
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
