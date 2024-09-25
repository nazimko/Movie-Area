package com.mhmtn.moviearea.domain.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "movie")
data class Movie(
    @ColumnInfo(name = "image" )
    val Poster: String,
    @ColumnInfo(name = "name" )
    val Title: String,
    @ColumnInfo(name = "year" )
    val Year: String,
    @PrimaryKey
    @ColumnInfo(name = "id" )
    val imdbID: String,
    @ColumnInfo(name = "isFavorite")
    var isFavorite : Boolean = false
)
