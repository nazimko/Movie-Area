package com.mhmtn.moviearea.data.repo

import com.mhmtn.moviearea.data.remote.DTO.MovieDetailDTO
import com.mhmtn.moviearea.data.remote.DTO.MoviesDTO
import com.mhmtn.moviearea.data.remote.MovieAPI
import com.mhmtn.moviearea.domain.repo.MovieRepo
import javax.inject.Inject

class MovieRepoImpl @Inject constructor(private val api: MovieAPI) : MovieRepo {
    override suspend fun getMovies(search: String): MoviesDTO {
        return api.getMovies(searchString = search)
    }

    override suspend fun getMovieDetail(imdbId: String): MovieDetailDTO {
        return api.getMovieDetail(imdbId = imdbId)
    }
}