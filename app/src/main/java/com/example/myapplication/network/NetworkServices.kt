package com.example.myapplication.network

import com.example.myapplication.entity.Item
import retrofit2.Call
import retrofit2.http.GET

interface NetworkServices {
    @GET("videos.json")
    fun getAll():Call<ArrayList<Item>>
}