package com.simplekjl.flights.domain

import com.simplekjl.flights.data.model.SkyResponse
import com.simplekjl.flights.presentation.features.flightlist.model.ItineraryModel
import io.reactivex.Observable

interface Repository {

    fun getPrice(origin: String, destination: String): Observable<ItineraryModel>
    fun getMoreResults(url: String): Observable<SkyResponse>
}