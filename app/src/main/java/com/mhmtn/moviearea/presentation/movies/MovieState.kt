package com.mhmtn.moviearea.presentation.movies

import com.mhmtn.moviearea.domain.model.Movie

data class MovieState (
    val isLoading : Boolean = false,
    var movies : List<Movie> = emptyList(),
    val error : String = "",
    val search : String = ""
)