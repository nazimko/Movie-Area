package com.mhmtn.moviearea.data.di

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
    fun provideMovieRepo(api: MovieAPI) : MovieRepo{
        return MovieRepoImpl (api = api)
    }
}