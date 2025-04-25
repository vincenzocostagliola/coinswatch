package dev.vincenzocostagliola.coinswatch

import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import dev.vincenzocostagliola.coinswatch.NavigationRoute.DescriptionScreen
import dev.vincenzocostagliola.coinswatch.details.DescriptionScreen
import dev.vincenzocostagliola.coinswatch.details.DetailsScreen
import dev.vincenzocostagliola.coinswatch.details.DetailsScreenViewModel
import dev.vincenzocostagliola.coinswatch.home.HomeScreen
import dev.vincenzocostagliola.coinswatch.home.HomeViewModel
import timber.log.Timber


sealed class NavigationRoute() {
    abstract val route: String

    data object Home : NavigationRoute() {
        override val route: String = "home"
    }

    data object DetailsScreen : NavigationRoute() {
        fun createRoute(coinId: String) = "$screenName?$argumentId=${coinId}"
        const val argumentId: String = "coinId"
        private val screenName: String = "detailScreen"
        override val route: String = "$screenName?$argumentId={$argumentId}"
    }

    data object DescriptionScreen : NavigationRoute() {
        fun createRoute(description: String) = "$screenName?$argumentId=${description}"
        const val argumentId: String = "description"
        private val screenName: String = "DescriptionScreen"
        override val route: String = "$screenName?$argumentId={$argumentId}"
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
            arguments = listOf(navArgument(NavigationRoute.DetailsScreen.argumentId) {
                type = NavType.StringType
            })
        ) { backStackEntry ->
            val coinId =
                backStackEntry.arguments?.getString(NavigationRoute.DetailsScreen.argumentId)
            Timber.d("Coin Navigation - received coinId = $coinId")
            val viewModel = hiltViewModel<DetailsScreenViewModel>()
            val onBackPressed: () -> Unit = { navController.popBackStack() }
            DetailsScreen(
                viewModel = viewModel,
                navigationController = navController,
                coinId = coinId,
                onBackPressed = onBackPressed
            )
        }

        composable(
            route = DescriptionScreen.route,
            arguments = listOf(navArgument(DescriptionScreen.argumentId) {
                type = NavType.StringType
            })
        ) { backStackEntry ->
            val description =
                backStackEntry.arguments?.getString(DescriptionScreen.argumentId) ?: ""
            Timber.d("Coin Navigation - received Description = $description")

            val onBackPressed: () -> Unit = { navController.popBackStack() }
            DescriptionScreen(description, onBackPressed)
        }

    }
}