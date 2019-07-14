package com.simplekjl.flights.data.model


data class SuccessResponse(val serviceQuery: ServiceQuery)

class ServiceQuery(val dateTime: String)