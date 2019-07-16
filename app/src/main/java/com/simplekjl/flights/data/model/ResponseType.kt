package com.simplekjl.flights.data.model


sealed class ResponseType

/** 201	Created response **/
data class InitialResponse(val serviceQuery: ServiceQuery) : ResponseType()

/** 201	SuccessResponse response **/
data class SuccessResponse<T,M>(val responseValue: T, val data2: M) : ResponseType()

/**204	No content - the session is still being created (wait and try again).**/
data class NoContent<T, M>(val data: T, val data2: M) : ResponseType()

/**301    Moved Permanently – the result shows redirect location.**/
data class MovedPermanently<T, M>(val data: T, val data2: M) : ResponseType()

/**304    Not Modified – the results have not been modified since the last poll.**/
data class NotModified<T, M>(val data: T, val data2: M) : ResponseType()

/**400 Bad Request – Input validation failed.**/
data class BadRequest<T, M>(val data: T, val data2: M) : ResponseType()

/**403 Forbidden – The API Key was not supplied, or it was invalid, or it is not authorized to access the service.**/
data class Forbidden<T, M>(val data: T, val data2: M) : ResponseType()

/**410    Gone – the session has expired. A new session must be created.**/
data class Gone<T, M>(val data: T, val data2: M) : ResponseType()

/**429    Too Many Requests – There have been too many requests in the last minute.**/
data class TooManyRequest<T, M>(val data: T, val data2: M) : ResponseType()

/**500    Server Error – An internal server error has occurred which has been logged.**/
data class ServerError<T, M>(val data: T, val data2: M) : ResponseType()








