package shvyn22.holidaysapplication.api

import shvyn22.holidaysapplication.data.local.model.Holiday

data class ApiResponse(
    val status: Int,
    val holidays: List<Holiday>
)
