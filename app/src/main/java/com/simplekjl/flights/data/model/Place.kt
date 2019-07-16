package com.simplekjl.flights.data.model

import com.google.gson.annotations.SerializedName


data class Place(
    @SerializedName("Id")
    val id: Int,
    @SerializedName("ParentId")
    val parentId: Int,
    @SerializedName("Code")
    val code: String,
    @SerializedName("Type")
    val type: String,
    @SerializedName("Name")
    val name: String
)