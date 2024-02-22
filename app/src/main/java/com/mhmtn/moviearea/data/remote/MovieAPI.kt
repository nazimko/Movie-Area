package com.mhmtn.moviearea.data.remote

import com.mhmtn.moviearea.data.remote.DTO.MovieDetailDTO
import com.mhmtn.moviearea.data.remote.DTO.MoviesDTO
import com.mhmtn.moviearea.util.Constants.API_KEY
import retrofit2.http.GET
import retrofit2.http.Query

interface MovieAPI {

    @GET (".")
    suspend fun getMovies(
        @Query("s") searchString : String,
        @Query("apikey")  api : String = API_KEY
    ) : MoviesDTO


    @GET (".")
    suspend fun getMovieDetail(
        @Query("i") imdbId : String,
        @Query("apikey")  api : String = API_KEY
    ) : MovieDetailDTO


}