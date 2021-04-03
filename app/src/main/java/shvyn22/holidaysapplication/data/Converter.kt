package shvyn22.holidaysapplication.data

import androidx.room.TypeConverter
import shvyn22.holidaysapplication.data.model.Weekday

class Converter {

    @TypeConverter
    fun fromWeekdayToString(weekday: Weekday) = weekday.name

    @TypeConverter
    fun fromStringToWeekday(name: String) = Weekday(name)
}