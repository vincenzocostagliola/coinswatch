package dev.vincenzocostagliola.home.ui

import android.provider.CalendarContract.Colors
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.consumeWindowInsets
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Refresh
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.State
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import dev.vincenzocostagliola.data.error.DialogAction
import dev.vincenzocostagliola.data.error.ErrorResources
import dev.vincenzocostagliola.data.navigation.NavigationRoute
import dev.vincenzocostagliola.designsystem.composables.CoinShortInfoListItem
import dev.vincenzocostagliola.designsystem.composables.CoinUi
import dev.vincenzocostagliola.designsystem.composables.ErrorDialog
import dev.vincenzocostagliola.designsystem.composables.Progress
import dev.vincenzocostagliola.designsystem.composables.TopBar
import dev.vincenzocostagliola.designsystem.theme.ExtraLight
import dev.vincenzocostagliola.designsystem.theme.Purple40
import dev.vincenzocostagliola.designsystem.values.Dimens
import timber.log.Timber

@Composable
fun HomeScreen(viewModel: HomeViewModel, navigationController: NavHostController) {

    val state: State<HomeScreenState> = viewModel.homeScreenState.collectAsState()
    val viewState = state.value
    Timber.d("HomeScreen - ViewState: $viewState")

    when (viewState) {
        is HomeScreenState.Error -> {
            ShowError(viewState.error.newResources) {
                viewModel.sendEvent(HomeScreenEvents.PerformDialogAction(it))
            }
        }

        HomeScreenState.Loading -> {
            Progress(true)
        }

        is HomeScreenState.Success -> {
            Progress(false)
            ShowCoinList(
                viewState.list,
                onClick = { coinId ->
                    Timber.d("Coin Navigation - sent = $coinId")
                    navigationController.navigate(NavigationRoute.DetailsScreen.createRoute(coinId))
                },
                refresh = {
                    viewModel.sendEvent(HomeScreenEvents.GetCoinsData)
                }
            )
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
private fun ShowCoinList(list: List<CoinUi>, onClick: (String) -> Unit, refresh: () -> Unit) {
    Scaffold(
        modifier = Modifier
            .background(ExtraLight),
        floatingActionButton = {
            FloatingActionButton(
                onClick = refresh,
                containerColor = Purple40,
                contentColor = ExtraLight
            ) {
                Icon(Icons.Filled.Refresh, "")
            }
        },
        content = { innerPadding ->
            LazyColumn(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(horizontal = Dimens.XRegular)
                    .consumeWindowInsets(innerPadding)
            ) {
                items(list.size) { item ->
                    CoinShortInfoListItem(
                        coin = list[item],
                        onClick = onClick
                    )
                }
            }
        }
    )
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