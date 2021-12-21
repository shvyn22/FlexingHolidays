package shvyn22.flexingholidays.presentation.favorite

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import shvyn22.flexingholidays.presentation.MainViewModel
import shvyn22.flexingholidays.presentation.ui.components.FavoriteHolidayItem

@Composable
fun FavoriteScreen(
    viewModel: MainViewModel,
    modifier: Modifier = Modifier
) {
    val holidays = viewModel.favoriteHolidays
        .collectAsState(initial = emptyList())

    LazyColumn (
        modifier = modifier
    ){
        items(holidays.value) { holiday ->
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