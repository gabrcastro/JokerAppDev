package com.example.jokerappdev.data

interface ListCategoryCallback {
    fun onSuccess(response: List<String>)
    fun onError(response: String) {}
    fun onComplete()
}