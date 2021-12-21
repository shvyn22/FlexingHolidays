package shvyn22.flexingholidays.api

import shvyn22.flexingholidays.data.local.model.Holiday

data class ApiResponse(
    val status: Int,
    val holidays: List<Holiday>
)
