package com.mhmtn.moviearea.presentation.movie_favs.views

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.navigation.NavController
import com.mhmtn.moviearea.domain.model.Movie

val favMovieList : ArrayList<Movie> = ArrayList()

@Composable
fun MovieFavScreen(
     navController: NavController
) {


    Box(modifier = Modifier
        .fillMaxSize()
        .background(Color.White)){
        Column {
            LazyColumn(modifier = Modifier.fillMaxSize()){
                items(favMovieList){
                    MovieFavRow(movie = it)
                }

            }

        }

    }
}
