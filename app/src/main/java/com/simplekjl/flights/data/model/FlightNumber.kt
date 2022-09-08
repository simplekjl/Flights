package com.simplekjl.flights.data.model

import android.os.Parcel
import android.os.Parcelable
import com.google.gson.annotations.SerializedName


data class FlightNumber(
    @SerializedName("FlightNumber")
    val flightNumber: String,
    @SerializedName("CarrierId")
    val carrierId: Int
) : Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readString() ?: "",
        parcel.readInt()
    )

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(flightNumber)
        parcel.writeInt(carrierId)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<FlightNumber> {
        override fun createFromParcel(parcel: Parcel): FlightNumber {
            return FlightNumber(parcel)
        }

        override fun newArray(size: Int): Array<FlightNumber?> {
            return arrayOfNulls(size)
        }
    }
}