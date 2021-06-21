package shvyn22.holidaysapplication.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import shvyn22.holidaysapplication.data.local.dao.FavoriteDao
import shvyn22.holidaysapplication.data.local.model.Holiday

@Database(entities = [Holiday::class], version = 1)
@TypeConverters(Converter::class)
abstract class AppDatabase : RoomDatabase() {

    abstract fun favoriteDao(): FavoriteDao
}