package com.example.codigocodetest_zwn.database

import androidx.annotation.WorkerThread
import androidx.lifecycle.MutableLiveData
import com.example.codigocodetest_zwn.model.MovieModel
import kotlinx.coroutines.flow.Flow

class FavoriteMovieRepository(private val movieDao: MovieDao) {
    val allFavoriteMovies: Flow<MutableLiveData<List<MovieModel>>> = movieDao.getAllFavoriteMovies()

    @Suppress("RedundantSuspendModifier")
    @WorkerThread
    suspend fun insert(movie: MovieModel) {
        movieDao.insert(movie)
    }

    @Suppress("RedundantSuspendModifier")
    @WorkerThread
    suspend fun delete(movie: MovieModel) {
        movieDao.delete(movie)
    }


}