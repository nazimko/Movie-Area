package com.mhmtn.moviearea.presentation.fav_movies

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.mhmtn.moviearea.data.repo.MovieRepoImpl
import com.mhmtn.moviearea.domain.model.Movie
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MovieFavViewModel @Inject constructor(
    private val repoImpl: MovieRepoImpl
) : ViewModel(){

    private val _movie = MutableStateFlow(emptyList<Movie>())
    val movie = _movie.asStateFlow()


    init {
        getFavMovies()
    }

    private fun getFavMovies(){
        viewModelScope.launch {
            repoImpl.getAllMovies().collect {
                _movie.tryEmit(it)
            }
        }
    }

    fun deleteFavMovies(movie: Movie){
        viewModelScope.launch {
            repoImpl.delete(movie)
        }
    }
}