package com.mhmtn.moviearea.domain.repo

import com.mhmtn.moviearea.data.remote.DTO.MovieDetailDTO
import com.mhmtn.moviearea.data.remote.DTO.MoviesDTO
import com.mhmtn.moviearea.domain.model.Movie
import kotlinx.coroutines.flow.Flow

interface MovieRepo {

    suspend fun getMovies(search:String) : MoviesDTO
    suspend fun getMovieDetail(imdbId : String) : MovieDetailDTO

    suspend fun insert(movie: Movie)

    suspend fun delete(movie: Movie)

    fun getAllMovies(): Flow<List<Movie>>

    fun getFavoriteMovies(movieIds: List<String>): Flow<List<String>>
}