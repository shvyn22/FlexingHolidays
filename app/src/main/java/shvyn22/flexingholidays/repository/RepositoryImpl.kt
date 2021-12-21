package shvyn22.flexingholidays.repository

import shvyn22.flexingholidays.api.ApiInterface
import shvyn22.flexingholidays.data.local.dao.FavoriteDao
import shvyn22.flexingholidays.data.local.model.Holiday
import javax.inject.Inject

class RepositoryImpl(
    private val api: ApiInterface,
    private val favoriteDao: FavoriteDao
) : Repository {

    override suspend fun getHolidays(code: String): List<Holiday>{
        val response = api.getHolidays(code)
        return response.holidays
    }

    override fun getFavoriteHolidays() = favoriteDao.getFavorites()

    override fun isFavorite(id: String) = favoriteDao.exists(id)

    override suspend fun addFavorite(item: Holiday) = favoriteDao.insert(item)

    override suspend fun deleteFavorite(item: Holiday) = favoriteDao.delete(item)
}