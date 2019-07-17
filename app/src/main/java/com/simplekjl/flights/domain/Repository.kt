package com.simplekjl.flights.domain

import com.simplekjl.flights.data.model.SkyResponse
import io.reactivex.Observable
import io.reactivex.Single

interface Repository {

    fun getPrice(origin: String, destination: String): Observable<SkyResponse>?
    fun getMoreResults(url: String): Observable<SkyResponse>
}