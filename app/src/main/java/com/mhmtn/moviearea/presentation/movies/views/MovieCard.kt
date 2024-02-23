package com.mhmtn.moviearea.presentation.movies.views

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.PlayArrow
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment.Companion.Center
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import coil.compose.rememberImagePainter
import com.mhmtn.moviearea.domain.model.Movie


@Composable
fun MovieCard(
    movie : Movie,
    onItemClick : (Movie) -> Unit
    ) {

    Card (modifier = Modifier
        .height(220.dp)
        .clickable { onItemClick(movie) },
        shape = RoundedCornerShape(8.dp)
    ) {
        Column {
            Box(modifier = Modifier.weight(1f),
                contentAlignment = Center){
                Image(painter = rememberImagePainter(data = movie.Poster) ,
                    contentDescription = movie.Title,
                    contentScale = ContentScale.Crop,
                    modifier = Modifier
                        .padding(16.dp)
                        .size(200.dp, 200.dp)
                        .clip(RectangleShape)
                )

                Surface (color = Color.Black.copy(alpha = 0.5f),
                    modifier = Modifier.size(50.dp),
                    shape = CircleShape)
                {
                    Icon(imageVector = Icons.Filled.PlayArrow,
                        contentDescription = "Play",
                        modifier = Modifier
                            .padding(12.dp)
                            .align(Center)
                            .size(40.dp),
                        tint = Color.White)
                }
            }

            Column (modifier = Modifier.padding(10.dp)) {
                Text(text = movie.Title,
                    style = MaterialTheme.typography.titleLarge,
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis,
                    color = Color.Black,
                    fontWeight = FontWeight.Bold,
                    textAlign = TextAlign.Center)

                Spacer(modifier = Modifier.height(4.dp))

                Text(text = movie.Year,
                    style = MaterialTheme.typography.titleMedium,
                    overflow = TextOverflow.Ellipsis,
                    color = Color.Black,
                    textAlign = TextAlign.Center)

            }

        }
    }
}

    /*Row(modifier = Modifier
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



     */


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




