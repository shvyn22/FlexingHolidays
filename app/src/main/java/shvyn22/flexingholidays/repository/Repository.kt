package shvyn22.flexingholidays.repository

import kotlinx.coroutines.flow.Flow
import shvyn22.flexingholidays.data.local.model.HolidayModel

interface Repository {
    suspend fun getHolidays(code: String): Flow<List<HolidayModel>>

    fun getFavoriteHolidays(): Flow<List<HolidayModel>>

    fun isHolidayFavorite(id: String): Flow<Boolean>

    suspend fun insertFavoriteHoliday(item: HolidayModel)

    suspend fun deleteFavoriteHoliday(item: HolidayModel)
}