package com.simplekjl.flights.presentation.features.flightlist.adapter

import androidx.recyclerview.widget.RecyclerView
import com.simplekjl.flights.databinding.FlightCardBinding
import com.simplekjl.flights.databinding.FlightItemBinding
import com.simplekjl.flights.presentation.features.flightlist.model.FlightDetailsModel

class FlightsViewHolder(
    private val binding: FlightCardBinding,
    private val listener: ItemClickListener
) : RecyclerView.ViewHolder(binding.root) {
    private val mListener: ItemClickListener = listener

    fun setItem(flight: FlightDetailsModel) {
        binding.flight = flight
    }
}