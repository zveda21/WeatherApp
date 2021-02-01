package com.example.fragmnttutorialcodes.calls

import com.example.fragmnttutorialcodes.models.CurrentLocationWeather
import retrofit2.Call

object Repository {
    fun getCurrentLocWeather():Call<CurrentLocationWeather> = ApiClient.apiClientInstance.getCurrentWeather()
}