package com.simplekjl.flights.data.model


sealed class ResponseType

/** HTTP 401 **/
data class ErrorResponse(val status_message: String, val success: Boolean, val status_code: Int) : ResponseType()

/** HTTP 404 **/
data class NotFoundResponse(val status_message: String, val status_code: Int) : ResponseType()

/** 200 response **/
data class Success<T, M>(val data: T, val data2: M) : ResponseType()