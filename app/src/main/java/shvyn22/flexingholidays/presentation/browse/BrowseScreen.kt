package shvyn22.flexingholidays.presentation.browse

import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import kotlinx.coroutines.flow.Flow
import shvyn22.flexingholidays.data.local.model.HolidayModel
import shvyn22.flexingholidays.presentation.MainViewModel
import shvyn22.flexingholidays.presentation.ui.components.HolidayItem

@Composable
fun BrowseScreen(
    viewModel: MainViewModel,
    modifier: Modifier = Modifier
) {
    val holidays = viewModel.holidays.collectAsState()

    BrowseContent(
        holidays = holidays.value,
        isHolidayFavorite = viewModel::isHolidayFavorite,
        onInsertFavoriteHoliday = viewModel::insertFavoriteHoliday,
        onDeleteFavoriteHoliday = viewModel::deleteFavoriteHoliday,
        modifier = modifier
    )
}

@Composable
fun BrowseContent(
    holidays: List<HolidayModel>,
    isHolidayFavorite: (String) -> Flow<Boolean>,
    onInsertFavoriteHoliday: (HolidayModel) -> Unit,
    onDeleteFavoriteHoliday: (HolidayModel) -> Unit,
    modifier: Modifier = Modifier,
) {
    LazyColumn(
        modifier = modifier
    ) {
        items(holidays) { holiday ->
            val isFavorite = isHolidayFavorite(holiday.uuid).collectAsState(initial = false)

            HolidayItem(
                item = holiday,
                isFavorite = isFavorite.value,
                onInsertFavoriteHoliday = onInsertFavoriteHoliday,
                onDeleteFavoriteHoliday = onDeleteFavoriteHoliday,
                modifier = Modifier
                    .padding(6.dp)
            )
        }
    }
}