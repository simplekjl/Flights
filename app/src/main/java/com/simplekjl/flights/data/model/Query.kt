package com.simplekjl.flights.data.model

import com.google.gson.annotations.SerializedName


data class Query(
    @SerializedName("Country")
    val country: String,
    @SerializedName("Currency")
    val Currency: String,
    @SerializedName("Locale")
    val locale: String,
    @SerializedName("Adults")
    val adults: Int,
    @SerializedName("Children")
    val children: Int,
    @SerializedName("Infants")
    val infants: Int,
    @SerializedName("OriginaPlace")
    val originPlace: String,
    @SerializedName("DestinationPlace")
    val destinationPlace: String,
    @SerializedName("OutboundDate")
    val outboundDate: String,
    @SerializedName("InboundDate")
    val inboundDate: String,
    @SerializedName("LocationSchema")
    val locationSchema: String,
    @SerializedName("CabinClass")
    val cabinClass: String,
    @SerializedName("GroupPricing")
    val groupPricing: Boolean
)