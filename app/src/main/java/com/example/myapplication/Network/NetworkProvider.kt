package com.example.myapplication.Network

import com.example.myapplication.Entity.Item
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class NetworkProvider(var networkProviderListener: NetworkProviderListener) {
    fun getAll() {
        Retrofit.networkServices.getAll().enqueue(object : Callback<ArrayList<Item>> {
            override fun onResponse(call: Call<ArrayList<Item>>, response: Response<ArrayList<Item>>) {
                networkProviderListener.getAllSuccess(response.body() as ArrayList<Item>)
            }
            override fun onFailure(call: Call<ArrayList<Item>>, t: Throwable) {

            }
        })
    }
    interface NetworkProviderListener {
        fun getAllSuccess(items:ArrayList<Item>)
        fun getAllFail()
    }
}