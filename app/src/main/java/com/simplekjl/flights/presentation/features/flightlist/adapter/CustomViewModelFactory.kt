package com.simplekjl.flights.presentation.features.flightlist.adapter

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.simplekjl.flights.domain.Repository
import com.simplekjl.flights.presentation.features.flightlist.ShowListActivityViewModel
import com.simplekjl.flights.presentation.features.flightlist.mapper.StateMapper

class CustomViewModelFactory(private val repository: Repository, private val stateMapper: StateMapper) :
    ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return ShowListActivityViewModel(repository, stateMapper) as T
    }
}