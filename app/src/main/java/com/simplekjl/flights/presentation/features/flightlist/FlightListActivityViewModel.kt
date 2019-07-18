package com.simplekjl.flights.presentation.features.flightlist

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.simplekjl.flights.domain.Repository
import com.simplekjl.flights.presentation.features.flightlist.model.FlightDetailsModel
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers

class FlightListActivityViewModel constructor(private val repository: Repository) : ViewModel() {
    private var compositeDisposable = CompositeDisposable()

    val flights: MutableLiveData<FlightListViewState> = MutableLiveData()

    fun getPrices(origin: String, destination: String): LiveData<FlightListViewState> {
        val data = MutableLiveData<FlightListViewState>()
        repository.getPrice(origin, destination)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(
                { response -> data.value = Success<List<FlightDetailsModel>>(response) },
                { data.value = ErrorEx(it.message) },
                { /** another action in complete**/ },
                { data.value = Loading }
            )?.let {
                compositeDisposable.add(it)
            }
        return data
    }

    fun clear() {
        compositeDisposable.clear()
    }
}