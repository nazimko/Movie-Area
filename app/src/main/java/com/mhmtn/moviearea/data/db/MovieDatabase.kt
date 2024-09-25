package com.mhmtn.moviearea.data.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.mhmtn.moviearea.domain.model.Movie

@Database(entities = [Movie::class], version = 9)
abstract class MovieDatabase : RoomDatabase(){
    abstract val dao: MovieDAO
}