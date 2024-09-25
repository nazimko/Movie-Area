package com.mhmtn.moviearea.presentation.movies

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.mhmtn.moviearea.data.repo.MovieRepoImpl
import com.mhmtn.moviearea.domain.model.Movie
import com.mhmtn.moviearea.domain.use_case.get_movies.GetMovieUseCase
import com.mhmtn.moviearea.util.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MoviesViewModel @Inject constructor(
    private val getMovieUseCase : GetMovieUseCase,
    private val repoImpl: MovieRepoImpl
) : ViewModel() {

    private val _state = mutableStateOf(MovieState())
    val state : State<MovieState> = _state

    private fun getMovies(search : String) {
        getMovieUseCase.executeGetoMovie(search = search).onEach {result->
            when(result) {
                is Resource.Success -> {
                    val movieIds = result.data!!.map { it.imdbID }

                    repoImpl.getFavoriteMovies(movieIds).collect{
                        val updatedMovies = result.data.map {movie->
                            movie.copy(isFavorite = it.contains(movie.imdbID))
                        }
                        _state.value = MovieState(
                            movies = updatedMovies
                        )
                    }
                }

                is Resource.Error -> {
                    _state.value= MovieState(error = result.message ?: "Error.")
                }

                is Resource.Loading -> {
                    _state.value = MovieState(isLoading = true)
                }
            }
        }.launchIn(viewModelScope)
    }

    fun onFavoriteClick(movie: Movie) {
        viewModelScope.launch {
            if (movie.isFavorite) {
                repoImpl.delete(movie)
            } else {
                repoImpl.insert(movie)
            }
            _state.value.movies = _state.value.movies.map {
                if (it.imdbID == movie.imdbID) it.copy(isFavorite = movie.isFavorite) else it
            }
        }
    }

    fun onEvent (event: MoviesEvent){
        when(event) {
            is MoviesEvent.Search -> {
                getMovies(event.searchString)
            }
        }
    }
}