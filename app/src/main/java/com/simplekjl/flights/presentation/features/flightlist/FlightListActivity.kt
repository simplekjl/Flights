package com.simplekjl.flights.presentation.features.flightlist

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.simplekjl.flights.R
import com.simplekjl.flights.databinding.ActivityMainBinding
import com.simplekjl.flights.presentation.features.flightlist.adapter.FlightsAdapter
import com.simplekjl.flights.presentation.features.flightlist.adapter.ItemClickListener
import com.simplekjl.flights.presentation.features.flightlist.model.FlightDetailsModel
import org.koin.androidx.viewmodel.ext.android.viewModel
import timber.log.Timber

@Suppress("UNCHECKED_CAST")
class FlightListActivity : AppCompatActivity(), ItemClickListener {

    private lateinit var activityBinding: ActivityMainBinding
    private val activityViewModel: FlightListActivityViewModel by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        activityBinding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        //started point for the results
        getFlights("EDI", "LHR")
    }


    private fun getFlights(origin: String, destination: String) {
        activityViewModel.getPrices(origin, destination).observe(this, Observer { state ->
            when (state) {
                is Loading -> {
                    showLoader()
                }
                is ErrorEx -> {
                    showErrorMessage()
                    updateErrorMessage("error")
                    Timber.d("message : ${state.msg}")
                }
                is Success<*> -> {
                    showList()
                    state.results?.let {
                        renderFlights(it as List<FlightDetailsModel>)
                    }
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

    private fun renderFlights(list: List<FlightDetailsModel>) {
        //setting the adapter
        activityBinding.rvGeneric.layoutManager = LinearLayoutManager(this@FlightListActivity)
        activityBinding.rvGeneric.adapter = FlightsAdapter(list, this)

    }

    override fun onItemClick(position: Int) {
        //Implement click listener to the items
    }

    override fun onDestroy() {
        super.onDestroy()
        activityViewModel.clear()
    }
}
