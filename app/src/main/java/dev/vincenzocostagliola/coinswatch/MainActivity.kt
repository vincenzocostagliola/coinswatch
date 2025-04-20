package dev.vincenzocostagliola.coinswatch

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.State
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import dagger.hilt.android.AndroidEntryPoint
import dev.vincenzocostagliola.coinswatch.ui.theme.CoinswatchTheme
import dev.vincenzocostagliola.data.domain.Coin
import dev.vincenzocostagliola.coinswatch.ui.Dimens
import dev.vincenzocostagliola.coinswatch.ui.OutlinedCard
import dev.vincenzocostagliola.coinswatch.ui.Progress
import kotlin.getValue

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    private val mainViewModel: MainViewModel by viewModels()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            CoinswatchTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    MainScreen(mainViewModel)
                }
            }
        }
    }

    @Composable
    private fun MainScreen(viewModel: MainViewModel) {

        val state: State<MainScreenState> = viewModel.mainScreenState.collectAsState()
        when (val viewState = state.value) {
            is MainScreenState.Error -> Unit
            MainScreenState.Loading -> {
                Progress(true)
                viewModel.sendEvent(MainScreenEvents.GetCoinsData)
            }

            is MainScreenState.Success -> {
                Progress(false)
                ShowCoinList(viewState.list)
            }
        }

    }
}

@Composable
fun ShowCoinList(list: List<Coin>) {
    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .padding(horizontal = Dimens.XRegular)
        //.verticalScroll(rememberScrollState()),
    ) {
        items(list.size) { item ->
            OutlinedCard(item = list[item])
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    CoinswatchTheme {
        ShowCoinList(emptyList())
    }
}
