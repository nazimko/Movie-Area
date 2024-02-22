package com.mhmtn.moviearea.data.cache

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.mhmtn.moviearea.domain.model.Movie

@Database(entities = [Movie::class], version = 1)
abstract class MovieDatabase : RoomDatabase() {

    abstract fun dao(): MovieDao

    companion object{

        @Volatile private var instance : MovieDatabase? = null

        private val lock = Any()

        operator fun invoke(context: Context) = instance ?: synchronized(lock) {
            instance ?: DatabaseBuild(context).also {
                instance = it
            }
        }

        private fun DatabaseBuild (context : Context) = Room.databaseBuilder(
            context.applicationContext,MovieDatabase::class.java,"moviedatabase"
        ).build()
    }
}