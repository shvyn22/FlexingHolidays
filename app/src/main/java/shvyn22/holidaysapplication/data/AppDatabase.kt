package shvyn22.holidaysapplication.data

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import shvyn22.holidaysapplication.data.dao.FavoriteDao
import shvyn22.holidaysapplication.data.model.Holiday

@Database(entities = [Holiday::class], version = 1)
@TypeConverters(Converter::class)
abstract class AppDatabase : RoomDatabase(){

    abstract fun favoriteDao(): FavoriteDao
}