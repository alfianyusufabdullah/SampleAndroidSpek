package com.example.dicoding.spektesting.search

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.example.dicoding.spektesting.R
import com.example.dicoding.spektesting.entity.ItemsItem
import com.example.dicoding.spektesting.repository.UserRepository

class
SearchActivity : AppCompatActivity(), SearchView {

    override fun onSearchLoading(loading: Boolean) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun onSearchLoaded(users: List<ItemsItem>?) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun onSearchEmpty() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun onSearchError() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    private lateinit var searchPresenter: SearchPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        searchPresenter = SearchPresenter(this , UserRepository())
    }
}
