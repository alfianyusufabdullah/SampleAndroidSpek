package com.example.dicoding.spektesting.network

import com.example.dicoding.spektesting.entity.SearchUserResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiRepository {

    @GET("/search/user/")
    fun searchUser(@Query("q") query: String) : Call<SearchUserResponse>

}