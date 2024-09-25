package com.mhmtn.moviearea.domain.use_case.get_movies

import com.mhmtn.moviearea.data.remote.DTO.toMovieList
import com.mhmtn.moviearea.domain.model.Movie
import com.mhmtn.moviearea.domain.repo.MovieRepo
import com.mhmtn.moviearea.util.Resource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOError
import javax.inject.Inject

class GetMovieUseCase @Inject constructor(
    private val repo: MovieRepo
) {

    fun executeGetoMovie(search: String): Flow<Resource<List<Movie>>> = flow {
        try {
            emit(Resource.Loading())
            val movieList = repo.getMovies(search)
            if (movieList.Response.equals("True")) {
                emit(Resource.Success(movieList.toMovieList()))
            } else if (movieList.Response.equals("False")) {
                emit(Resource.Error(message = "No movie found. :("))
            }


        } catch (e: IOError) {
            emit(Resource.Error("No Internet."))
        } catch (e: HttpException) {
            emit((Resource.Error(message = e.localizedMessage ?: "Error")))
        }
    }

}