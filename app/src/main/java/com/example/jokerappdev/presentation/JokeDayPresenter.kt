package com.example.jokerappdev.presentation

import com.example.jokerappdev.data.JokeCallback
import com.example.jokerappdev.data.JokeRemoteDataSource
import com.example.jokerappdev.model.Joke
import com.example.jokerappdev.view.JokeDayFragment
import com.example.jokerappdev.view.JokeFragment

class JokeDayPresenter(
    private val view: JokeDayFragment,
    private val datasource: JokeRemoteDataSource = JokeRemoteDataSource()
) : JokeCallback {

    fun findOne() {
        view.showProgress()
        datasource.findOne(this)
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