package shvyn22.flexingholidays.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import shvyn22.flexingholidays.data.local.dao.FavoriteDao
import shvyn22.flexingholidays.data.local.model.Holiday

@Database(entities = [Holiday::class], version = 2)
abstract class AppDatabase : RoomDatabase() {

    abstract fun favoriteDao(): FavoriteDao
}