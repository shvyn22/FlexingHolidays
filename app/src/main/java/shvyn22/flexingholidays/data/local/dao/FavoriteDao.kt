package shvyn22.flexingholidays.data.local.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import kotlinx.coroutines.flow.Flow
import shvyn22.flexingholidays.data.local.model.Holiday

@Dao
interface FavoriteDao {

    @Query("SELECT * FROM Favorite")
    fun getFavorites(): Flow<List<Holiday>>

    @Query("SELECT EXISTS (SELECT 1 FROM Favorite WHERE uuid = :id)")
    fun exists(id: String): Flow<Boolean>

    @Insert
    suspend fun insert(item: Holiday)

    @Delete
    suspend fun delete(item: Holiday)
}