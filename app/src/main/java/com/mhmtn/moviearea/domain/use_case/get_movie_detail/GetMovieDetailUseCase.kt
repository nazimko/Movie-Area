package com.mhmtn.moviearea.domain.use_case.get_movie_detail

import com.mhmtn.moviearea.data.remote.DTO.toMovieDetail
import com.mhmtn.moviearea.data.remote.DTO.toMovieList
import com.mhmtn.moviearea.domain.model.Movie
import com.mhmtn.moviearea.domain.model.MovieDetail
import com.mhmtn.moviearea.domain.repo.MovieRepo
import com.mhmtn.moviearea.util.Resource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOError
import javax.inject.Inject

class GetMovieDetailUseCase @Inject constructor(private val repo : MovieRepo) {

    fun executeGetoMovieDetail(imdbId : String): Flow<Resource<MovieDetail>> = flow {
        try {
            emit(Resource.Loading())
            val movieDetail = repo.getMovieDetail(imdbId)
            emit(Resource.Success(movieDetail.toMovieDetail()))
        }catch (e: IOError) {
            emit(Resource.Error("No Internet."))
        }
        catch (e: HttpException) {
            emit((Resource.Error(message = e.localizedMessage ?: "Eror")))
        }
    }

}
