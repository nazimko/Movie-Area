package com.mhmtn.moviearea.presentation.movies.views

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.focus.onFocusChanged
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.mhmtn.moviearea.presentation.movies.MoviesEvent
import com.mhmtn.moviearea.presentation.movies.MoviesViewModel

@Composable
fun MoviesScreen(
    navController: NavController,
    viewModel : MoviesViewModel = hiltViewModel()
) {

    val state = viewModel.state.value

    Box(modifier = Modifier
        .fillMaxSize()
        .background(Color.White)){
        Column {

            Row(verticalAlignment = Alignment.CenterVertically) {
                SearchBar(modifier = Modifier
                    .fillMaxWidth(0.9f)
                    .padding(20.dp),
                    hint = "Film Arayın",
                    onSearch = {
                        viewModel.onEvent(MoviesEvent.Search(it.trim()))
                    }
                )


               /* Icon(imageVector = Icons.Default.FavoriteBorder, contentDescription = null,
                    modifier = Modifier.background(Color.White)
                        .clickable {
                            navController.navigate("movie_fav_screen")
                        })

                */

                /*Image(
                    painter = painterResource(id = R.drawable.outline_star_white_48dp),
                    contentDescription = "Favorites",
                    Modifier.clickable {
                        navController.navigate("movie_fav_screen")
                    })

                 */

            }

            LazyVerticalGrid(columns = GridCells.Fixed(2),
                contentPadding = PaddingValues(16.dp),
                horizontalArrangement = Arrangement.spacedBy(16.dp),
                verticalArrangement = Arrangement.spacedBy(16.dp)
            ){
                items(state.movies){
                    MovieCard(movie = it, onItemClick = {
                        navController.navigate("movie_detail_screen/${it.imdbID}")
                    }
                    )
                }

            }
/*
            LazyColumn(modifier = Modifier.fillMaxSize()){
                items(state.movies){
                    MovieCard(movie = it, onItemClick = {
                        navController.navigate("movie_detail_screen/${it.imdbID}")
                        }
                    )
                }
            }

 */

        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SearchBar(modifier: Modifier, hint : String = "", onSearch: (String) -> Unit = {} ) {

    var text by remember {
        mutableStateOf("")
    }

    var isHintDisplayed by remember {
        mutableStateOf(hint != ""
        )
    }

    Box(modifier = modifier) {
        TextField(value = text , onValueChange = {
            text = it
        } ,
            keyboardActions = KeyboardActions(onDone ={
                onSearch(text)
            }),
            maxLines = 1,
            singleLine = true,
            textStyle = TextStyle(color = Color.Black),
            shape = RoundedCornerShape(12.dp),
            colors = TextFieldDefaults.textFieldColors(containerColor = Color.White),
            modifier = Modifier
                .fillMaxWidth()
                .shadow(5.dp, CircleShape)
                .background(Color.White, CircleShape)
                .padding(horizontal = 20.dp)
                .onFocusChanged {
                    isHintDisplayed = it.isFocused != true && text.isEmpty()

                }
        )

        if (isHintDisplayed){
            Text(text = hint,
                 color = Color.DarkGray,
                 modifier = Modifier.padding(horizontal = 20.dp, vertical = 12.dp))

        }
    }
}