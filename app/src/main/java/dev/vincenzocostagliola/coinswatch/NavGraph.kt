package dev.vincenzocostagliola.coinswatch

import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument


sealed class NavigationRoute() {
    abstract val route: String

    data object Home : NavigationRoute() {
        override val route: String = "home"
    }

    data object DetailsScreen : NavigationRoute() {
        fun createRoute(coinId: String) = "$route/$coinId"
        const val argumentId : String = "coinId"
        override val route: String = "detailScreen/{$argumentId}"
    }
}


@Composable
fun NavGraph(navController: NavHostController) {
    NavHost(navController = navController, startDestination = NavigationRoute.Home.route) {
        composable(NavigationRoute.Home.route) {
            val viewModel = hiltViewModel<HomeViewModel>()
            HomeScreen(viewModel, navController)
        }

        composable(
            route = NavigationRoute.DetailsScreen.route,
            arguments = listOf(navArgument(NavigationRoute.DetailsScreen.argumentId) { type = NavType.StringType })
        ) { backStackEntry ->
            val coinId = backStackEntry.arguments?.getString(NavigationRoute.DetailsScreen.argumentId)
            val viewModel = hiltViewModel<DetailScreenViewModel>()
            DetailScreen(viewModel, coinId)
        }

    }
}