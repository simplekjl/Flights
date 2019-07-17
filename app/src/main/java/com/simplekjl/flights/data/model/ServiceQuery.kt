package com.simplekjl.flights.data.model

import android.os.Parcel
import android.os.Parcelable
import com.google.gson.annotations.SerializedName


data class ServiceQuery(@SerializedName("DateTime") val dateTime: String) : Parcelable {
    constructor(parcel: Parcel) : this(parcel.readString() ?: "") {
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(dateTime)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<ServiceQuery> {
        override fun createFromParcel(parcel: Parcel): ServiceQuery {
            return ServiceQuery(parcel)
        }

        override fun newArray(size: Int): Array<ServiceQuery?> {
            return arrayOfNulls(size)
        }
    }
}