package shvyn22.flexingholidays.presentation.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material.icons.filled.Public
import androidx.compose.material.icons.outlined.FavoriteBorder
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import shvyn22.flexingholidays.data.local.model.Holiday
import shvyn22.flexingholidays.presentation.ui.theme.capri
import shvyn22.flexingholidays.presentation.ui.theme.orange
import shvyn22.flexingholidays.presentation.ui.theme.springBud
import shvyn22.flexingholidays.presentation.ui.theme.yellow

@Composable
fun HolidayItem(
    item: Holiday,
    isFavorite: Boolean,
    onAddToFavorite: (Holiday) -> Unit,
    onRemoveFromFavorite: (Holiday) -> Unit,
    modifier: Modifier = Modifier
) {
    Surface(
        modifier = Modifier
            .fillMaxWidth()
    ) {
        Row(
            modifier = modifier
                .background(estimateSeason(item.date).color)
                .padding(5.dp),
        ) {
            Icon(
                imageVector = if (item.isPublic) Icons.Filled.Public else Icons.Filled.Lock,
                contentDescription = null,
                modifier = Modifier
                    .padding(end = 10.dp)
                    .align(Alignment.CenterVertically)
                    .weight(1f)
            )
            Column(
                modifier = Modifier
                    .padding(end = 10.dp)
                    .weight(8f)
            ) {
                Text(
                    text = "${item.name} (${item.country})",
                    style = MaterialTheme.typography.body1,
                    color = Color.Black
                )
                Text(
                    text = item.date,
                    style = MaterialTheme.typography.body2,
                    color = Color.Black
                )
            }
            IconButton(
                onClick = {
                    if (isFavorite) onRemoveFromFavorite(item)
                    else onAddToFavorite(item)
                },
                modifier = Modifier
                    .align(Alignment.CenterVertically)
                    .weight(1f)
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
    item: Holiday,
    onRemoveFromFavorite: (Holiday) -> Unit,
    modifier: Modifier = Modifier
) {
    HolidayItem(
        item = item,
        isFavorite = true,
        onAddToFavorite = { },
        onRemoveFromFavorite = onRemoveFromFavorite,
        modifier = modifier
    )
}

enum class Seasons(val color: Color) {
    WINTER(capri),
    SPRING(springBud),
    SUMMER(yellow),
    AUTUMN(orange)
}

fun estimateSeason(date: String): Seasons {
    val month = date.slice(
        date.indexOfFirst { it == '-' } + 1
            until date.indexOfLast { it == '-' }).toInt()

    return when (month) {
        in 3..5 -> Seasons.SPRING
        in 6..8 -> Seasons.SUMMER
        in 9..11 -> Seasons.AUTUMN
        else -> Seasons.WINTER
    }
}


