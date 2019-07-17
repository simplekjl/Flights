package com.simplekjl.flights.presentation.features.flightlist

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.simplekjl.flights.domain.Repository
import com.simplekjl.flights.presentation.features.flightlist.mapper.StateMapper
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers
import timber.log.Timber

class ShowListActivityViewModel constructor(private val repository: Repository, private val stateMapper: StateMapper) :
    ViewModel() {
    private var compositeDisposable = CompositeDisposable()

    var loadingData = false
    var nextPage = 0
    var totalPages = 0

    val flights: MutableLiveData<ShowListViewState> = MutableLiveData()

    fun getPrices(origin: String, destination: String): LiveData<ShowListViewState> {
        val data = MutableLiveData<ShowListViewState>()
        repository.getPrice(origin, destination)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({
                Timber.d(it.toString())
            }, {
                Timber.d(it)
            })?.let {
                compositeDisposable.add(it)
            }
        return data
    }

    fun getAllResults(newUrl: String) {
        if (nextPage < totalPages && !loadingData) {
            loadingData = true
            compositeDisposable.add(
                repository.getMoreResults(newUrl)
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribeOn(Schedulers.computation())
                    .subscribe(
                        { response -> flights.value = Success(response) },
                        { flights.value = ErrorEx(it.message, null) },
                        { /** Verify we got a success response **/ },
                        { flights.value = Loading })
            )
        }
    }

    fun clear() {
        totalPages = 0
        nextPage = 0
        compositeDisposable.clear()
    }
}