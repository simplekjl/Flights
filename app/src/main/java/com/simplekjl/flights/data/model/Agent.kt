package com.simplekjl.flights.data.model

import android.os.Parcel
import android.os.Parcelable
import com.google.gson.annotations.SerializedName

data class Agent(
    @SerializedName("Id")
    val id: Int,
    @SerializedName("Name")
    val name: String,
    @SerializedName("ImageUrl")
    val imageUrl: String,
    @SerializedName("Status")
    val status: String,
    @SerializedName("OptimisedForMobile")
    val optimizedForMobile: Boolean,
    @SerializedName("Type")
    val type: String

) : Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readInt(),
        parcel.readString() ?: "",
        parcel.readString() ?: "",
        parcel.readString() ?: "",
        parcel.readByte() != 0.toByte(),
        parcel.readString() ?: ""
    )

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeInt(id)
        parcel.writeString(name)
        parcel.writeString(imageUrl)
        parcel.writeString(status)
        parcel.writeByte(if (optimizedForMobile) 1 else 0)
        parcel.writeString(type)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<Agent> {
        override fun createFromParcel(parcel: Parcel): Agent {
            return Agent(parcel)
        }

        override fun newArray(size: Int): Array<Agent?> {
            return arrayOfNulls(size)
        }
    }

}