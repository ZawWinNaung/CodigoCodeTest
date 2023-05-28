package com.example.codigocodetest_zwn.data.api

import com.example.codigocodetest_zwn.model.PopularMovieResponse
import com.example.codigocodetest_zwn.utilities.Constants.Companion.BASE_URL
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query

interface RetrofitService {
//    companion object {
//        var retrofitService: RetrofitService? = null
//        fun getInstance(): RetrofitService {
//            if (retrofitService == null) {
//                val retrofit = Retrofit.Builder().baseUrl(BASE_URL)
//                    .addConverterFactory(GsonConverterFactory.create()).build()
//                retrofitService = retrofit.create(RetrofitService::class.java)
//            }
//            return retrofitService!!
//        }
//    }

    @GET("movie/popular")
    suspend fun getPopularMovies(@Query("api_key") apiKey: String): Response<PopularMovieResponse>
}