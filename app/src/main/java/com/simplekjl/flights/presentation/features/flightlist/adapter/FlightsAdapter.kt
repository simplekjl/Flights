package com.simplekjl.flights.presentation.features.flightlist.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.simplekjl.flights.databinding.FlightItemBinding
import com.simplekjl.flights.presentation.features.flightlist.model.FlightDetailsModel

class FlightsAdapter(
    private val showList: List<FlightDetailsModel>,
    private val listener: ItemClickListener
) : RecyclerView.Adapter<FlightsViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FlightsViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = FlightItemBinding.inflate(inflater, parent, false)

        return FlightsViewHolder(binding, listener)
    }

    override fun getItemCount(): Int = showList.size

    override fun onBindViewHolder(holder: FlightsViewHolder, position: Int) {
        holder.setItem(showList[position])
    }

}