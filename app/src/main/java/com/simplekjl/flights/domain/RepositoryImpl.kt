package com.simplekjl.flights.domain

import com.simplekjl.flights.data.model.ResponseType
import com.simplekjl.flights.data.remote.Network
import io.reactivex.Observable

/**
 *  Repository decides where to take data, it can be Database, Cache or Network
 */

class RepositoryImpl constructor(private val network: Network) : Repository {
    override fun getPrice(origin: String, destination: String): Observable<ResponseType> {
        return network.getPrices(origin, destination).toObservable()
    }

    override fun getMoreResults(url: String): Observable<ResponseType> {
        return network.getResults(url).toObservable()
    }

    override fun getToken(): Observable<ResponseType> {
        return network.getToken().toObservable()
    }
}