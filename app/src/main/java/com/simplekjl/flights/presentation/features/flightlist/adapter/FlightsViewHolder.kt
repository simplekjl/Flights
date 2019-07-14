package com.simplekjl.flights.presentation.features.flightlist.adapter

import androidx.recyclerview.widget.RecyclerView
import com.simplekjl.flights.data.model.Itinerary
import com.simplekjl.flights.databinding.FlightItemBinding

class FlightsViewHolder(
    private val binding: FlightItemBinding,
    private val listener: ItemClickListener
) : RecyclerView.ViewHolder(binding.root) {
    private val mListener: ItemClickListener = listener

    fun setItem(itinerary: Itinerary) {
        binding.itinerary = itinerary
    }
}