package com.mhmtn.moviearea.presentation.fav_movies

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.mhmtn.moviearea.presentation.movies.views.MovieCard

@SuppressLint("StateFlowValueCalledInComposition")
@Composable
fun MovieFavScreen(
    navController: NavController,
    viewModel: MovieFavViewModel = hiltViewModel()
) {

    val state = viewModel.movie.collectAsState()

    LazyVerticalGrid(
        columns = GridCells.Fixed(2),
        contentPadding = PaddingValues(16.dp),
        horizontalArrangement = Arrangement.spacedBy(16.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        items(state.value) {
            MovieCard(
                movie = it.copy(isFavorite = true),
                onItemClick = {
                    navController.navigate("movie_detail_screen/${it.imdbID}")
                },
                onFavoriteClick = {
                    viewModel.deleteFavMovies(it)
                }
            )
        }
    }
}
