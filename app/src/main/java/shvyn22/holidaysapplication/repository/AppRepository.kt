package shvyn22.holidaysapplication.repository

import android.content.Context
import android.telephony.TelephonyManager
import android.util.Log
import dagger.hilt.android.qualifiers.ApplicationContext
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.flow
import shvyn22.holidaysapplication.api.ApiInterface
import shvyn22.holidaysapplication.data.dao.FavoriteDao
import shvyn22.holidaysapplication.data.model.Holiday
import shvyn22.holidaysapplication.util.Constants.ERROR_FETCHING_REMOTE
import shvyn22.holidaysapplication.util.Resource
import javax.inject.Inject

class AppRepository @Inject constructor(
    private val api: ApiInterface,
    private val favoriteDao: FavoriteDao,
    @ApplicationContext val context: Context
) {
    suspend fun getHolidays(): List<Holiday>{

        val tm = context.getSystemService(Context.TELEPHONY_SERVICE) as TelephonyManager
        val code = tm.networkCountryIso
        val response = api.getHolidays(code, 2020)
        return response.holidays
    }

    fun getFavoriteHolidays() = favoriteDao.getFavorites()

    suspend fun isFavorite(id: String) = favoriteDao.exists(id)

    suspend fun addFavorite(item: Holiday) = favoriteDao.insert(item)

    suspend fun deleteFavorite(item: Holiday) = favoriteDao.delete(item)
}