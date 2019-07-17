package com.simplekjl.flights.data.model

import android.os.Parcel
import android.os.Parcelable
import com.google.gson.annotations.SerializedName

data class Carrier(
    @SerializedName("Id")
    val id: Int,
    @SerializedName("Code")
    val code: String,
    @SerializedName("Name")
    val name: String,
    @SerializedName("ImageUrl")
    val imageUrl: String,
    @SerializedName("DisplayCode")
    val displayCode: String
) : Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readInt(),
        parcel.readString() ?: "",
        parcel.readString() ?: "",
        parcel.readString() ?: "",
        parcel.readString() ?: ""
    ) {
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeInt(id)
        parcel.writeString(code)
        parcel.writeString(name)
        parcel.writeString(imageUrl)
        parcel.writeString(displayCode)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<Carrier> {
        override fun createFromParcel(parcel: Parcel): Carrier {
            return Carrier(parcel)
        }

        override fun newArray(size: Int): Array<Carrier?> {
            return arrayOfNulls(size)
        }
    }
}