package com.simplekjl.flights.presentation.features.flightlist

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.simplekjl.flights.R
import com.simplekjl.flights.data.model.Itinerary
import com.simplekjl.flights.databinding.ActivityMainBinding
import com.simplekjl.flights.presentation.features.flightlist.adapter.FlightsAdapter
import com.simplekjl.flights.presentation.features.flightlist.adapter.ItemClickListener
import org.koin.androidx.viewmodel.ext.android.viewModel
import timber.log.Timber

class FlightListActivity : AppCompatActivity(), ItemClickListener {

    private lateinit var activityBinding: ActivityMainBinding
    private val activityViewModel: ShowListActivityViewModel by viewModel()
    private val tag = FlightListActivity::class.java.name
    val adapter: FlightsAdapter = FlightsAdapter(mutableListOf(), this)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        activityBinding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        //started point for the results
        getFlights("EDI","LHR")
        // subscriptions to have an infinite scroll
        //suscribeToMoreShows()
    }

    private fun suscribeToMoreShows() {
        activityViewModel.shows.observe(
            this, Observer { state ->
                when (state) {
                    is Loading -> {
                        Timber.d("Loading more ...")
                    }
                    is ErrorEx -> {
                        Timber.d(tag, "message : ${state.msg} , code: ${state.code}")
                    }
                    is ErrorMessage -> {
                        Timber.d(state.status_message)
                    }
                    is NotFoundMessage -> {
                        Timber.d(state.status_message)
                    }
                    is Success -> {
                        activityViewModel.nextPage = state.page + 1
                        activityViewModel.totalPages = state.total_pages
                        activityViewModel.loadingData = false
                        adapter.updateItems(state.results)
                    }
                }
            })
    }

    private fun getFlights(origin : String, destination : String ) {
        activityViewModel.getPrices(origin,destination).observe(this, Observer { state ->
            when (state) {
                is Loading -> {
                    showLoader()
                }
                is ErrorEx -> {
                    showErrorMessage()
                    Timber.d(tag, "message : ${state.msg} , code: ${state.code}")
                }
                is ErrorMessage -> {
                    updateErrorMessage(state.status_message)
                }
                is NotFoundMessage -> {
                    updateErrorMessage(state.status_message)
                }
                is Success -> {
                    showList()
                    activityViewModel.nextPage = state.page + 1
                    activityViewModel.totalPages = state.total_pages
                    renderShows(state.results)
                }
            }
        })
    }

    private fun updateErrorMessage(msg: String) {
        activityBinding.errorMessage.text = msg
    }

    private fun showErrorMessage() {
        activityBinding.errorMessage.visibility = View.VISIBLE
        activityBinding.rvGeneric.visibility = View.INVISIBLE
        activityBinding.progressBar.visibility = View.INVISIBLE
    }

    private fun showLoader() {
        activityBinding.errorMessage.visibility = View.INVISIBLE
        activityBinding.rvGeneric.visibility = View.INVISIBLE
        activityBinding.progressBar.visibility = View.VISIBLE
    }

    private fun showList() {
        activityBinding.errorMessage.visibility = View.INVISIBLE
        activityBinding.rvGeneric.visibility = View.VISIBLE
        activityBinding.progressBar.visibility = View.INVISIBLE
    }

    private fun renderShows(list: List<Itinerary>) {
        //setting the adapter
        activityBinding.rvGeneric.layoutManager = LinearLayoutManager(this@FlightListActivity)
        activityBinding.rvGeneric.adapter = adapter
        adapter.updateItems(list)
        with(activityBinding.rvGeneric) {
            addOnScrollListener(object : RecyclerView.OnScrollListener() {
                override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {
                    super.onScrolled(recyclerView, dx, dy)
                    val layoutManager = recyclerView.layoutManager
                    val totalItemCount = layoutManager!!.itemCount
                    val lastVisibleItemPosition = (layoutManager as LinearLayoutManager).findLastVisibleItemPosition()

                    Timber.d("item Count $totalItemCount")
                    if (lastVisibleItemPosition == totalItemCount.minus(2)) {
                        //activityViewModel.loadNextPage()
                        Timber.d("Loading next page $lastVisibleItemPosition")
                    }

                }
            })
        }
    }

    override fun onItemClick(position: Int) {
        //Implement click listener to the items
    }

    override fun onDestroy() {
        super.onDestroy()
        activityViewModel.clear()
    }
}
