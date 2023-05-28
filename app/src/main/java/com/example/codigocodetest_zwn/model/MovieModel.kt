package com.example.codigocodetest_zwn.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.codigocodetest_zwn.utilities.Constants.Companion.FAVORITE_MOVIES
import java.io.Serializable

@Entity(tableName = FAVORITE_MOVIES)
data class MovieModel(
    val adult: Boolean,
    val backdrop_path: String,
    @PrimaryKey(autoGenerate = false) val id: Int,
    val original_language: String,
    val original_title: String,
    val overview: String,
    val popularity: Double,
    val poster_path: String,
    val release_date: String,
    val title: String,
    val video: Boolean,
    val vote_average: Double,
    val vote_count: Int
) : Serializable