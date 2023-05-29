package com.example.codigocodetest_zwn.data.api

import com.example.codigocodetest_zwn.model.PopularMovieResponse
import com.example.codigocodetest_zwn.model.UpcomingMovieResponse
import com.example.codigocodetest_zwn.utilities.Constants.Companion.BASE_URL
import dagger.Module
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query

interface RetrofitService {
    @GET("movie/popular")
    suspend fun getPopularMovies(@Query("api_key") apiKey: String): Response<PopularMovieResponse>

    @GET("movie/upcoming")
    suspend fun getUpcomingMovies(@Query("api_key") apiKey: String): Response<UpcomingMovieResponse>
}