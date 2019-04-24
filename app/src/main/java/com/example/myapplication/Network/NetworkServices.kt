package com.example.myapplication.Network

import com.example.myapplication.Entity.Item
import retrofit2.Call
import retrofit2.http.GET

interface NetworkServices {
    @GET("videos.json")
    fun getAll():Call<ArrayList<Item>>
}