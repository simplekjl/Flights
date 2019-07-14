package com.simplekjl.flights.domain

import com.simplekjl.flights.data.model.ResponseType
import io.reactivex.Observable

interface Repository {
    fun getToken(): Observable<ResponseType>
    fun getPrice(origin: String, destination: String): Observable<ResponseType>
    fun getMoreResults(url: String): Observable<ResponseType>
}