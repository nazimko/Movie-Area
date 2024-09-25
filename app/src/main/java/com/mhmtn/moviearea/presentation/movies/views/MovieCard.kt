package com.mhmtn.moviearea.presentation.movies.views

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.PlayArrow
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
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
import coil.compose.rememberAsyncImagePainter
import com.mhmtn.moviearea.domain.model.Movie

@Composable
fun MovieCard(
    movie: Movie,
    onItemClick: (Movie) -> Unit,
    onFavoriteClick: (Movie) -> Unit
) {

    Card(
        modifier = Modifier
            .height(220.dp)
            .clickable { onItemClick(movie) },
        shape = RoundedCornerShape(8.dp)
    ) {
        Column {
            Box(
                modifier = Modifier.weight(1f),
                contentAlignment = Center
            ) {
                Image(
                    painter = rememberAsyncImagePainter(model = movie.Poster),
                    contentDescription = movie.Title,
                    contentScale = ContentScale.Crop,
                    modifier = Modifier
                        .padding(16.dp)
                        .size(200.dp, 200.dp)
                        .clip(RectangleShape)
                )

                Surface(
                    color = Color.Black.copy(alpha = 0.5f),
                    modifier = Modifier.size(50.dp),
                    shape = CircleShape
                )
                {
                    Icon(
                        imageVector = Icons.Filled.PlayArrow,
                        contentDescription = "Play",
                        modifier = Modifier
                            .padding(12.dp)
                            .align(Center)
                            .size(40.dp),
                        tint = Color.White
                    )
                }
            }

            Column(modifier = Modifier.padding(10.dp).fillMaxWidth()) {
                Text(
                    text = movie.Title,
                    style = MaterialTheme.typography.titleLarge,
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis,
                    color = Color.Black,
                    fontWeight = FontWeight.Bold,
                    textAlign = TextAlign.Center
                )

                Spacer(modifier = Modifier.height(4.dp))


                Row (
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween){
                    Text(text = movie.Year,
                        style = MaterialTheme.typography.titleMedium,
                        overflow = TextOverflow.Ellipsis,
                        color = Color.Black,
                        textAlign = TextAlign.Start)

                    IconButton(
                        onClick = {
                            onFavoriteClick(movie)
                        }
                    ) {
                        Icon(
                            imageVector = Icons.Default.Favorite,
                            tint = if (movie.isFavorite) Color.Red else Color.Gray,
                            contentDescription = "Favorite"
                        )
                    }
                }
            }

        }
    }
}