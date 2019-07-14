package com.simplekjl.flights.data.model


data class Itinerary(
    val poster_path: String?,
    val popularity: Float,
    val id: Int,
    val backdrop_path: String,
    val vote_average: Float,
    val overview: String,
    val first_air_date: String,
    val name: String
)