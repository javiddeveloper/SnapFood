package ir.javid.satttar.snapfood.presentation.navigation

import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.toRoute
import ir.javid.satttar.snapfood.presentation.ui.DetailRoute
import ir.javid.satttar.snapfood.presentation.ui.MainRoute
import ir.javid.satttar.snapfood.presentation.viewModel.MainViewModel
import kotlinx.serialization.Serializable
/**
 * @author  : Javid
 * @summary : AppNavHost
 */

object Screen {
    @Serializable
    object MainRoute

    @Serializable
    data class DetailRoute(val param: Int)
}

@Composable
fun AppNavHost(navController: NavHostController) {

    val mainViewModel: MainViewModel = hiltViewModel()

    NavHost(navController = navController, startDestination = Screen.MainRoute) {
        composable<Screen.MainRoute> {
            MainRoute(
                viewModel = mainViewModel,
                detailClick = {
                    navController.navigate(Screen.DetailRoute(it.id))
                }
            )
        }
        composable<Screen.DetailRoute> { backStackEntry ->
            val videoId = backStackEntry.toRoute<Screen.DetailRoute>()
            DetailRoute(viewModel = mainViewModel, videoId = videoId.param)
        }
    }
}