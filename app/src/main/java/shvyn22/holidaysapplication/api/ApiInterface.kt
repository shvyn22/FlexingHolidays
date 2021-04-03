package shvyn22.holidaysapplication.api

import retrofit2.http.GET
import retrofit2.http.Query
import shvyn22.holidaysapplication.util.Constants.API_KEY

interface ApiInterface {
    @GET("holidays")
    suspend fun getHolidays(
        @Query("country") country: String,
        @Query("year") year: Int,
        @Query("key") key: String = API_KEY
    ) : ApiResponse
}