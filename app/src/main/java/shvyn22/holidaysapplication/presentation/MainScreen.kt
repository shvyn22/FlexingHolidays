package shvyn22.holidaysapplication.presentation

import androidx.compose.foundation.layout.padding
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.DarkMode
import androidx.compose.material.icons.filled.LightMode
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.navigation.compose.rememberNavController
import shvyn22.holidaysapplication.R
import shvyn22.holidaysapplication.presentation.ui.components.BottomNavScreens
import shvyn22.holidaysapplication.presentation.ui.components.HolidayBottomNavBar
import shvyn22.holidaysapplication.presentation.ui.components.MainScreenNavConfig

@Composable
fun MainScreen(
    viewModel: MainViewModel,
    isDarkTheme: Boolean
) {
    val navController = rememberNavController()
    val bottomNavItems = listOf(
        BottomNavScreens.Browse,
        BottomNavScreens.Favorite
    )

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text(stringResource(id = R.string.app_name)) },
                actions = {
                    IconButton(
                        onClick = {
                            viewModel.onToggleMode(!isDarkTheme)
                        }
                    ) {
                        Icon(
                            imageVector = if (isDarkTheme) Icons.Filled.LightMode
                            else Icons.Filled.DarkMode,
                            contentDescription = null
                        )
                    }
                }
            )
        },
        bottomBar = {
            HolidayBottomNavBar(
                navController = navController,
                items = bottomNavItems
            )
        }
    ) { innerPadding ->
        MainScreenNavConfig(
            navController = navController,
            viewModel = viewModel,
            modifier = Modifier
                .padding(innerPadding)
        )
    }
}