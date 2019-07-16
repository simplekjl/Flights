package com.simplekjl.flights.data.model

import com.google.gson.annotations.SerializedName

data class Agent(
    @SerializedName("Id")
    val id: Int,
    @SerializedName("Name")
    val name: String,
    @SerializedName("ImageUrl")
    val imageUrl: String,
    @SerializedName("Status")
    val status: String,
    @SerializedName("OptimisedForMobile")
    val optimizedForMobile: Boolean,
    @SerializedName("Type")
    val type: String

)