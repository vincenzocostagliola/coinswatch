package dev.vincenzocostagliola.coinswatch.details

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
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
import dev.vincenzocostagliola.coinswatch.details.DetailsScreenEvents.GetCoinData
import dev.vincenzocostagliola.coinswatch.details.DetailsScreenEvents.PerformDialogAction
import dev.vincenzocostagliola.data.error.DialogAction
import dev.vincenzocostagliola.data.error.ErrorResources
import dev.vincenzocostagliola.designsystem.composables.Chart
import dev.vincenzocostagliola.designsystem.composables.ErrorDialog
import dev.vincenzocostagliola.designsystem.composables.NavigationListItem
import dev.vincenzocostagliola.designsystem.composables.Progress
import dev.vincenzocostagliola.designsystem.composables.TopBar
import dev.vincenzocostagliola.designsystem.theme.ExtraLight
import dev.vincenzocostagliola.designsystem.values.Dimens
import dev.vincenzocostagliola.designsystem.values.Dimens.iconDimensLarge
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
    val viewState = state.value
    Timber.d("DetailsScreen - ViewState: $viewState")

    when (viewState) {
        is DetailsScreenState.Error -> {
            ShowError(viewState.error.newResources) {
                viewModel.sendEvent(PerformDialogAction(it))
            }
        }

        DetailsScreenState.Loading -> {
            Progress(true)
            viewModel.sendEvent(GetCoinData(coinId))
        }

        is DetailsScreenState.Success -> {
            Progress(false)
            ShowDetails(viewState.data, onBackPressed, goToDescription)
        }

        DetailsScreenState.GoBack -> {
            navigationController.popBackStack()
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
        Column(
            modifier = modifier
                .padding(it)
                .fillMaxSize()
                .padding(Dimens.XRegular)
                .verticalScroll(rememberScrollState())
        ) {
            ShowImage(data.image.large, data.name)
            data.url?.let {
                ShowHomeLink(it)
            }
            ShowDescription(data.description, goToDescription)
            ShowChart(data.history)
        }
    }
}

@Composable
fun ShowChart(history: CoinHistory) {
    Timber.d("ChartComposable - prices: ${history.chartPricesPoints}")
    Timber.d("ChartComposable - datesList: ${history.chartDates}")
    Timber.d("ChartComposable - chartFormattedPrices: ${history.chartFormattedPrices}")

    Chart(
        chartPricesPoints = history.chartPricesPoints,
        chartDates = history.chartDates,
        chartFormattedPrices = history.chartFormattedPrices
    )
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

@Preview
@Composable
fun ShowImagePreview() {
    /*ShowImage(
        imageUrl = "https://assets.coingecko.com/coins/images/1/large/bitcoin.png?1696501400",
        name = "Bitcoin"
    )*/
}
