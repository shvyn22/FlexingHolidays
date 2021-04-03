package shvyn22.holidaysapplication.presentation.ui.components

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
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import kotlinx.coroutines.flow.Flow
import shvyn22.holidaysapplication.data.model.Holiday
import shvyn22.holidaysapplication.presentation.ui.theme.*

@Composable
fun HolidayItem(
    item: Holiday,
    isFavorite: (String) -> Flow<Boolean>,
    onAddToFavorite: (Holiday) -> Unit,
    onRemoveFromFavorite: (Holiday) -> Unit,
    modifier: Modifier = Modifier
) {
    val isFavoriteState = isFavorite(item.uuid).collectAsState(false)
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
                imageVector = if (item.public) Icons.Filled.Public else Icons.Filled.Lock,
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
                )
                Text(
                    text = item.date,
                    style = MaterialTheme.typography.body2
                )
            }
            IconButton(
                onClick = {
                    if (isFavoriteState.value) onRemoveFromFavorite(item)
                    else onAddToFavorite(item)
                },
                modifier = Modifier
                    .align(Alignment.CenterVertically)
                    .weight(1f)
            ) {
                Icon(
                    imageVector = if (isFavoriteState.value) Icons.Filled.Favorite
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
    Surface(
        modifier = Modifier
            .fillMaxWidth()
    ) {
        Row(
            modifier = modifier
                .background(estimateSeason(item.date).color)
                .padding(6.dp),
        ) {
            Icon(
                imageVector = if (item.public) Icons.Filled.Public else Icons.Filled.Lock,
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
                )
                Text(
                    text = item.date,
                    style = MaterialTheme.typography.body2
                )
            }
            IconButton(
                onClick = { onRemoveFromFavorite(item) },
                modifier = Modifier
                    .align(Alignment.CenterVertically)
                    .weight(1f)
            ) {
                Icon(
                    imageVector = Icons.Filled.Favorite,
                    contentDescription = null,
                )
            }
        }
    }
}

enum class Seasons(val color: Color) {
    WINTER(capri),
    SPRING(springBud),
    SUMMER(yellow),
    AUTUMN(orange)
}

fun estimateSeason(date: String) : Seasons{
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


