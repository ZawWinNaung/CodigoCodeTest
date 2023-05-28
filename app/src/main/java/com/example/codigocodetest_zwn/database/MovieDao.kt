package com.example.codigocodetest_zwn.database

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import com.example.codigocodetest_zwn.model.MovieModel
import com.example.codigocodetest_zwn.utilities.Constants.Companion.FAVORITE_MOVIES
import kotlinx.coroutines.flow.Flow

@Dao
interface MovieDao {
    @Insert
    fun insert(movie: MovieModel)

    @Delete
    fun delete(movie: MovieModel)

//    @Query("delete from $FAVORITE_MOVIES where id = :movieId")
//    fun delete(movieId: Int)

    @Query("select * from $FAVORITE_MOVIES")
    fun getAllFavoriteMovies(): Flow<MutableList<MovieModel>>
}