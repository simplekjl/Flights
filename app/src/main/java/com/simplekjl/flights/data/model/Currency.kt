package com.simplekjl.flights.data.model

import android.os.Parcel
import android.os.Parcelable
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
) : Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readString() ?: "",
        parcel.readString() ?: "",
        parcel.readString() ?: "",
        parcel.readString() ?: "",
        parcel.readByte() != 0.toByte(),
        parcel.readByte() != 0.toByte(),
        parcel.readInt(),
        parcel.readInt()
    )

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(code)
        parcel.writeString(symbol)
        parcel.writeString(thousandsSeparator)
        parcel.writeString(decimalSeparator)
        parcel.writeByte(if (symbolOnLeft) 1 else 0)
        parcel.writeByte(if (spaceBetweenAmountAndSymbol) 1 else 0)
        parcel.writeInt(roundingCoefficient)
        parcel.writeInt(decimalDigits)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<Currency> {
        override fun createFromParcel(parcel: Parcel): Currency {
            return Currency(parcel)
        }

        override fun newArray(size: Int): Array<Currency?> {
            return arrayOfNulls(size)
        }
    }
}