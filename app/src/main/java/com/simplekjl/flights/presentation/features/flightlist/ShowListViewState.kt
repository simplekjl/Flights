package com.simplekjl.flights.presentation.features.flightlist

import com.simplekjl.flights.data.model.SkyResponse

sealed class ShowListViewState

object Loading : ShowListViewState()
data class Success(
    val results: SkyResponse
) : ShowListViewState()

data class ErrorEx(val msg: String?, val code: Int?) : ShowListViewState()