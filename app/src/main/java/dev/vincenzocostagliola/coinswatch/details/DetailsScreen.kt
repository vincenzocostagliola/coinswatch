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
import androidx.compose.runtime.Composable
import androidx.compose.runtime.State
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalUriHandler
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavHostController
import coil.compose.AsyncImage
import dev.vincenzocostagliola.coinswatch.NavigationRoute
import dev.vincenzocostagliola.coinswatch.R
import dev.vincenzocostagliola.data.domain.CoinHistoricalData
import dev.vincenzocostagliola.data.error.DialogAction
import dev.vincenzocostagliola.data.error.DialogAction.Leave
import dev.vincenzocostagliola.data.error.DialogAction.Retry
import dev.vincenzocostagliola.data.error.ErrorResources
import dev.vincenzocostagliola.designsystem.composables.Chart
import dev.vincenzocostagliola.designsystem.composables.CoinHistoryListItem
import dev.vincenzocostagliola.designsystem.composables.ErrorDialog
import dev.vincenzocostagliola.designsystem.composables.NavigationListItem
import dev.vincenzocostagliola.designsystem.composables.Progress
import dev.vincenzocostagliola.designsystem.composables.TopBar
import dev.vincenzocostagliola.designsystem.theme.ExtraLight
import dev.vincenzocostagliola.designsystem.values.Dimens
import dev.vincenzocostagliola.designsystem.values.Dimens.iconDimensLarge
import org.threeten.bp.OffsetDateTime
import timber.log.Timber


@Composable
internal fun DetailsScreen(
    viewModel: DetailsScreenViewModel,
    navigationController: NavHostController,
    coinId: String?,
    onBackPressed: () -> Unit,
) {
    val goToDescription: (String) -> Unit = { description ->
        Timber.d("Description Navigation - sent")
        navigationController.navigate(NavigationRoute.DescriptionScreen.createRoute(description))
    }

    val state: State<DetailsScreenState> = viewModel.detailsScreenState.collectAsState()
    when (val viewState = state.value) {
        is DetailsScreenState.Error -> {
            ShowError(viewState.error.newResources) {
                viewModel.sendEvent(DetailsScreenEvents.PerformDialogAction(it))
            }
        }

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
private fun ShowError(newResources: ErrorResources, performAction: (DialogAction) -> Unit) {
    ErrorDialog(
        errorResources = newResources,
        performAction = performAction
    )
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
            items(1) {
                ShowImage(data.image.large, data.name)
                data.url?.let {
                    ShowHomeLink(it)
                }
                ShowDescription(data.description, goToDescription)
                ShowChart(data.history)
            }
            //ShowHistory(data.history)

        }
    }
}

@Composable
fun ShowChart(history: List<CoinHistoricalData.PriceChartPoint>) {
    val valuesList: List<Float> = history.map { it.value.toFloat() }
    val datesList: List<OffsetDateTime> = history.map { it.date }.distinctBy { it.toLocalDate() }
    Timber.d("ChartComposable - prices: $valuesList")
    Timber.d("ChartComposable - datesList: $datesList")
    Timber.d("ChartComposable - datesList size: ${datesList.size}")

    Chart(list = valuesList, dates = datesList)
}

@Composable
private fun ShowDescription(description: String, goToDescription: (String) -> Unit) {
    NavigationListItem(
        textToShow = stringResource(R.string.description),
        onClick = { goToDescription(description) }
    )
}

@Composable
private fun ShowHomeLink(url: String) {
    val localUriHandler = LocalUriHandler.current
    NavigationListItem(
        textToShow = stringResource(R.string.homepage),
        onClick = { localUriHandler.openUri(url) }
    )
}

@Composable
private fun ShowImage(imageUrl: String, name: String) {
    // TODO a placeholder is needed
    Column(
        modifier = Modifier.fillMaxWidth(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        AsyncImage(
            model = imageUrl,
            modifier = Modifier
                .size(iconDimensLarge),
            contentScale = ContentScale.Fit,
            contentDescription = name,
            alignment = Alignment.Center

        )
    }
}


private fun LazyListScope.ShowHistory(data: List<CoinHistoricalData.PriceChartPoint>) {
    items(data.size) { item ->
        CoinHistoryListItem(
            history = data[item]
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
