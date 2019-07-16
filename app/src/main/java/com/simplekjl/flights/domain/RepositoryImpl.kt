package com.simplekjl.flights.domain

import com.simplekjl.flights.data.model.SkyResponse
import com.simplekjl.flights.data.remote.Network
import io.reactivex.Observable
import io.reactivex.Single

/**
 *  Repository decides where to take data, it can be Database, Cache or Network
 */

class RepositoryImpl(private val network: Network) : Repository {

    override fun getPrice(origin: String, destination: String): Single<String> {
        return network.getPrices(origin, destination)


    }

    override fun getMoreResults(url: String): Observable<SkyResponse> {
        return network.getResults(url).toObservable()
    }


}