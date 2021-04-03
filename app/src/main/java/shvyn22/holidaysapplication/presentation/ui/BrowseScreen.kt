package shvyn22.holidaysapplication.presentation.ui

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import shvyn22.holidaysapplication.presentation.MainViewModel
import shvyn22.holidaysapplication.presentation.ui.components.HolidayItem

@Composable
fun BrowseScreen(
    viewModel: MainViewModel,
    modifier: Modifier = Modifier
) {
    LazyColumn (
        modifier = modifier
    ){
        items(viewModel.holidays.value) { holiday ->
            Box(
                Modifier
                    .padding(6.dp)
            ) {
                HolidayItem(
                    item = holiday,
                    isFavorite = viewModel::isFavoriteItem,
                    onAddToFavorite = viewModel::onAddToFavorite,
                    onRemoveFromFavorite = viewModel::onRemoveFromFavorite
                )
            }
        }
    }
}