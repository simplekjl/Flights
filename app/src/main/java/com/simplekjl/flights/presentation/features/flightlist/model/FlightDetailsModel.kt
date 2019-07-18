package com.simplekjl.flights.presentation.features.flightlist.model

//Based on pricing options  same legs
class FlightDetailsModel {

    //ida
    var outboundStops: Int = 0
    lateinit var outboundDuration: String
    var isOutboundDirect: Boolean = false
    lateinit var outboundDepartureTime: String
    lateinit var outboundArrivalTime: String
    lateinit var outboundCarrierName: String
    lateinit var outboundCarrierCode: String
    lateinit var outboundCarrierImageUrl: String
    lateinit var outboundAgentName: String
    lateinit var outboundAgentImageUrl: String
    //vuelta
    var inboundStops = 0
    lateinit var inboundDuration: String
    var isInboundDirect: Boolean = false
    lateinit var inboundDepartureTime: String
    lateinit var inboundArrivalTime: String
    lateinit var inboundCarrierName: String
    lateinit var inboundCcarrierCode: String
    lateinit var inboundCarrierImageUrl: String
    //agents
    lateinit var inboundAgentName: String
    lateinit var inboundAgentImageUrl: String
    //currency
    var price: Float = 0.0f
    lateinit var currencySymbol: String
    var symbolOnLeft = false
}

