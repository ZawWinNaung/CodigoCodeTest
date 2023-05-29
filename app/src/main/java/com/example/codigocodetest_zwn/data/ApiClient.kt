package com.example.codigocodetest_zwn.data

import com.example.codigocodetest_zwn.data.api.RetrofitService
import com.example.codigocodetest_zwn.model.PopularMovieResponse
import com.example.codigocodetest_zwn.model.UpcomingMovieResponse
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Response
import java.lang.Exception
import javax.inject.Inject
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class ApiClient() {

    private val retrofitService: RetrofitService by lazy {
        NetworkLayer.retrofit.create(RetrofitService::class.java)
    }


    @Provides
    suspend fun getPopularMovies(apiKey: String): ApiResponse<PopularMovieResponse> {
        return safeApiCall { retrofitService.getPopularMovies(apiKey) }
    }


    @Provides
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