package dev.vincenzocostagliola.coinswatch.home

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.runtime.State
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import dev.vincenzocostagliola.coinswatch.NavigationRoute
import dev.vincenzocostagliola.data.domain.Coin
import dev.vincenzocostagliola.designsystem.composables.CoinShortInfoListItem
import dev.vincenzocostagliola.designsystem.composables.Progress
import dev.vincenzocostagliola.designsystem.values.Dimens
import timber.log.Timber

@Composable
internal fun HomeScreen(viewModel: HomeViewModel, navigationController: NavHostController) {

    val state: State<HomeScreenState> = viewModel.homeScreenState.collectAsState()
    when (val viewState = state.value) {
        is HomeScreenState.Error -> Unit
        HomeScreenState.Loading -> {
            Progress(true)
            viewModel.sendEvent(HomeScreenEvents.GetCoinsData)
        }

        is HomeScreenState.Success -> {
            Progress(false)
            ShowCoinList(viewState.list) { coinId ->
                Timber.d("Coin Navigation - sent = $coinId")
                navigationController.navigate(NavigationRoute.DetailsScreen.createRoute(coinId))
            }
        }
    }
}

@Composable
private fun ShowCoinList(list: List<Coin>, onClick: (String) -> Unit) {
    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .padding(horizontal = Dimens.XRegular)
    ) {
        items(list.size) { item ->
            CoinShortInfoListItem(
                coin = list[item],
                onClick = onClick
            )
        }
    }
}
/*
@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    CoinswatchTheme {
        // ShowCoinList(emptyList())
    }
}

 */