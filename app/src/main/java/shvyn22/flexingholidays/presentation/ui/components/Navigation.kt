package shvyn22.flexingholidays.presentation.ui.components

import androidx.annotation.StringRes
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Public
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import shvyn22.flexingholidays.R
import shvyn22.flexingholidays.presentation.MainViewModel
import shvyn22.flexingholidays.presentation.browse.BrowseScreen
import shvyn22.flexingholidays.presentation.favorite.FavoriteScreen

enum class Screen(
    val route: String,
    @StringRes val resourceId: Int,
    val icon: ImageVector
) {
    Browse("Browse", R.string.text_browse, Icons.Filled.Public),
    Favorite("Favorite", R.string.text_favorite, Icons.Filled.Favorite)
}

@Composable
fun NavigationConfig(
    navController: NavHostController,
    viewModel: MainViewModel,
    modifier: Modifier = Modifier
) {
    NavHost(
        navController = navController,
        startDestination = Screen.Browse.route
    ) {
        composable(Screen.Browse.route) {
            BrowseScreen(
                viewModel = viewModel,
                modifier = modifier
            )
        }

        composable(Screen.Favorite.route) {
            FavoriteScreen(
                viewModel = viewModel,
                modifier = modifier
            )
        }
    }
}