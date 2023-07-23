package com.example.jokerappdev.data

import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class CategoryRemoteDataSource {
    fun findAllCategories(callback: ListCategoryCallback) {
        HTTPClient.retrofit()
            .create(ChuckNorrisAPI::class.java) // vai ler essa interface e criara a classe concreta a partir dessa interface
            .findAllCategories()
            .enqueue(object : Callback<List<String>> {
                override fun onResponse(
                    call: Call<List<String>>,
                    response: Response<List<String>>
                ) {
                    if (response.isSuccessful) {
                        val categories = response.body() // nossa lista de categorias
                        callback.onSuccess(categories ?: emptyList())
                    } else {
                        // quando o server devolver status de erro menor que 500. Erros da sua chamada e nao servidor
                        val error = response.errorBody()?.string()
                        callback.onError(error ?: "Erro desconhecido")
                    }

                    callback.onComplete()
                }

                override fun onFailure(call: Call<List<String>>, t: Throwable) {
                    callback.onError(t.message ?: "Erro interno")
                    callback.onComplete()
                }

            })
    }
}