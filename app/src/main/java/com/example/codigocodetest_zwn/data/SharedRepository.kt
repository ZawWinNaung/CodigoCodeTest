package com.example.codigocodetest_zwn.data

import com.example.codigocodetest_zwn.model.PopularMovieResponse
import com.example.codigocodetest_zwn.model.UpcomingMovieResponse

class SharedRepository {
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