package com.simplekjl.flights.data.model

import android.os.Parcel
import android.os.Parcelable
import com.google.gson.annotations.SerializedName


data class Leg(
    @SerializedName("Id")
    val id: String,
    @SerializedName("SegmentIds")
    val segmentIds: List<Int>,
    @SerializedName("OriginStation")
    val originStation: Int,
    @SerializedName("DestinationStation")
    val destinationStation: Int,
    @SerializedName("Departure")
    val departure: String,
    @SerializedName("Arrival")
    val arrival: String,
    @SerializedName("Duration")
    val duration: Int,
    @SerializedName("JourneyMode")
    val journeyMode: String,
    @SerializedName("Stops")
    val stops: List<Int>,
    @SerializedName("Carriers")
    val carriers: List<Int>,
    @SerializedName("OperatingCarriers")
    val operatingCarriers: List<Int>,
    @SerializedName("Directionality")
    val directionality: String,
    @SerializedName("FlightNumbers")
    val flightNumbers: List<FlightNumber>
) : Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readString() ?: "",
        arrayListOf<Int>().apply { parcel.readList(this as List<*>, null) },
        parcel.readInt(),
        parcel.readInt(),
        parcel.readString() ?: "",
        parcel.readString() ?: "",
        parcel.readInt(),
        parcel.readString() ?: "",
        arrayListOf<Int>().apply { parcel.readList(this as List<*>, null) },
        arrayListOf<Int>().apply { parcel.readList(this as List<*>, null) },
        arrayListOf<Int>().apply { parcel.readList(this as List<*>, null) },
        parcel.readString() ?: "",
        arrayListOf<FlightNumber>().apply {
            parcel.readList(this as List<*>, FlightNumber::class.java.classLoader)
        }
    )

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(id)
        parcel.writeInt(originStation)
        parcel.writeInt(destinationStation)
        parcel.writeString(departure)
        parcel.writeString(arrival)
        parcel.writeInt(duration)
        parcel.writeString(journeyMode)
        parcel.writeString(directionality)
        parcel.writeList(flightNumbers)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<Leg> {
        override fun createFromParcel(parcel: Parcel): Leg {
            return Leg(parcel)
        }

        override fun newArray(size: Int): Array<Leg?> {
            return arrayOfNulls(size)
        }
    }
}


