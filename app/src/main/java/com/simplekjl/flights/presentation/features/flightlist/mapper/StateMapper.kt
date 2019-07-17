package com.simplekjl.flights.presentation.features.flightlist.mapper

import com.simplekjl.flights.data.model.SkyResponse
import com.simplekjl.flights.presentation.features.flightlist.model.ItineraryModel

/**
 * Conversion from SkyResponse model to ItineraryModel which represents the data required for the view
 */

open class StateMapper : EntityMapper<SkyResponse, ItineraryModel> {
    override fun mapFromRemote(type: SkyResponse): ItineraryModel {
        val itineraryModel = ItineraryModel()
        itineraryModel.itineraries = type.itineraries
        itineraryModel.legs = type.legs
        itineraryModel.segments = type.segments
        itineraryModel.trip = type.itineraries
        itineraryModel.count = type.itineraries.count()
        return itineraryModel
    }

}