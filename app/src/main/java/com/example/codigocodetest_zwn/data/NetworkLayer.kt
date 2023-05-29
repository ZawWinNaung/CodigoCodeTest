package com.example.codigocodetest_zwn.data

import com.example.codigocodetest_zwn.utilities.Constants.Companion.BASE_URL
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

object NetworkLayer {

    val moshi: Moshi = Moshi.Builder().add(KotlinJsonAdapterFactory()).build()
    val retrofit: Retrofit = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(MoshiConverterFactory.create(moshi))
        .build()

//    private val retrofitService: RetrofitService by lazy {
//        retrofit.create(RetrofitService::class.java)
//    }


    val apiClient = ApiClient()
}