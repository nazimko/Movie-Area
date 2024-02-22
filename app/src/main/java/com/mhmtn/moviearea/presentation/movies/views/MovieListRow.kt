package com.mhmtn.moviearea.presentation.movies.views

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.material3.Checkbox
import androidx.compose.material3.CheckboxColors
import androidx.compose.material3.CheckboxDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconToggleButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.Center
import androidx.compose.ui.Alignment.Companion.CenterHorizontally
import androidx.compose.ui.Alignment.Companion.CenterVertically
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import coil.annotation.ExperimentalCoilApi
import coil.compose.rememberImagePainter
import com.mhmtn.moviearea.R
import com.mhmtn.moviearea.data.cache.MovieDatabase
import com.mhmtn.moviearea.domain.model.Movie
import com.mhmtn.moviearea.presentation.movie_favs.views.favMovieList
import com.mhmtn.moviearea.util.Constants
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch


@Composable
fun MovieListRow(
    movie : Movie,
    onItemClick : (Movie) -> Unit
    ) {

    val isFavorite = remember { mutableStateOf(false) }

    Row(modifier = Modifier
        .fillMaxWidth()
        .clickable {
            onItemClick(movie)
        }
        .padding(10.dp),
        horizontalArrangement = Arrangement.SpaceAround
    ) {
        Image(painter = rememberImagePainter(data = movie.Poster) ,
            contentDescription = movie.Title,
            modifier = Modifier
                .padding(16.dp)
                .size(200.dp, 200.dp)
                .clip(RectangleShape)
        )

        Column(modifier = Modifier.align(CenterVertically), horizontalAlignment = Alignment.CenterHorizontally) {
            Text(text = movie.Title,
                 style = MaterialTheme.typography.titleLarge,
                 overflow = TextOverflow.Ellipsis,
                 color = Color.Black,
                 textAlign = TextAlign.Center)

            Spacer(modifier = Modifier.padding(3.dp))

            Text(text = movie.Year,
                style = MaterialTheme.typography.titleMedium,
                overflow = TextOverflow.Ellipsis,
                color = Color.Black,
                textAlign = TextAlign.Center)

            Spacer(modifier = Modifier.padding(6.dp))

            Row (horizontalArrangement = Arrangement.Center,
                verticalAlignment = Alignment.CenterVertically){
                Text(text = "Favori: ",
                    style = MaterialTheme.typography.titleMedium,
                    color = Color.DarkGray,
                    textAlign = TextAlign.Start)

                IconToggleButton(
                    checked = isFavorite.value,
                    onCheckedChange = {isFavorite.value = it}
                ) {
                    Icon(imageVector = if (isFavorite.value) {
                        Icons.Filled.Favorite
                    }
                        else {
                             Icons.Default.FavoriteBorder
                             }, contentDescription = null )
                }

            }




            /*
            Icon(imageVector = if (isFavourite.value==false) {Icons.Default.FavoriteBorder}
                else {Icons.Default.Favorite} , contentDescription = null,
                modifier = Modifier
                    .padding(15.dp)
                    .clickable {
                        isFavourite.value = true
                        println("Clicked + ${movie.imdbID} ")
                    })

             */


            /*
            Image(
                painter = painterResource(id = R.drawable.outline_favorite_white_24),
                alignment = Alignment.BottomEnd,
                contentDescription = "Favorites",
                modifier = Modifier.clickable {
                    println("Clicked + ${movie.imdbID} ")
                    favMovieList.add(movie)
                }
            )

             */
        }
    }
}


