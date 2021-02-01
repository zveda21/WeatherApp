package com.example.fragmnttutorialcodes.calls

import com.example.fragmnttutorialcodes.constants.ApiKey
import com.example.fragmnttutorialcodes.models.CurrentLocationWeather
import retrofit2.Call
import retrofit2.http.GET


interface ApiCalls {
    @GET("weather?q=Yerevan&appid=$ApiKey")
    fun getCurrentWeather():Call<CurrentLocationWeather>
}