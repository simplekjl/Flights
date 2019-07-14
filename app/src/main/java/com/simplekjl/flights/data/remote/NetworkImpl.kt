package com.simplekjl.flights.data.remote

import com.simplekjl.flights.BuildConfig
import com.simplekjl.flights.data.model.ErrorResponse
import com.simplekjl.flights.data.model.NotFoundResponse
import com.simplekjl.flights.data.model.ResponseType
import com.simplekjl.flights.data.model.Success
import io.reactivex.Single
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class NetworkImpl constructor(private val service: SkyScannerApiService) : Network {
    override fun getResults(url: String): Single<ResponseType> {
        return Single.create { }
    }

    override fun getPrices(origin: String, destination: String): Single<ResponseType> {
        return Single.create { emitter ->
            val call = service.getPrices(
                "Economy", "UK", "GBP", "en-GB",
                "iata", origin, destination, "2019-07-20",
                "2019-07-27", "1", "0", "0", BuildConfig.apiKey
            ).execute()
            if (call.isSuccessful && call.code() == 201) {
                val newUrl = call.headers().get("location")
                emitter.onSuccess(Success(call.body(), newUrl))
            }
        }
    }

    /**
     * Method that returns the token to be able to get data
     * has to be renewed every 30 min.
     */
    override fun getToken(): Single<ResponseType> {
        return Single.create { emitter ->
            service.getToken(BuildConfig.apiKey).enqueue(object : Callback<String> {
                override fun onFailure(call: Call<String>, t: Throwable) {
                    emitter.onError(t)
                }

                override fun onResponse(call: Call<String>, response: Response<String>) {
                    when (response.code()) {
                        401 -> {
                            emitter.onSuccess(ErrorResponse("API KEY is required for this action ", false, 401))
                        }
                        404 -> {
                            emitter.onSuccess(NotFoundResponse("Element not found", 404))
                        }
                        200 -> {
                            emitter.onSuccess(Success(response.body(),null))
                        }
                    }
                }
            })
        }
    }

}