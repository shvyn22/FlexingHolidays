package shvyn22.flexingholidays.presentation.ui.components

import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.res.stringResource
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState

@Composable
fun BottomNavBar(
	navController: NavHostController,
	items: List<Screen>
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
				}
			)
		}
	}
}