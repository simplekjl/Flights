package com.simplekjl.flights.data.model

import com.google.gson.annotations.SerializedName


data class Segment(

    @SerializedName("Id")
    val id: String,
    @SerializedName("OriginStation")
    val originStation: Int,
    @SerializedName("DestinationStation")
    val destinationStation: Int,
    @SerializedName("DepartureDateTime")
    val departureDateTime: String,
    @SerializedName("ArrivalDateTime")
    val arrivalDateTime: String,
    @SerializedName("Carrier")
    val carriers: Int,
    @SerializedName("Duration")
    val duration: Int,
    @SerializedName("JourneyMode")
    val journeyMode: String,
    @SerializedName("OperatingCarrier")
    val operatingCarrier: Int,
    @SerializedName("Directionality")
    val directionality: String,
    @SerializedName("FlightNumber")
    val flightNumbers: String
)