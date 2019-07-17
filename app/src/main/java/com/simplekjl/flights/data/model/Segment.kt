package com.simplekjl.flights.data.model

import android.os.Parcel
import android.os.Parcelable
import com.google.gson.annotations.SerializedName


data class Segment(

    @SerializedName("Id")
    val id: String,
    @SerializedName("OriginStation")
    val originStation: Int,
    @SerializedName("DestinationStation")
    val destinationStation: Int,
    @SerializedName("DepartureDateTime")
    val departureDateTime: String,
    @SerializedName("ArrivalDateTime")
    val arrivalDateTime: String,
    @SerializedName("Carrier")
    val carriers: Int,
    @SerializedName("Duration")
    val duration: Int,
    @SerializedName("JourneyMode")
    val journeyMode: String,
    @SerializedName("OperatingCarrier")
    val operatingCarrier: Int,
    @SerializedName("Directionality")
    val directionality: String,
    @SerializedName("FlightNumber")
    val flightNumbers: String
) : Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readString() ?: "",
        parcel.readInt(),
        parcel.readInt(),
        parcel.readString() ?: "",
        parcel.readString() ?: "",
        parcel.readInt(),
        parcel.readInt(),
        parcel.readString() ?: "",
        parcel.readInt(),
        parcel.readString() ?: "",
        parcel.readString() ?: ""
    ) {
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(id)
        parcel.writeInt(originStation)
        parcel.writeInt(destinationStation)
        parcel.writeString(departureDateTime)
        parcel.writeString(arrivalDateTime)
        parcel.writeInt(carriers)
        parcel.writeInt(duration)
        parcel.writeString(journeyMode)
        parcel.writeInt(operatingCarrier)
        parcel.writeString(directionality)
        parcel.writeString(flightNumbers)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<Segment> {
        override fun createFromParcel(parcel: Parcel): Segment {
            return Segment(parcel)
        }

        override fun newArray(size: Int): Array<Segment?> {
            return arrayOfNulls(size)
        }
    }
}