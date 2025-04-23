package dev.vincenzocostagliola.coinswatch

import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable

val home = "HOME"
val detailScreen = "detailScreen"


@Composable
fun NavGraph(navController: NavHostController) {
    NavHost(navController = navController, startDestination = home) {
        composable(home) {
            val viewModel = hiltViewModel<HomeViewModel>()
            HomeScreen(viewModel, navController)
        }
        composable(detailScreen) {
            val viewModel = hiltViewModel<DetailsViewModel>()
            DetailScreen(viewModel)
        }

    }
}