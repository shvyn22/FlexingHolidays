package shvyn22.flexingholidays.data.remote.api

import retrofit2.http.GET
import retrofit2.http.Query
import shvyn22.flexingholidays.BuildConfig
import shvyn22.flexingholidays.data.local.model.HolidayModel
import shvyn22.flexingholidays.data.remote.dto.HolidayDTO
import shvyn22.flexingholidays.util.REQUEST_YEAR

interface ApiService {

    @GET("holidays")
    suspend fun getHolidays(
        @Query("country") country: String,
        @Query("year") year: Int = REQUEST_YEAR,
        @Query("key") key: String = BuildConfig.API_KEY
    ): ApiResponse<HolidayDTO>
}