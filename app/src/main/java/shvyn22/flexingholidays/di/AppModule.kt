package shvyn22.flexingholidays.di

import android.app.Application
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.PreferenceDataStoreFactory
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.preferencesDataStoreFile
import androidx.room.Room
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import shvyn22.flexingholidays.api.ApiInterface
import shvyn22.flexingholidays.data.local.AppDatabase
import shvyn22.flexingholidays.data.local.dao.FavoriteDao
import shvyn22.flexingholidays.repository.Repository
import shvyn22.flexingholidays.repository.RepositoryImpl
import shvyn22.flexingholidays.util.BASE_URL
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Singleton
    @Provides
    fun provideRetrofit(): Retrofit =
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()

    @Singleton
    @Provides
    fun provideApiInterface(retrofit: Retrofit): ApiInterface =
        retrofit.create(ApiInterface::class.java)

    @Singleton
    @Provides
    fun provideDatabase(app: Application): AppDatabase =
        Room
            .databaseBuilder(
                app,
                AppDatabase::class.java,
                "App database"
            )
            .fallbackToDestructiveMigration()
            .build()

    @Singleton
    @Provides
    fun provideFavoriteDao(db: AppDatabase): FavoriteDao =
        db.favoriteDao()

    @Singleton
    @Provides
    fun provideDataStore(app: Application): DataStore<Preferences> =
        PreferenceDataStoreFactory.create(
            produceFile = {
                app.preferencesDataStoreFile("preferences")
            }
        )

    @Singleton
    @Provides
    fun provideRepository(
        api: ApiInterface,
        dao: FavoriteDao
    ): Repository = RepositoryImpl(api, dao)
}