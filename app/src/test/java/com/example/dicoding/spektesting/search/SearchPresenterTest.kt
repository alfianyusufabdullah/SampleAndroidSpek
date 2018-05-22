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

    given("Search User") {

        val view = Mockito.mock(SearchView::class.java)
        val repository = Mockito.mock(UserRepository::class.java)
        val response = Mockito.mock(SearchUserResponse::class.java)

        val presenter = SearchPresenter(view, repository)

        on("Show loading") {
            val query = "kucing"

            presenter.search(query)

            it("loading") {
                argumentCaptor<UserRepositoryCallback<SearchUserResponse>>().apply {
                    verify(repository).doSearch(eq(query), capture())
                    firstValue.onStart()
                }

                verify(view).onSearchLoading(true)
            }
        }

        on("success search user") {
            val query = "alfianyusufabdullah"

            presenter.search(query)

            it("success search user") {
                argumentCaptor<UserRepositoryCallback<SearchUserResponse>>().apply {
                    verify(repository).doSearch(eq(query), capture())
                    firstValue.onLoad(response)
                }

                verify(view).onSearchLoaded(response.items)
            }
        }

        on("empty search user") {
            val query = "kucingdicoding"

            presenter.search(query)
            it("empty") {
                argumentCaptor<UserRepositoryCallback<SearchUserResponse>>().apply {
                    verify(repository).doSearch(eq(query), capture())
                    firstValue.onEmpty()
                }

                verify(view).onSearchEmpty()
            }
        }

        on("error search user") {
            val query = "kucingdicodingg"

            presenter.search(query)
            it("error") {
                argumentCaptor<UserRepositoryCallback<SearchUserResponse>>().apply {
                    verify(repository).doSearch(eq(query), capture())
                    firstValue.onError()
                }

                verify(view).onSearchError()
            }
        }

        on("Hide loading") {
            val query = "kucingg"

            presenter.search(query)

            it("loading") {
                argumentCaptor<UserRepositoryCallback<SearchUserResponse>>().apply {
                    verify(repository).doSearch(eq(query), capture())
                    firstValue.onComplete()
                }

                verify(view).onSearchLoading(false)
            }
        }
    }
})