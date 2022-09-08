package com.simplekjl.flights.presentation.features.flightlist

sealed class FlightListViewState

object Loading : FlightListViewState()
data class Success<T>(val results: T) : FlightListViewState()
data class ErrorEx(val msg: String?) : FlightListViewState()