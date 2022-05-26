package shvyn22.flexingholidays.data.remote.api

data class ApiResponse<T>(
    val status: Int,
    val holidays: List<T>
)
