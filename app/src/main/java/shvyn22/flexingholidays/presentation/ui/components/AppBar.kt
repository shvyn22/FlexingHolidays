package shvyn22.flexingholidays.presentation.ui.components

import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.DarkMode
import androidx.compose.material.icons.filled.LightMode
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import shvyn22.flexingholidays.R

@Composable
fun AppBar(
    isDarkTheme: Boolean,
    onToggleTheme: (Boolean) -> Unit,
    modifier: Modifier = Modifier
) {
    TopAppBar(
        title = { Text(stringResource(id = R.string.app_name)) },
        actions = {
            IconButton(
                onClick = { onToggleTheme(!isDarkTheme) }
            ) {
                Icon(
                    imageVector = if (isDarkTheme) Icons.Filled.LightMode
                    else Icons.Filled.DarkMode,
                    contentDescription = null
                )
            }
        },
        modifier = modifier
    )
}