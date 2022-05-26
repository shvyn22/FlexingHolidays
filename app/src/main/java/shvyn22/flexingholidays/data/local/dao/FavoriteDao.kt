package shvyn22.flexingholidays.data.local.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import kotlinx.coroutines.flow.Flow
import shvyn22.flexingholidays.data.local.model.HolidayModel

@Dao
interface FavoriteDao {

    @Query("SELECT * FROM Favorite")
    fun getFavoriteHolidays(): Flow<List<HolidayModel>>

    @Query("SELECT EXISTS (SELECT 1 FROM Favorite WHERE uuid = :id)")
    fun isHolidayFavorite(id: String): Flow<Boolean>

    @Insert
    suspend fun insertFavoriteHoliday(item: HolidayModel)

    @Delete
    suspend fun deleteFavoriteHoliday(item: HolidayModel)
}