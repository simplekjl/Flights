package com.simplekjl.flights.presentation.features.flightlist.mapper

import com.simplekjl.flights.data.model.ResponseType
import com.simplekjl.flights.data.model.SuccessResponse
import com.simplekjl.flights.presentation.features.flightlist.Loading
import com.simplekjl.flights.presentation.features.flightlist.ShowListViewState


open class StateMapper : EntityMapper<ResponseType, ShowListViewState> {
    override fun mapFromRemote(type: ResponseType): ShowListViewState {
        return when (type) {
//            is ErrorResponse -> {
//                ErrorMessage(type.status_message, type.success, type.status_code)
//            }
//            is NotFoundResponse -> {
//                NotFoundMessage(type.status_message, type.status_code)
//            }
            is SuccessResponse<*, *> -> {
                Loading
            }
            else -> {
                Loading
            }
        }
    }
}