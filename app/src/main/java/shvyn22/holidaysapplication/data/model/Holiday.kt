package shvyn22.holidaysapplication.data.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "Favorite")
data class Holiday(
    @PrimaryKey
    var uuid: String = "",
    var name: String = "",
    var date: String = "",
    var public: Boolean = false,
    var country: String = "",
    var weekday: Weekday = Weekday(""),
)

data class Weekday(
    val name: String = ""
)