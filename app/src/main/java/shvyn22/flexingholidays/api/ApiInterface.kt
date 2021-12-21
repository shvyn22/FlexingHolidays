package shvyn22.flexingholidays.api

import retrofit2.http.GET
import retrofit2.http.Query
import shvyn22.flexingholidays.BuildConfig

interface ApiInterface {

    @GET("holidays")
    suspend fun getHolidays(
        @Query("country") country: String,
        @Query("year") year: Int = 2020,
        @Query("key") key: String = BuildConfig.API_KEY
    ): ApiResponse
}