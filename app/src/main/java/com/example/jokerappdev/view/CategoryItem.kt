package com.example.jokerappdev.view

import android.view.View
import android.widget.LinearLayout
import android.widget.TextView
import com.example.jokerappdev.R
import com.example.jokerappdev.model.Category
import com.xwray.groupie.GroupieViewHolder
import com.xwray.groupie.Item

class CategoryItem( val category: Category ) : Item<CategoryItem.CategoryViewHolder>() {

    class CategoryViewHolder(view: View) : GroupieViewHolder(view)

    // criar uma lista - obrigatorio
    override fun createViewHolder(itemView: View) = CategoryViewHolder(itemView)

    // metodo que tera a celular em determinada posicao
    override fun bind(viewHolder: CategoryViewHolder, position: Int) {
        viewHolder.itemView.findViewById<TextView>(R.id.txt_category).text = category.name
        viewHolder.itemView.findViewById<LinearLayout>(R.id.container_category).setBackgroundColor(category.bgColor.toInt())
    }

    // retornar o layout especifico da minha celula
    override fun getLayout() =  R.layout.item_category
}