package com.mhmtn.moviearea.data.db

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.mhmtn.moviearea.domain.model.Movie
import kotlinx.coroutines.flow.Flow

@Dao
interface MovieDAO {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(movie: Movie)

    @Delete
    suspend fun delete(movie: Movie)

    @Query("SELECT * FROM movie")
    fun getAllMovies(): Flow<List<Movie>>

    @Query("SELECT id FROM movie WHERE id IN (:movieIds)")
    fun getFavoriteMovies(movieIds: List<String>): Flow<List<String>>
}