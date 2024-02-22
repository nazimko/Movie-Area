package com.mhmtn.moviearea.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.mhmtn.moviearea.presentation.movie_detail.views.MovieDetailScreen
import com.mhmtn.moviearea.presentation.movie_favs.views.MovieFavScreen
import com.mhmtn.moviearea.presentation.movies.views.MoviesScreen
import com.mhmtn.moviearea.presentation.theme.MovieAreaTheme
import com.mhmtn.moviearea.util.Constants.IMDB_ID
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MovieAreaTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = Color.White
                ) {
                    val navController = rememberNavController()
                    NavHost(navController = navController, startDestination = "movies_screen"){
                        composable(route = "movies_screen"){
                            MoviesScreen(navController = navController)

                        }
                        composable(route = "movie_detail_screen/{${IMDB_ID}}") {
                            MovieDetailScreen(navController = navController)
                        }


                        composable("movie_fav_screen"){
                            MovieFavScreen(navController = navController)
                        }
                    }

                }
            }
        }
    }
}

