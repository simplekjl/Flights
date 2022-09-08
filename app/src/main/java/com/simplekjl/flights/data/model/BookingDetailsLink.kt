package com.simplekjl.flights.data.model

import android.os.Parcel
import android.os.Parcelable
import com.google.gson.annotations.SerializedName


data class BookingDetailsLink(
    @SerializedName("Uri")
    val uri: String,
    @SerializedName("Body")
    val body: String,
    @SerializedName("Method")
    val method: String

) : Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readString() ?: "",
        parcel.readString() ?: "",
        parcel.readString() ?: ""
    ) {
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(uri)
        parcel.writeString(body)
        parcel.writeString(method)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<BookingDetailsLink> {
        override fun createFromParcel(parcel: Parcel): BookingDetailsLink {
            return BookingDetailsLink(parcel)
        }

        override fun newArray(size: Int): Array<BookingDetailsLink?> {
            return arrayOfNulls(size)
        }
    }
}