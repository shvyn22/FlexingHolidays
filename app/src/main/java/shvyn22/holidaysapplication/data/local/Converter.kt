package shvyn22.holidaysapplication.data.local

import androidx.room.TypeConverter
import shvyn22.holidaysapplication.data.local.model.Weekday

class Converter {

    @TypeConverter
    fun fromWeekdayToString(weekday: Weekday) = weekday.name

    @TypeConverter
    fun fromStringToWeekday(name: String) = Weekday(name)
}