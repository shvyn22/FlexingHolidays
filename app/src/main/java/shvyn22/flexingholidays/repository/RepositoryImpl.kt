package shvyn22.flexingholidays.repository

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import shvyn22.flexingholidays.data.local.dao.FavoriteDao
import shvyn22.flexingholidays.data.local.model.HolidayModel
import shvyn22.flexingholidays.data.remote.api.ApiService
import shvyn22.flexingholidays.data.util.fromHolidayDTOtoModel

class RepositoryImpl(
	private val api: ApiService,
	private val favoriteDao: FavoriteDao
) : Repository {

	override suspend fun getHolidays(code: String): Flow<List<HolidayModel>> = flow {
		val response = api.getHolidays(code)
		if (response.status == 200)
			emit(fromHolidayDTOtoModel(response.holidays))
		else
			emit(emptyList())
	}

	override fun getFavoriteHolidays() =
		favoriteDao.getFavoriteHolidays()

	override fun isHolidayFavorite(id: String) =
		favoriteDao.isHolidayFavorite(id)

	override suspend fun insertFavoriteHoliday(item: HolidayModel) =
		favoriteDao.insertFavoriteHoliday(item)

	override suspend fun deleteFavoriteHoliday(item: HolidayModel) =
		favoriteDao.deleteFavoriteHoliday(item)
}