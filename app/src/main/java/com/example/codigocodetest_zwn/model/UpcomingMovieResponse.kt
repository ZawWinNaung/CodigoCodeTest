package com.example.codigocodetest_zwn.model

data class UpcomingMovieResponse(
    val dates: Dates,
    val page: Int,
    val results: List<MovieModel>,
    val total_pages: Int,
    val total_results: Int
)