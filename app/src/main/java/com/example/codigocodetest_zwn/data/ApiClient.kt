package com.example.codigocodetest_zwn.data

import com.example.codigocodetest_zwn.data.api.RetrofitService
import com.example.codigocodetest_zwn.model.PopularMovieResponse
import com.example.codigocodetest_zwn.model.UpcomingMovieResponse
import retrofit2.Response
import java.lang.Exception

class ApiClient(private val retrofitService: RetrofitService) {
    suspend fun getPopularMovies(apiKey: String): ApiResponse<PopularMovieResponse> {
        return safeApiCall { retrofitService.getPopularMovies(apiKey) }
    }

    suspend fun getUpcomingMovies(apiKey: String): ApiResponse<UpcomingMovieResponse> {
        return safeApiCall { retrofitService.getUpcomingMovies(apiKey) }
    }

    private inline fun <T> safeApiCall(apiCall: () -> Response<T>): ApiResponse<T> {
        return try {
            ApiResponse.success(apiCall.invoke())
        } catch (e: Exception) {
            ApiResponse.failure(e)
        }
    }
}