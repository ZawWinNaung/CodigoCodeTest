package com.example.codigocodetest_zwn.data

import com.example.codigocodetest_zwn.model.PopularMovieResponse
import com.example.codigocodetest_zwn.model.UpcomingMovieResponse
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Inject
import javax.inject.Singleton

//@Module
//@InstallIn(SingletonComponent::class)
class SharedRepository @Inject constructor() {


    suspend fun getPopularMovies(apiKey: String): PopularMovieResponse? {
        val request = NetworkLayer.apiClient.getPopularMovies(apiKey)
        if (request.failed || !request.isSuccessful) {
            return null
        }
        return request.body
    }


    suspend fun getUpcomingMovies(apiKey: String): UpcomingMovieResponse? {
        val request = NetworkLayer.apiClient.getUpcomingMovies(apiKey)
        if (request.failed || !request.isSuccessful) {
            return null
        }
        return request.body
    }
}