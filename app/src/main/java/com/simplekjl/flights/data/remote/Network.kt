package com.simplekjl.flights.data.remote

import com.simplekjl.flights.data.model.ResponseType
import com.simplekjl.flights.data.model.SkyResponse
import io.reactivex.Single

interface Network {
    fun getPrices(origin: String, destination: String): Single<String>
    fun getResults(url: String): Single<SkyResponse>
}