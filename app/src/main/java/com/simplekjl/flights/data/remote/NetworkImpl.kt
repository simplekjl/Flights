package com.simplekjl.flights.data.remote

import com.simplekjl.flights.BuildConfig
import com.simplekjl.flights.data.model.SkyResponse
import io.reactivex.Single

class NetworkImpl constructor(private val service: SkyScannerApiService) : Network {
    override fun getResults(url: String): Single<SkyResponse> {
        return Single.create {
            val call = service.getAllResults(url).execute()
            if (call.isSuccessful)
                it.onSuccess(call.body()!!)
            else {
                it.onError(Throwable(call.errorBody().toString()))
            }
        }
    }

    override fun getPrices(origin: String, destination: String): Single<String> {
        return Single.create {
            val call = service.getPrices(
                "Economy", "UK", "GBP", "en-GB",
                "iata", origin, destination, "2019-07-20",
                "2019-07-27", "1", "0", "0", BuildConfig.apiKey
            ).execute()
            if (call.isSuccessful && call.code() == 201) {
                val newUrl = call.headers().get("location") ?: ""
                it.onSuccess(newUrl)
            } else {
                it.onError(Throwable(call.errorBody().toString()))
            }
        }
    }


}