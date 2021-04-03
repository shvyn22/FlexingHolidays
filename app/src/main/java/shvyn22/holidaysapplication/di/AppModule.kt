package shvyn22.holidaysapplication.di

import android.app.Application
import androidx.room.Room
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import shvyn22.holidaysapplication.api.ApiInterface
import shvyn22.holidaysapplication.data.AppDatabase
import shvyn22.holidaysapplication.data.dao.FavoriteDao
import shvyn22.holidaysapplication.util.Constants.BASE_URL
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Singleton
    @Provides
    fun provideRetrofit() : Retrofit = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    @Singleton
    @Provides
    fun provideApiInterface(retrofit: Retrofit) : ApiInterface =
        retrofit.create(ApiInterface::class.java)

    @Singleton
    @Provides
    fun provideDatabase(app: Application) : AppDatabase =
        Room.databaseBuilder(app, AppDatabase::class.java, "App database")
            .build()

    @Singleton
    @Provides
    fun provideFavoriteDao(db: AppDatabase) : FavoriteDao =
        db.favoriteDao()
}