package shvyn22.flexingholidays.presentation.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Public
import androidx.compose.material.icons.outlined.FavoriteBorder
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import shvyn22.flexingholidays.data.local.model.HolidayModel
import shvyn22.flexingholidays.presentation.ui.theme.*

@Composable
fun HolidayItem(
    item: HolidayModel,
    isFavorite: Boolean,
    onInsertFavoriteHoliday: (HolidayModel) -> Unit,
    onDeleteFavoriteHoliday: (HolidayModel) -> Unit,
    modifier: Modifier = Modifier
) {
    Card(
        modifier = modifier
            .fillMaxWidth()
    ) {
        Row(
            modifier = Modifier
                .background(
                    estimateSeason(item.date).let { season ->
                        if (MaterialTheme.colors.isLight) season.colorLight
                        else season.colorDark
                    }
                )
                .padding(5.dp),
        ) {
            Icon(
                imageVector = if (item.isPublic) Icons.Filled.Public else Icons.Filled.Person,
                contentDescription = null,
                modifier = Modifier
                    .padding(end = 10.dp)
                    .align(Alignment.CenterVertically)
                    .weight(0.1f)
            )
            Column(
                modifier = Modifier
                    .padding(end = 10.dp)
                    .weight(0.8f)
            ) {
                Text(
                    text = "${item.name} (${item.country})",
                    style = MaterialTheme.typography.body1,
                )
                Text(
                    text = item.date,
                    style = MaterialTheme.typography.body2,
                )
            }
            IconButton(
                onClick = {
                    if (isFavorite) onDeleteFavoriteHoliday(item)
                    else onInsertFavoriteHoliday(item)
                },
                modifier = Modifier
                    .align(Alignment.CenterVertically)
                    .weight(0.1f)
            ) {
                Icon(
                    imageVector = if (isFavorite) Icons.Filled.Favorite
                    else Icons.Outlined.FavoriteBorder,
                    contentDescription = null,
                )
            }
        }
    }
}

@Composable
fun FavoriteHolidayItem(
    item: HolidayModel,
    onDeleteFavoriteHoliday: (HolidayModel) -> Unit,
    modifier: Modifier = Modifier
) {
    HolidayItem(
        item = item,
        isFavorite = true,
        onInsertFavoriteHoliday = { },
        onDeleteFavoriteHoliday = onDeleteFavoriteHoliday,
        modifier = modifier
    )
}

enum class Season(
    val colorLight: Color,
    val colorDark: Color
) {
    WINTER(capri500, capri400),
    SPRING(springBud500, springBud400),
    SUMMER(yellow500, yellow400),
    AUTUMN(orange500, orange400)
}

fun estimateSeason(
    date: String
): Season {
    val month = date
        .slice(
            date.indexOfFirst { it == '-' } + 1
                until date.indexOfLast { it == '-' }
        )
        .toInt()

    return when (month) {
        in 3..5 -> Season.SPRING
        in 6..8 -> Season.SUMMER
        in 9..11 -> Season.AUTUMN
        else -> Season.WINTER
    }
}


