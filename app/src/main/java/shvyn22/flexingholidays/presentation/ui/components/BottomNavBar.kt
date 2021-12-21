package shvyn22.flexingholidays.presentation.ui.components

import androidx.annotation.StringRes
import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Public
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.stringResource
import androidx.navigation.NavHostController
import androidx.navigation.compose.*
import shvyn22.flexingholidays.R
import shvyn22.flexingholidays.presentation.MainViewModel
import shvyn22.flexingholidays.presentation.browse.BrowseScreen
import shvyn22.flexingholidays.presentation.favorite.FavoriteScreen

sealed class BottomNavScreens(
    val route: String,
    @StringRes val resourceId: Int,
    val icon: ImageVector
) {
    object Browse : BottomNavScreens("Browse", R.string.text_browse, Icons.Filled.Public)
    object Favorite : BottomNavScreens("Favorite", R.string.text_favorite, Icons.Filled.Favorite)
}

@Composable
fun MainScreenNavConfig(
    navController: NavHostController,
    viewModel: MainViewModel,
    modifier: Modifier = Modifier
) {
    NavHost(
        navController = navController,
        startDestination = BottomNavScreens.Browse.route
    ) {
        composable(BottomNavScreens.Browse.route) {
            BrowseScreen(
                viewModel = viewModel,
                modifier = modifier
            )
        }

        composable(BottomNavScreens.Favorite.route) {
            FavoriteScreen(
                viewModel = viewModel,
                modifier = modifier
            )
        }
    }
}

@Composable
fun HolidayBottomNavBar(
    navController: NavHostController,
    items: List<BottomNavScreens>
) {
    BottomNavigation {
        val navBackStackEntry by navController.currentBackStackEntryAsState()
        val currentRoute = navBackStackEntry?.destination?.route
        items.forEach { screen ->
            BottomNavigationItem(
                icon = {
                    Icon(
                        imageVector = screen.icon,
                        contentDescription = null
                    )
                },
                label = {
                    Text(
                        text = stringResource(id = screen.resourceId)
                    )
                },
                selected = currentRoute == screen.route,
                onClick = {
                    navController.navigate(screen.route) {
                        popUpTo(navController.graph.startDestinationId) {
                            saveState = true
                        }
                        launchSingleTop = true
                        restoreState = true
                    }
                })
        }
    }
}