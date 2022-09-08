package com.simplekjl.flights.domain

import com.simplekjl.flights.data.model.SkyResponse
import com.simplekjl.flights.presentation.features.flightlist.model.FlightDetailsModel
import io.reactivex.Observable

interface Repository {

    fun getPrice(origin: String, destination: String): Observable<List<FlightDetailsModel>>
    fun getMoreResults(url: String): Observable<SkyResponse>
}