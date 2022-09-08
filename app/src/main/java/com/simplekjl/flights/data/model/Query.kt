package com.simplekjl.flights.data.model

import android.os.Parcel
import android.os.Parcelable
import com.google.gson.annotations.SerializedName


data class Query(
    @SerializedName("Country")
    val country: String,
    @SerializedName("Currency")
    val Currency: String,
    @SerializedName("Locale")
    val locale: String,
    @SerializedName("Adults")
    val adults: Int,
    @SerializedName("Children")
    val children: Int,
    @SerializedName("Infants")
    val infants: Int,
    @SerializedName("OriginaPlace")
    val originPlace: String,
    @SerializedName("DestinationPlace")
    val destinationPlace: String,
    @SerializedName("OutboundDate")
    val outboundDate: String,
    @SerializedName("InboundDate")
    val inboundDate: String,
    @SerializedName("LocationSchema")
    val locationSchema: String,
    @SerializedName("CabinClass")
    val cabinClass: String,
    @SerializedName("GroupPricing")
    val groupPricing: Boolean
) : Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readString() ?: "",
        parcel.readString() ?: "",
        parcel.readString() ?: "",
        parcel.readInt(),
        parcel.readInt(),
        parcel.readInt(),
        parcel.readString() ?: "",
        parcel.readString() ?: "",
        parcel.readString() ?: "",
        parcel.readString() ?: "",
        parcel.readString() ?: "",
        parcel.readString() ?: "",
        parcel.readByte() != 0.toByte()
    ) {
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(country)
        parcel.writeString(Currency)
        parcel.writeString(locale)
        parcel.writeInt(adults)
        parcel.writeInt(children)
        parcel.writeInt(infants)
        parcel.writeString(originPlace)
        parcel.writeString(destinationPlace)
        parcel.writeString(outboundDate)
        parcel.writeString(inboundDate)
        parcel.writeString(locationSchema)
        parcel.writeString(cabinClass)
        parcel.writeByte(if (groupPricing) 1 else 0)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<Query> {
        override fun createFromParcel(parcel: Parcel): Query {
            return Query(parcel)
        }

        override fun newArray(size: Int): Array<Query?> {
            return arrayOfNulls(size)
        }
    }
}