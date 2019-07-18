package com.simplekjl.flights.presentation.features.flightlist.adapter

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.simplekjl.flights.domain.Repository
import com.simplekjl.flights.presentation.features.flightlist.FlightListActivityViewModel
import com.simplekjl.flights.domain.mapper.SkyResponseToFlightMapper

class CustomViewModelFactory(private val repository: Repository, private val stateMapper: SkyResponseToFlightMapper) :
    ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return FlightListActivityViewModel(repository) as T
    }
}