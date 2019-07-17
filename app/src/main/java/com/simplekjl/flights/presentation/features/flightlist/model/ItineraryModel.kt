package com.simplekjl.flights.presentation.features.flightlist.model

import com.simplekjl.flights.data.model.Itinerary
import com.simplekjl.flights.data.model.Leg
import com.simplekjl.flights.data.model.Segment

class ItineraryModel {
    lateinit var segments: ArrayList<Segment>
    lateinit var legs: ArrayList<Leg>
    lateinit var itineraries: ArrayList<Itinerary>
    var count: Int = 0
    lateinit var trip: Any
}