package com.example.codigocodetest_zwn.data

import com.example.codigocodetest_zwn.model.PopularMovieResponse

class SharedRepository {
    suspend fun getPopularMovies(apiKey: String): PopularMovieResponse? {
        val request = NetworkLayer.apiClient.getPopularMovies(apiKey)
        if (request.isSuccessful) {
            return request.body()!!
        }
        return null
    }
}