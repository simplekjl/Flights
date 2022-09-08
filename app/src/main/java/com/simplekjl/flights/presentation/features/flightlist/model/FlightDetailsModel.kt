package com.simplekjl.flights.presentation.features.flightlist.model

//Based on pricing options  same legs
class FlightDetailsModel {


    //ida
    var outboundStops: Int = 0
    lateinit var outboundDuration: String
    lateinit var isOutboundDirect: String
    lateinit var outboundDepartureTime: String
    lateinit var outboundArrivalTime: String
    lateinit var outboundCarrierName: String
    lateinit var outboundCarrierCode: String
    lateinit var outboundCarrierImageUrl: String
    lateinit var outboundAgentName: String
    lateinit var outboundAgentImageUrl: String
    lateinit var outboundDestination: String
    //vuelta
    var inboundStops: Int = 0
    lateinit var inboundDuration: String
    lateinit var isInboundDirect: String
    lateinit var inboundDepartureTime: String
    lateinit var inboundArrivalTime: String
    lateinit var inboundCarrierName: String
    lateinit var inboundCarrierCode: String
    lateinit var inboundCarrierImageUrl: String
    lateinit var inboundDestination: String
    //agents
    lateinit var inboundAgentName: String
    lateinit var inboundAgentImageUrl: String
    //currency
    lateinit var price: String
    lateinit var currencySymbol: String
    var symbolOnLeft = false
}

