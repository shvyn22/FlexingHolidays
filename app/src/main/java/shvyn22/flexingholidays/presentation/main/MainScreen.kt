package shvyn22.flexingholidays.presentation.main

import androidx.compose.foundation.layout.padding
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.rememberNavController
import shvyn22.flexingholidays.presentation.MainViewModel
import shvyn22.flexingholidays.presentation.ui.components.AppBar
import shvyn22.flexingholidays.presentation.ui.components.BottomNavBar
import shvyn22.flexingholidays.presentation.ui.components.NavigationConfig
import shvyn22.flexingholidays.presentation.ui.components.Screen

@Composable
fun MainScreen(
	viewModel: MainViewModel,
	modifier: Modifier = Modifier
) {
	val navController = rememberNavController()
	val bottomNavItems = listOf(
		Screen.Browse,
		Screen.Favorite
	)

	val isDarkTheme = !MaterialTheme.colors.isLight

	Scaffold(
		topBar = {
			AppBar(
				isDarkTheme = isDarkTheme,
				onToggleTheme = viewModel::editThemePreferences
			)
		},
		bottomBar = {
			BottomNavBar(
				navController = navController,
				items = bottomNavItems
			)
		}
	) { innerPadding ->
		NavigationConfig(
			navController = navController,
			viewModel = viewModel,
			modifier = modifier
				.padding(innerPadding)
		)
	}
}