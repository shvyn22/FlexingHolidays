package shvyn22.flexingholidays.presentation.browse

import android.content.Context
import android.telephony.TelephonyManager
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import shvyn22.flexingholidays.presentation.MainViewModel
import shvyn22.flexingholidays.presentation.ui.components.HolidayItem

@Composable
fun BrowseScreen(
    viewModel: MainViewModel,
    modifier: Modifier = Modifier
) {
    val tm = LocalContext.current.
        getSystemService(Context.TELEPHONY_SERVICE) as TelephonyManager
    val holidays = viewModel.getHolidays(tm.networkCountryIso)
        .collectAsState(initial = emptyList())

    LazyColumn(
        modifier = modifier
    ) {
        items(holidays.value) { holiday ->
            val isFavorite = viewModel.isFavoriteItem(holiday.uuid)
                .collectAsState(initial = false)
            Box(
                Modifier
                    .padding(6.dp)
            ) {
                HolidayItem(
                    item = holiday,
                    isFavorite = isFavorite.value,
                    onAddToFavorite = viewModel::onAddToFavorite,
                    onRemoveFromFavorite = viewModel::onRemoveFromFavorite
                )
            }
        }
    }
}