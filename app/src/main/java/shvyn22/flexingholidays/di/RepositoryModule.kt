package shvyn22.flexingholidays.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import shvyn22.flexingholidays.data.local.dao.FavoriteDao
import shvyn22.flexingholidays.data.remote.api.ApiService
import shvyn22.flexingholidays.repository.Repository
import shvyn22.flexingholidays.repository.RepositoryImpl
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RepositoryModule {

    @Singleton
    @Provides
    fun provideRepository(
        apiService: ApiService,
        favoriteDao: FavoriteDao
    ): Repository = RepositoryImpl(apiService, favoriteDao)
}