package com.example.codigocodetest_zwn.data

import com.example.codigocodetest_zwn.data.api.RetrofitService
import com.example.codigocodetest_zwn.model.PopularMovieResponse
import com.example.codigocodetest_zwn.model.UpcomingMovieResponse
import retrofit2.Response

class ApiClient(private val retrofitService: RetrofitService) {
    suspend fun getPopularMovies(apiKey: String): Response<PopularMovieResponse> {
        return retrofitService.getPopularMovies(apiKey)
    }

    suspend fun getUpcomingMovies(apiKey: String): Response<UpcomingMovieResponse> {
        return retrofitService.getUpcomingMovies(apiKey)
    }
}