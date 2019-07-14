package com.simplekjl.flights.data.remote

import com.simplekjl.flights.data.model.ResponseType
import io.reactivex.Single

interface Network {
    fun getToken(): Single<ResponseType>
    fun getPrices(origin: String, destination: String): Single<ResponseType>
    fun getResults(url: String): Single<ResponseType>
}