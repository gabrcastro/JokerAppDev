package com.example.jokerappdev.data

import com.example.jokerappdev.model.Joke
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class JokeRemoteDataSource {
    fun findBy(categoryName: String, callback: JokeCallback) {
        HTTPClient.retrofit()
            .create(ChuckNorrisAPI::class.java)
            .findBy(categoryName)
            .enqueue(object : Callback<Joke> {

                override fun onResponse(
                    call: Call<Joke>,
                    response: Response<Joke>
                ) {
                    if (response.isSuccessful) {
                        val joke = response.body()
                        callback.onSuccess(joke ?: throw RuntimeException("Piada nao encontrada"))
                    } else {
                        val error = response.errorBody()?.string()
                        callback.onError(error ?: "Erro desconhecido")
                    }

                    callback.onComplete()
                }

                override fun onFailure(call: Call<Joke>, t: Throwable) {
                    callback.onError(t.message ?: "Erro interno")
                    callback.onComplete()
                }
            })
    }

    fun findOne(callback: JokeCallback) {
        HTTPClient.retrofit()
            .create(ChuckNorrisAPI::class.java)
            .findOne()
            .enqueue(object : Callback<Joke> {

                override fun onResponse(
                    call: Call<Joke>,
                    response: Response<Joke>
                ) {
                    if (response.isSuccessful) {
                        val joke = response.body()
                        callback.onSuccess(joke ?: throw RuntimeException("Piada nao encontrada"))
                    } else {
                        val error = response.errorBody()?.string()
                        callback.onError(error ?: "Erro desconhecido")
                    }

                    callback.onComplete()
                }

                override fun onFailure(call: Call<Joke>, t: Throwable) {
                    callback.onError(t.message ?: "Erro interno")
                    callback.onComplete()
                }
            })
    }
}