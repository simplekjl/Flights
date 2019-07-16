package com.simplekjl.flights.data.model

import com.google.gson.annotations.SerializedName


data class Currency(
    @SerializedName("Code")
    val code: String,
    @SerializedName("Symbol")
    val symbol: String,
    @SerializedName("ThousandsSeparator")
    val thousandsSeparator: String,
    @SerializedName("DecimalSeparator")
    val decimalSeparator: String,
    @SerializedName("SymbolOnLeft")
    val symbolOnLeft: Boolean,
    @SerializedName("SpaceBetweenAmountAndSymbol")
    val spaceBetweenAmountAndSymbol: Boolean,
    @SerializedName("RoundingCoefficient")
    val roundingCoefficient: Int,
    @SerializedName("DecimalDigits")
    val decimalDigits: Int
)