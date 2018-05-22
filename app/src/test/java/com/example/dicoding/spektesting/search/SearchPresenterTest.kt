package com.example.dicoding.spektesting.search

import com.example.dicoding.spektesting.entity.SearchUserResponse
import com.example.dicoding.spektesting.repository.UserRepository
import com.example.dicoding.spektesting.repository.UserRepositoryCallback
import com.nhaarman.mockito_kotlin.argumentCaptor
import com.nhaarman.mockito_kotlin.eq
import com.nhaarman.mockito_kotlin.verify
import org.jetbrains.spek.api.Spek
import org.jetbrains.spek.api.dsl.given
import org.jetbrains.spek.api.dsl.it
import org.jetbrains.spek.api.dsl.on
import org.junit.platform.runner.JUnitPlatform
import org.junit.runner.RunWith
import org.mockito.Mockito

@RunWith(JUnitPlatform::class)
class SearchPresenterTest : Spek({

    given("Search Presenter Testing") {

        val view = Mockito.mock(SearchView::class.java)
        val repository = Mockito.mock(UserRepository::class.java)
        val response = Mockito.mock(SearchUserResponse::class.java)

        val presenter = SearchPresenter(view, repository)

        on("Get User Test") {
            val query = "kucingdicoding"
            presenter.search(query)

            argumentCaptor<UserRepositoryCallback<SearchUserResponse>>().apply {
                verify(repository).doSearch(eq(query), capture())
                firstValue.onStart()
                firstValue.onLoad(response)
                firstValue.onEmpty()
                firstValue.onError()
                firstValue.onComplete()
            }

            it("Show loading") {
                verify(view).onSearchLoading(true)
            }

            it("Success search user") {
                verify(view).onSearchLoaded(response.items)
            }

            it("Empty Search User") {
                verify(view).onSearchEmpty()
            }

            it("Error Search User") {
                verify(view).onSearchError()
            }

            it("Hide loading") {
                verify(view).onSearchLoading(false)
            }
        }
    }
})