package com.simplekjl.flights.data.model

import android.os.Parcel
import android.os.Parcelable
import com.google.gson.annotations.SerializedName

data class Itinerary(
    @SerializedName("OutboundLegId")
    val outboundLegId: String,
    @SerializedName("InboundLegId")
    val inboundLegId: String,
    @SerializedName("PricingOptions")
    val pricingOptions: List<PricingOptions>,
    @SerializedName("BookingDetailsLink")
    val bookingDetailsLink: BookingDetailsLink
) : Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readString() ?: "",
        parcel.readString() ?: "",
        arrayListOf<PricingOptions>().apply {
            parcel.readList(this as List<*>, PricingOptions::class.java.classLoader)
        },
        parcel.readParcelable<BookingDetailsLink>(BookingDetailsLink::class.java.classLoader) as BookingDetailsLink

    )

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(outboundLegId)
        parcel.writeString(inboundLegId)
        parcel.writeList(pricingOptions)
        parcel.writeParcelable(bookingDetailsLink, flags)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<Itinerary> {
        override fun createFromParcel(parcel: Parcel): Itinerary {
            return Itinerary(parcel)
        }

        override fun newArray(size: Int): Array<Itinerary?> {
            return arrayOfNulls(size)
        }
    }
}

