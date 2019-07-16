package com.simplekjl.flights.data.model

import com.google.gson.annotations.SerializedName


data class PricingOptions(

    @SerializedName("Agents")
    val agents: List<Int>,
    @SerializedName("QuoteAgeInMinutes")
    val quoteAgeInMinutes: Int,
    @SerializedName("Price")
    val price: Float,
    @SerializedName("DeeplinkUrl")
    val deeplinkUrl: String

)