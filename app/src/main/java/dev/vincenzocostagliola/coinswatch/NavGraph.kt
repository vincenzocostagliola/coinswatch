package dev.vincenzocostagliola.coinswatch

import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController

val home = "HOME"
val detailScreen = "detailScreen"


@Composable
fun NavGraph(navController: NavHostController) {
    NavHost(navController = navController, startDestination = home) {
        composable(home) {
            val viewModel = hiltViewModel<MainViewModel>()
            HomeScreen(viewModel, navController)
        }


    }
}