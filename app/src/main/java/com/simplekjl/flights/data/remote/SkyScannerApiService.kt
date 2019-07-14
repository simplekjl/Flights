package com.simplekjl.flights.data.remote

import com.simplekjl.flights.data.model.SkyResponse
import com.simplekjl.flights.data.model.SuccessResponse
import io.reactivex.Observable
import retrofit2.Call
import retrofit2.http.*

/**
 * for more information {@url https://developers.themoviedb.org/3/tv/get-popular-tv-shows}
 */
interface SkyScannerApiService {

    @GET("token/v2/gettoken")
    fun getToken(@Query("api_key") apiKey: String): Call<String>


    @POST("pricing/v1.0")
    @FormUrlEncoded
    fun getPrices(
        @Field("cabinclass") cabinClass :String,
        @Field("country") country: String,
        @Field("currency") currency: String,
        @Field("locale") locale: String,
        @Field("locationSchema") locationSchema: String,
        @Field("originplace") originPlace: String,
        @Field("destinationplace") destinationPlace: String,
        @Field("outbounddate") outbounddate: String,
        @Field("inbounddate") inboundDate: String,
        @Field("adults") adults: String,
        @Field("children") children: String,
        @Field("infants") infants: String,
        @Field("apikey") apiKey: String
    ): Call<SuccessResponse>

    @GET
    fun getAllResults(@Url url: String): Observable<SkyResponse>
}