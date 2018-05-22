package com.example.dicoding.spektesting.search

import com.example.dicoding.spektesting.entity.SearchUserResponse
import com.example.dicoding.spektesting.repository.UserRepository
import com.example.dicoding.spektesting.repository.UserRepositoryCallback

class SearchPresenter(private val view: SearchView, private val repository: UserRepository) {

    fun search(query: String) {

        repository.doSearch(query, object : UserRepositoryCallback<SearchUserResponse> {
            override fun onStart() {
                view.onSearchLoading(true)
            }

            override fun onComplete() {
                view.onSearchLoading(false)
            }

            override fun onLoad(data: SearchUserResponse?) {
                data?.items?.let { users -> view.onSearchLoaded(users) }
            }

            override fun onError() {
                view.onSearchError()
            }

            override fun onEmpty() {
                view.onSearchEmpty()
            }
        })
    }
}