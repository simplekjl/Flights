package com.simplekjl.flights.data.model

import com.google.gson.annotations.SerializedName

data class Carrier(
    @SerializedName("Id")
    val id: Int,
    @SerializedName("Code")
    val code: String,
    @SerializedName("Name")
    val name: String,
    @SerializedName("ImageUrl")
    val imageUrl: String,
    @SerializedName("DisplayCode")
    val displayCode: String
)