package com.mhmtn.moviearea.presentation.movie_favs

sealed interface MovieFavEvent {

    object SaveMovie: MovieFavEvent


}