package com.mhmtn.moviearea.presentation.movie_detail

import com.mhmtn.moviearea.domain.model.MovieDetail

data class MovieDetailState (
    val isLoading : Boolean = false,
    val movie : MovieDetail? = null,
    val error : String = "",
    var isFavorite : Boolean = false
)