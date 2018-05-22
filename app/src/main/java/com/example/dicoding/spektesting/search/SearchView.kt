package com.example.dicoding.spektesting.search

import com.example.dicoding.spektesting.entity.ItemsItem

interface SearchView {

    fun onSearchLoading(loading: Boolean)
    fun onSearchLoaded(users: List<ItemsItem>?)
    fun onSearchEmpty()
    fun onSearchError()

}