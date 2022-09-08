package com.simplekjl.flights.data.model

import android.os.Parcel
import android.os.Parcelable
import com.google.gson.annotations.SerializedName


data class SkyResponse(
    @SerializedName("SessionKey")
    val sessionKey: String,
    @SerializedName("Query")
    val query: Query,
    @SerializedName("Status")
    val status: String,
    @SerializedName("Itineraries")
    val itineraries: ArrayList<Itinerary>,
    @SerializedName("Legs")
    val legs: ArrayList<Leg>,
    @SerializedName("Segments")
    val segments: ArrayList<Segment>,
    @SerializedName("Carriers")
    val carriers: ArrayList<Carrier>,
    @SerializedName("Agents")
    val agents: ArrayList<Agent>,
    @SerializedName("Places")
    val places: ArrayList<Place>,
    @SerializedName("Currencies")
    val currencies: ArrayList<Currency>,
    @SerializedName("ServiceQuery")
    val dateTime: ServiceQuery

) : Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readString() ?: "",
        parcel.readParcelable<Query>(Query::class.java.classLoader) as Query,
        parcel.readString() ?: "",
        parcel.createTypedArrayList(Itinerary) ?: arrayListOf<Itinerary>(),
        parcel.createTypedArrayList(Leg) ?: arrayListOf<Leg>(),
        parcel.createTypedArrayList(Segment) ?: arrayListOf<Segment>(),
        parcel.createTypedArrayList(Carrier) ?: arrayListOf<Carrier>(),
        parcel.createTypedArrayList(Agent) ?: arrayListOf<Agent>(),
        parcel.createTypedArrayList(Place) ?: arrayListOf<Place>(),
        parcel.createTypedArrayList(Currency) ?: arrayListOf<Currency>(),
        parcel.readParcelable<ServiceQuery>(ServiceQuery::class.java.classLoader) as ServiceQuery
    ) {
    }

    override fun toString(): String {
        return "SkyResponse(sessionKey='$sessionKey', query=$query, status='$status', itineraries=$itineraries, legs=$legs, segments=$segments, carriers=$carriers, agents=$agents, places=$places, currencies=$currencies, dateTime=$dateTime)"
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(sessionKey)
        parcel.writeParcelable(query, flags)
        parcel.writeString(status)
        parcel.writeTypedList(itineraries)
        parcel.writeTypedList(legs)
        parcel.writeTypedList(segments)
        parcel.writeTypedList(carriers)
        parcel.writeTypedList(agents)
        parcel.writeTypedList(currencies)
        parcel.writeParcelable(dateTime, flags)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<SkyResponse> {
        override fun createFromParcel(parcel: Parcel): SkyResponse {
            return SkyResponse(parcel)
        }

        override fun newArray(size: Int): Array<SkyResponse?> {
            return arrayOfNulls(size)
        }
    }
}