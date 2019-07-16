package com.simplekjl.flights.data.model

import com.google.gson.annotations.SerializedName


data class Leg(
    @SerializedName("Id")
    val id: String,
    @SerializedName("SegmentIds")
    val segmentIds: List<Int>,
    @SerializedName("OriginStation")
    val originStation: Int,
    @SerializedName("DestinationStation")
    val destinationStation: Int,
    @SerializedName("Departure")
    val departure: String,
    @SerializedName("Arrival")
    val arrival: String,
    @SerializedName("Duration")
    val duration: Int,
    @SerializedName("JourneyMode")
    val journeyMode: String,
    @SerializedName("Stops")
    val stops: List<Int>,
    @SerializedName("Carriers")
    val carriers: List<Int>,
    @SerializedName("OperatingCarriers")
    val operatingCarriers: List<Int>,
    @SerializedName("Directionality")
    val directionality: String,
    @SerializedName("FlightNumbers")
    val flightNumbers: List<FlightNumber>
)


