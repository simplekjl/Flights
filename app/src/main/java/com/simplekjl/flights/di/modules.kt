package com.simplekjl.flights.di

import com.simplekjl.flights.BuildConfig
import com.simplekjl.flights.data.remote.Network
import com.simplekjl.flights.data.remote.NetworkImpl
import com.simplekjl.flights.data.remote.SkyScannerApiService
import com.simplekjl.flights.data.remote.SkyScannerServiceFactory
import com.simplekjl.flights.domain.Repository
import com.simplekjl.flights.domain.RepositoryImpl
import com.simplekjl.flights.presentation.features.flightlist.ShowListActivityViewModel
import com.simplekjl.flights.presentation.features.flightlist.mapper.StateMapper
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module
import retrofit2.Retrofit


val appModule = module(override = true) {

    single<SkyScannerApiService> { get<Retrofit>().create(SkyScannerApiService::class.java) }
    single<Network> { NetworkImpl(get()) }
    single<Repository> { RepositoryImpl(NetworkImpl(get())) }
    single { StateMapper() }
    viewModel { ShowListActivityViewModel(get(), get()) }
    factory { SkyScannerServiceFactory.makeSkyScannerService(BuildConfig.DEBUG) }
}