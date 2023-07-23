package com.example.jokerappdev.data

import com.example.jokerappdev.model.Joke

interface JokeCallback {

    fun onSuccess(response: Joke)
    fun onError(response: String)
    fun onComplete()
}