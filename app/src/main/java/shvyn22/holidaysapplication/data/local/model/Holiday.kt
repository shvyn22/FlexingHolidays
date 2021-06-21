package shvyn22.holidaysapplication.data.local.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "Favorite")
data class Holiday(
    @PrimaryKey
    @ColumnInfo(name = "uuid")
    var uuid: String = "",

    @ColumnInfo(name = "name")
    var name: String = "",

    @ColumnInfo(name = "date")
    var date: String = "",

    @ColumnInfo(name = "public")
    var public: Boolean = false,

    @ColumnInfo(name = "country")
    var country: String = "",

    @ColumnInfo(name = "weekday")
    var weekday: Weekday = Weekday(""),
)

data class Weekday(
    val name: String = ""
)