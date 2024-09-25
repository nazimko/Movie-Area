package com.mhmtn.moviearea.data.di

import android.app.Application
import androidx.room.Room
import com.mhmtn.moviearea.data.db.MovieDAO
import com.mhmtn.moviearea.data.db.MovieDatabase
import com.mhmtn.moviearea.data.remote.MovieAPI
import com.mhmtn.moviearea.data.repo.MovieRepoImpl
import com.mhmtn.moviearea.domain.repo.MovieRepo
import com.mhmtn.moviearea.util.Constants.BASE_URL
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideMovieApi () : MovieAPI {
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create()
    }

    @Provides
    @Singleton
    fun provideMovieRepo(api: MovieAPI, db: MovieDatabase) : MovieRepo{
        return MovieRepoImpl (api = api, dao = db.dao)
    }

    @Provides
    @Singleton
    fun provideMovieDatabase (app:Application): MovieDatabase {
        return Room.databaseBuilder(
            app,
            MovieDatabase::class.java,
            "MovieDatabase"
        ).fallbackToDestructiveMigration()
            .build()
    }

    @Provides
    fun provideDao(database: MovieDatabase):MovieDAO{
        return database.dao
    }
}