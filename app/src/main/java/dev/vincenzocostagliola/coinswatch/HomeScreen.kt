package dev.vincenzocostagliola.coinswatch

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.runtime.State
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import dev.vincenzocostagliola.data.domain.Coin
import dev.vincenzocostagliola.designsystem.composables.CoinShortInfoListItem
import dev.vincenzocostagliola.designsystem.composables.Progress
import dev.vincenzocostagliola.designsystem.values.Dimens

@Composable
fun HomeScreen(viewModel: MainViewModel, navigationController: NavHostController) {

    val state: State<MainScreenState> = viewModel.mainScreenState.collectAsState()
    when (val viewState = state.value) {
        is MainScreenState.Error -> Unit
        MainScreenState.Loading -> {
            Progress(true)
            viewModel.sendEvent(MainScreenEvents.GetCoinsData)
        }

        is MainScreenState.Success -> {
            Progress(false)
            ShowCoinList(viewState.list) {
                navigationController.navigate(detailScreen)
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