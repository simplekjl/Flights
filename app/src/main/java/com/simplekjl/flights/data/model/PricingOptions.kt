package com.simplekjl.flights.data.model

import android.os.Parcel
import android.os.Parcelable
import com.google.gson.annotations.SerializedName


data class PricingOptions(

    @SerializedName("Agents")
    val agents: List<Int>,
    @SerializedName("QuoteAgeInMinutes")
    val quoteAgeInMinutes: Int,
    @SerializedName("Price")
    val price: Float,
    @SerializedName("DeeplinkUrl")
    val deeplinkUrl: String

) : Parcelable {
    constructor(parcel: Parcel) : this(
        arrayListOf<Int>().apply {
            parcel.readList(this as List<*>, null)
        },
        parcel.readInt(),
        parcel.readFloat(),
        parcel.readString() ?: ""
    )

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeInt(quoteAgeInMinutes)
        parcel.writeFloat(price)
        parcel.writeString(deeplinkUrl)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<PricingOptions> {
        override fun createFromParcel(parcel: Parcel): PricingOptions {
            return PricingOptions(parcel)
        }

        override fun newArray(size: Int): Array<PricingOptions?> {
            return arrayOfNulls(size)
        }
    }
}