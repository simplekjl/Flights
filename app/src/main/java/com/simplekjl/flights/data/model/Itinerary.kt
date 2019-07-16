package com.simplekjl.flights.data.model

import com.google.gson.annotations.SerializedName

data class Itinerary(
    @SerializedName("OutboundLegId")
    val outboundLegId: String,
    @SerializedName("OutboundLegId")
    val inboundLegId: String,
    @SerializedName("PricingOptions")
    val pricingOptions: List<PricingOptions>,
    @SerializedName("BookingDetailsLink")
    val bookingDetailsLink: BookingDetailsLink
)

