package com.mhmtn.moviearea.data.cache

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Query
import androidx.room.Upsert
import com.mhmtn.moviearea.domain.model.Movie

@Dao
interface MovieDao {
/*
    @Upsert
    suspend fun upsertMovie(movie : Movie) :

    @Delete
    suspend fun deleteMovie (movie: Movie) :

 */
   // @Query ("SELECT *FROM movie ")
   // suspend fun getFavourites () : List<Movie>

}