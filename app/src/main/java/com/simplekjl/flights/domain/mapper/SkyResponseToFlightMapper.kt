package com.simplekjl.flights.domain.mapper

import com.simplekjl.flights.data.model.Place
import com.simplekjl.flights.data.model.Segment
import com.simplekjl.flights.data.model.SkyResponse
import com.simplekjl.flights.presentation.features.flightlist.model.FlightDetailsModel
import timber.log.Timber
import java.text.ParseException
import java.text.SimpleDateFormat
import java.util.*

/**
 * Conversion from SkyResponse model to FlightDetailsModel which represents the data required for the view
 */

open class SkyResponseToFlightMapper : EntityMapper<SkyResponse, List<FlightDetailsModel>> {
    override fun mapFromRemote(type: SkyResponse): List<FlightDetailsModel> {
        val flightList = mutableListOf<FlightDetailsModel>()

        type.itineraries.forEach { itinerary ->

            val outboundLeg = type.legs.first { it.id == itinerary.outboundLegId }
            val inboundLeg = type.legs.first { it.id == itinerary.inboundLegId }
            val outboundSegments = type.segments.first { it.id == outboundLeg.segmentIds.first().toString() }
            val inboundSegments = type.segments.first { it.id == inboundLeg.segmentIds.first().toString() }
            val places = type.places

            for (i in itinerary.pricingOptions) {
                val flight = FlightDetailsModel()
                //flight.price = itinerary.pricingOptions.[i].
                //outbound flight
                flight.outboundDuration = getTimeString(outboundLeg.duration)
                flight.outboundStops = outboundLeg.segmentIds.count()
                flight.isOutboundDirect = getTextForFlightType(flight.outboundStops)
                flight.outboundDepartureTime = getTimeFromDate(outboundLeg.departure)
                flight.outboundArrivalTime = getTimeFromDate(outboundLeg.arrival)
                val outboundCarrier = type.carriers.first { outboundLeg.carriers.first() == it.id }
                flight.outboundCarrierName = outboundCarrier.name
                flight.outboundCarrierCode = outboundCarrier.code
                flight.outboundCarrierImageUrl = outboundCarrier.imageUrl
                val outboundAgent = type.agents.first { i.agents[0] == it.id }
                flight.outboundAgentName = "via ".plus(outboundAgent.name)
                flight.outboundAgentImageUrl = outboundAgent.imageUrl
                flight.outboundDestination = getDestinationText(outboundSegments, places, flight.outboundAgentName)

                //inbound flight
                flight.inboundStops = inboundLeg.segmentIds.count()
                flight.inboundDuration = getTimeString(inboundLeg.duration)
                flight.isInboundDirect = getTextForFlightType(flight.inboundStops)
                flight.inboundDepartureTime = getTimeFromDate(inboundLeg.departure)
                flight.inboundArrivalTime = getTimeFromDate(inboundLeg.arrival)
                val inboundCarrier = type.carriers.first { inboundLeg.carriers.first() == it.id }
                flight.inboundCarrierName = inboundCarrier.name
                flight.inboundCarrierCode = inboundCarrier.code
                flight.inboundCarrierImageUrl = inboundCarrier.imageUrl
                val inboundAgent = type.agents.first { i.agents[0] == it.id }
                flight.inboundAgentName = "via ".plus(inboundAgent.name)
                flight.inboundAgentImageUrl = inboundAgent.imageUrl
                flight.inboundDestination = getDestinationText(inboundSegments, places, flight.inboundAgentName)
                //currency
                flight.price = i.price.toString()
                flight.currencySymbol = type.currencies.first().symbol
                flight.symbolOnLeft = type.currencies.first().symbolOnLeft
                flightList.add(flight)
            }


        }

        return flightList
    }

    private fun getDestinationText(segment: Segment, places: List<Place>, agentName: String): String {
        val originStation = places.first { segment.originStation == it.id }.code
        val destinationStation = places.first { segment.destinationStation == it.id }.code

        return "$originStation - $destinationStation, $agentName"
    }

    private fun getTextForFlightType(stops: Int): String {
        return if (stops == 1) "Direct" else " v stops".replace("v", stops.toString())
    }

    private fun getTimeFromDate(time: String): String {
        val webServiceDateFormat = "yyyy-MM-dd'T'HH:mm:ss"
        val displayFormat = "hh:mm"
        val dfIn = SimpleDateFormat(webServiceDateFormat, Locale.US)
        dfIn.timeZone = TimeZone.getTimeZone("UTC")
        val dfOut = SimpleDateFormat(displayFormat, Locale.US)
        try {
            val date = dfIn.parse(time)
            if (date != null)
                return dfOut.format(date)
        } catch (e: ParseException) {
            // throw exception
            Timber.d(e.message)
        }
        return ""
    }

    private fun getTimeString(flightTime: Int): String {

        val hours = flightTime / 60 //since both are ints, you get an int
        val minutes = flightTime % 60
        return "${hours}h ${minutes}m"
    }

}