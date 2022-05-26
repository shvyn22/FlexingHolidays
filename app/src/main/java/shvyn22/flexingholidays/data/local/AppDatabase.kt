package shvyn22.flexingholidays.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import shvyn22.flexingholidays.data.local.dao.FavoriteDao
import shvyn22.flexingholidays.data.local.model.HolidayModel

@Database(
	entities = [HolidayModel::class],
	version = 2
)
abstract class AppDatabase : RoomDatabase() {

	abstract fun favoriteDao(): FavoriteDao
}