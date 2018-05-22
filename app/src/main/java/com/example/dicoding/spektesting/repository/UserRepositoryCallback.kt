package com.example.dicoding.spektesting.repository

interface UserRepositoryCallback<T> {
    fun onStart()
    fun onLoad(data: T?)
    fun onError()
    fun onEmpty()
    fun onComplete()
}