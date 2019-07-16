package com.simplekjl.flights.data.model

import com.google.gson.annotations.SerializedName


data class BookingDetailsLink(
    @SerializedName("Uri")
    val uri: String,
    @SerializedName("Body")
    val body: String,
    @SerializedName("Method")
    val method: String

)