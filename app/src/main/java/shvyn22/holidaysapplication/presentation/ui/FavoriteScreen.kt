package shvyn22.holidaysapplication.presentation.ui

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import shvyn22.holidaysapplication.presentation.MainViewModel
import shvyn22.holidaysapplication.presentation.ui.components.FavoriteHolidayItem

@Composable
fun FavoriteScreen(
    viewModel: MainViewModel,
    modifier: Modifier = Modifier
) {
    LazyColumn (
        modifier = modifier
    ){
        items(viewModel.favoriteHolidays.value) { holiday ->
            Box(
                Modifier
                    .padding(6.dp)
            ) {
                FavoriteHolidayItem(
                    item = holiday,
                    onRemoveFromFavorite = viewModel::onRemoveFromFavorite
                )
            }
        }
    }
}