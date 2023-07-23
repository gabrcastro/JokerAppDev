package com.example.jokerappdev.presentation

import android.graphics.Color
import com.example.jokerappdev.data.CategoryRemoteDataSource
import com.example.jokerappdev.data.ListCategoryCallback
import com.example.jokerappdev.model.Category
import com.example.jokerappdev.view.HomeFragment

class HomePresent(
    private val view: HomeFragment,
    private val dataSource: CategoryRemoteDataSource = CategoryRemoteDataSource()
) : ListCategoryCallback {

    fun findAllCategories() {
        view.showProgress()
        dataSource.findAllCategories(this)
    }

    override fun onSuccess(response: List<String>) {
        val start = 40
        val end = 190
        val difference = ( end - start ) / response.size
        val categories = response.mapIndexed { index, s ->
            val hsv = floatArrayOf(
                start + (difference * index).toFloat(), // H = matiz,
                100.0f, // S = saturacao,
                100.0f, // V = valor
            )

            Category(s, Color.HSVToColor(hsv).toLong() )
        }

        view.showCategories(categories)
    }

    override fun onError(response: String) {
        view.showFailure(response)
    }

    override fun onComplete() {
        view.hideProgress()
    }

}