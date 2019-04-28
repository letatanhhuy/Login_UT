package com.example.myapplication.network

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
const val URL = "https://yent-mobile-take-home.herokuapp.com"
object Retrofit {
    private var retrofit = Retrofit.Builder()
        .baseUrl(URL)
        .addConverterFactory(GsonConverterFactory.create())
        .build()
    var networkServices = retrofit.create(NetworkServices::class.java)
}