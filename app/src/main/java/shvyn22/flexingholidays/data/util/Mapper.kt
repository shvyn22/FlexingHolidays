package shvyn22.flexingholidays.data.util

import shvyn22.flexingholidays.data.local.model.HolidayModel
import shvyn22.flexingholidays.data.remote.dto.HolidayDTO

fun fromHolidayDTOtoModel(item: HolidayDTO) =
    HolidayModel(
        uuid = item.uuid,
        name = item.name,
        date = item.date,
        isPublic = item.isPublic,
        country = item.country
    )

fun fromHolidayDTOtoModel(items: List<HolidayDTO>) =
    items.map { fromHolidayDTOtoModel(it) }