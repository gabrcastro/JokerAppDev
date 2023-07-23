package com.example.jokerappdev.presentation

import com.example.jokerappdev.data.JokeCallback
import com.example.jokerappdev.data.JokeRemoteDataSource
import com.example.jokerappdev.model.Joke
import com.example.jokerappdev.view.JokeFragment

class JokePresenter(
    private val view: JokeFragment,
    private val datasource: JokeRemoteDataSource = JokeRemoteDataSource()
) : JokeCallback {

    fun findBy(category: String) {
        view.showProgress()
        datasource.findBy(category, this)
    }

    override fun onSuccess(response: Joke) {
        view.showJoke(response)
    }

    override fun onError(response: String) {
       view.showFailure(response)
    }

    override fun onComplete() {
       view.hideProgress()
    }
}