package com.example.fragmnttutorialcodes.calls

import com.example.fragmnttutorialcodes.constants.BASE_URL
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object ApiClient {

    val apiClientInstance :ApiCalls by lazy{  get().create(ApiCalls::class.java)}

    private  fun get():Retrofit{
        return Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl(BASE_URL)
            .build()
    }
}