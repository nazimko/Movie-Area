package com.mhmtn.moviearea.presentation.movie_detail.views

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.Center
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import coil.compose.rememberAsyncImagePainter
import com.google.accompanist.systemuicontroller.rememberSystemUiController
import com.mhmtn.moviearea.presentation.movie_detail.MovieDetailViewModel

@Composable
fun MovieDetailScreen(
    movieDetailViewModel: MovieDetailViewModel = hiltViewModel()
) {

    val state = movieDetailViewModel.state.value

    val systemUiController = rememberSystemUiController()
    systemUiController.setSystemBarsColor(
        color = Color.White,
        darkIcons = true
    )

    Box(
        modifier = Modifier
            .background(Color.White)
            .fillMaxSize(),
        contentAlignment = Center
    ) {
        state.movie?.let {
            Column(
                modifier = Modifier.fillMaxSize(),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Image(
                    painter = rememberAsyncImagePainter(model = it.Poster),
                    contentDescription = it.Title,
                    contentScale = ContentScale.Crop,
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(320.dp)
                )

                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .weight(1f)
                        .padding(20.dp)
                ) {
                    Text(
                        text = it.Title,
                        fontSize = 38.sp,
                        textAlign = TextAlign.Center,
                        fontWeight = FontWeight.Bold,
                        modifier = Modifier.padding(12.dp),
                        color = Color.Black
                    )

                    Text(
                        text = it.Type,
                        textAlign = TextAlign.Center,
                        modifier = Modifier.padding(12.dp),
                        color = Color.Black
                    )

                    Text(
                        text = "Yıl : " + it.Year,
                        textAlign = TextAlign.Center,
                        modifier = Modifier.padding(12.dp),
                        color = Color.Black
                    )

                    Text(
                        text = "Tür : " + it.Genre,
                        textAlign = TextAlign.Center,
                        modifier = Modifier.padding(12.dp),
                        color = Color.Black
                    )

                    Text(
                        text = "Oyuncular : " + it.Actors,
                        modifier = Modifier.padding(12.dp),
                        color = Color.Black
                    )

                    Text(
                        text = "Yönetmen : " + it.Director,
                        textAlign = TextAlign.Center,
                        modifier = Modifier.padding(12.dp),
                        color = Color.Black
                    )

                    Text(
                        text = it.Country,
                        textAlign = TextAlign.Center,
                        modifier = Modifier.padding(12.dp),
                        color = Color.Black
                    )

                    Text(
                        text = it.imdbRating,
                        textAlign = TextAlign.Center,
                        modifier = Modifier.padding(12.dp),
                        color = Color.Black
                    )

                }
            }
            if (state.error.isNotBlank()) {
                Text(
                    text = state.error,
                    color = MaterialTheme.colorScheme.error,
                    textAlign = TextAlign.Center,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(14.dp)
                        .align(Center)
                )
            }

            if (state.isLoading) {
                CircularProgressIndicator(modifier = Modifier.align(Center))
            }
        }
    }
}