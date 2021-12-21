package shvyn22.flexingholidays.repository

import kotlinx.coroutines.flow.Flow
import shvyn22.flexingholidays.data.local.model.Holiday

interface Repository {
    suspend fun getHolidays(code: String): List<Holiday>

    fun getFavoriteHolidays(): Flow<List<Holiday>>

    fun isFavorite(id: String): Flow<Boolean>

    suspend fun addFavorite(item: Holiday)

    suspend fun deleteFavorite(item: Holiday)
}