package com.simplekjl.flights.domain

import com.simplekjl.flights.data.model.ResponseType
import com.simplekjl.flights.data.model.SkyResponse
import com.simplekjl.flights.data.model.SuccessResponse
import com.simplekjl.flights.data.remote.Network
import io.reactivex.Observable
import io.reactivex.Single
import io.reactivex.schedulers.Schedulers

/**
 *  Repository decides where to take data, it can be Database, Cache or Network
 */

class RepositoryImpl constructor(private val network: Network) : Repository {
    override fun getPrice(origin: String, destination: String) : Single<SkyResponse> {
        return Single.create<SkyResponse> { emitter ->
            getPricesFromRemote(origin, destination)
                .map { newUrl -> getMoreResults(newUrl)
                    .subscribe({emitter.onSuccess(it)},{},{},{}) }
                .subscribe ()
        }
    }

    override fun getMoreResults(url: String): Observable<SkyResponse> {
        return network.getResults(url).toObservable()
    }

    private fun getPricesFromRemote(origin: String, destination: String): Single<String> {
        return Single.create { emitter ->
            network.getPrices(origin, destination)
                .subscribeOn(Schedulers.computation())
                .subscribe({
                    when (it) {
                        is SuccessResponse<*, *> -> {
                            emitter.onSuccess(it.data2 as String)// the string coming back from the wrappper
                        }
                        else -> {
                            emitter.onError(Throwable("No location header"))
                        }
                    }//when

                }, { emitter.onError(Throwable("No location header")) })
                .dispose()
        }
    }

}