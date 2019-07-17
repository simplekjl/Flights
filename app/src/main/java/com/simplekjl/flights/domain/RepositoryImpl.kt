package com.simplekjl.flights.domain

import com.simplekjl.flights.data.model.SkyResponse
import com.simplekjl.flights.data.remote.Network
import com.simplekjl.flights.presentation.features.flightlist.model.ItineraryModel
import com.simplekjl.flights.presentation.features.flightlist.mapper.StateMapper
import io.reactivex.Observable

/**
 *  Repository decides where to take data, it can be Database, Cache or Network
 */

class RepositoryImpl(private val network: Network) : Repository {

    override fun getPrice(origin: String, destination: String): Observable<ItineraryModel> {
        val stateMapper = StateMapper()
        return network.getPrices(origin, destination)
            .flatMapObservable { result -> getMoreResults(result) }
            .map { stateMapper.mapFromRemote(it) }
            .onErrorReturn { t: Throwable -> throw IllegalStateException() }
    }

    /**
     *  Must get the location header when using this method, it contains the TOKEN for the session
     * @param url Url provided by pricing endpoint
     */
    override fun getMoreResults(url: String): Observable<SkyResponse> {
        return network.getResults(url).toObservable()
    }
}