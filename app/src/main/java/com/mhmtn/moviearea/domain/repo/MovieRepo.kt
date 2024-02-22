package com.mhmtn.moviearea.domain.repo

import com.mhmtn.moviearea.data.remote.DTO.MovieDetailDTO
import com.mhmtn.moviearea.data.remote.DTO.MoviesDTO

interface MovieRepo {

    suspend fun getMovies(search:String) : MoviesDTO
    suspend fun getMovieDetail(imdbId : String) : MovieDetailDTO
}