package com.example.dicoding.spektesting.repository

import com.example.dicoding.spektesting.entity.SearchUserResponse
import com.example.dicoding.spektesting.network.ApiRepository
import com.example.dicoding.spektesting.network.InitRetrofit
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class UserRepository {

    fun doSearch(query: String, callback: UserRepositoryCallback<SearchUserResponse>) {
        callback.onStart()
        InitRetrofit
                .createService(ApiRepository::class.java)
                .searchUser(query)
                .enqueue(object : Callback<SearchUserResponse> {
                    override fun onFailure(call: Call<SearchUserResponse>?, t: Throwable?) {
                        callback.onError()
                        callback.onComplete()
                    }

                    override fun onResponse(call: Call<SearchUserResponse>?, response: Response<SearchUserResponse>?) {
                        response?.let {
                            if (it.isSuccessful) {
                                val totalCount = it.body()?.totalCount
                                totalCount?.let { count ->

                                    if (count == 0) {
                                        callback.onEmpty()
                                    } else {
                                        callback.onLoad(it.body())
                                    }
                                }
                            } else {
                                callback.onError()
                            }
                            callback.onComplete()
                        }
                    }
                })
    }
}