package com.simplekjl.flights.data.model

import com.google.gson.annotations.SerializedName


data class FlightNumber(
    @SerializedName("FlightNumber")
    val flightNumber: String,
    @SerializedName("CarrierId")
    val carrierId: Int
)