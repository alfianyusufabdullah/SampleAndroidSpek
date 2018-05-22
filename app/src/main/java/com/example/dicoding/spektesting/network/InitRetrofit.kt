package com.example.dicoding.spektesting.network

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object InitRetrofit {

    private val retrofit = Retrofit.Builder().baseUrl("https://api.github.com/").addConverterFactory(GsonConverterFactory.create()).build()

    fun <T> createService(service: Class<T>) : T {
        return retrofit.create(service)
    }
}