package shvyn22.flexingholidays.presentation.favorite

import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import shvyn22.flexingholidays.data.local.model.HolidayModel
import shvyn22.flexingholidays.presentation.MainViewModel
import shvyn22.flexingholidays.presentation.ui.components.FavoriteHolidayItem

@Composable
fun FavoriteScreen(
    viewModel: MainViewModel,
    modifier: Modifier = Modifier
) {
    val holidays = viewModel.favoriteHolidays.collectAsState()

    FavoriteContent(
        holidays = holidays.value,
        onDeleteFavoriteHoliday = viewModel::deleteFavoriteHoliday,
        modifier = modifier
    )
}

@Composable
fun FavoriteContent(
    holidays: List<HolidayModel>,
    onDeleteFavoriteHoliday: (HolidayModel) -> Unit,
    modifier: Modifier = Modifier,
) {
    LazyColumn(
        modifier = modifier
    ) {
        items(holidays) { holiday ->
            FavoriteHolidayItem(
                item = holiday,
                onDeleteFavoriteHoliday = onDeleteFavoriteHoliday,
                modifier = Modifier
                    .padding(6.dp)
            )
        }
    }
}