package com.example.codigocodetest_zwn.data

import com.example.codigocodetest_zwn.data.api.RetrofitService
import com.example.codigocodetest_zwn.model.PopularMovieResponse
import retrofit2.Response

class ApiClient(private val retrofitService: RetrofitService) {
    suspend fun getPopularMovies(apiKey: String): Response<PopularMovieResponse> {
        return retrofitService.getPopularMovies(apiKey)
    }
}