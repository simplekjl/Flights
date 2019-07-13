package com.simplekjl.flights

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

/**
 * Comment added since the README.md file might be ignored!
 *
 *
 * Flights!
 * The app allow you to get the best prices from a famous API
 *
 * API KEY
 * In order to run the app the following variables must be created in the `gradle.properties` located in `$USER/.gradle`
 * `SKY_API_KEY = your_api_key`
 * `SKY_URL_BASE_ENDPOINT = "http://partners.api.skyscanner.net/apiservices/"`
 *
 * `SKY_IMAGE_BASE_URL = "https://logos.skyscnr.com/images/airlines/"`
 *
 *
 */
class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
}
