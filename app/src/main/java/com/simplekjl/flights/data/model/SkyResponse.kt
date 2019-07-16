package com.simplekjl.flights.data.model

import com.google.gson.annotations.SerializedName


data class SkyResponse(
    @SerializedName("SessionKey")
    val sessionKey: String,
    @SerializedName("Query")
    val query: Query,
    @SerializedName("Status")
    val status: String,
    @SerializedName("Itineraries")
    val itineraries: List<Itinerary>,
    @SerializedName("Legs")
    val legs: List<Leg>,
    @SerializedName("Segments")
    val segments: List<Segment>,
    @SerializedName("Carriers")
    val carriers: List<Carrier>,
    @SerializedName("Agents")
    val agents: List<Agent>,
    @SerializedName("Places")
    val plaes: List<Place>,
    @SerializedName("Currencies")
    val currencies: List<Currency>,
    @SerializedName("ServiceQuery")
    val dateTime: ServiceQuery

)