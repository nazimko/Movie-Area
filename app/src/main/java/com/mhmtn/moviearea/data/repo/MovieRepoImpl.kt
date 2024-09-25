package com.mhmtn.moviearea.data.repo

import com.mhmtn.moviearea.data.db.MovieDAO
import com.mhmtn.moviearea.data.remote.DTO.MovieDetailDTO
import com.mhmtn.moviearea.data.remote.DTO.MoviesDTO
import com.mhmtn.moviearea.data.remote.MovieAPI
import com.mhmtn.moviearea.domain.model.Movie
import com.mhmtn.moviearea.domain.repo.MovieRepo
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class MovieRepoImpl @Inject constructor(
    private val api: MovieAPI,
    private val dao: MovieDAO
) : MovieRepo {
    override suspend fun getMovies(search: String): MoviesDTO {
        return api.getMovies(searchString = search)
    }

    override suspend fun getMovieDetail(imdbId: String): MovieDetailDTO {
        return api.getMovieDetail(imdbId = imdbId)
    }

    override suspend fun insert(movie: Movie) {
            dao.insert(movie)
    }

    override suspend fun delete(movie: Movie) {
            dao.delete(movie)
    }

    override fun getAllMovies(): Flow<List<Movie>> {
        return dao.getAllMovies()
    }

    override fun getFavoriteMovies(movieIds: List<String>): Flow<List<String>> {
        return dao.getFavoriteMovies(movieIds)
    }

}