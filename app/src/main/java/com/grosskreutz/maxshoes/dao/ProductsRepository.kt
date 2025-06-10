package com.grosskreutz.maxshoes.dao

import com.grosskreutz.maxshoes.mock.mockAllProduct
import com.grosskreutz.maxshoes.model.Product
import com.grosskreutz.maxshoes.ui.home.enum.CategoryEnum
import com.grosskreutz.maxshoes.ui.home.enum.getCategory

class ProductsRepository {
    fun getProducts(): List<Product> = mockAllProduct

    fun getProductsFiltro(search: String, categoryEnum: CategoryEnum): List<Product> {
        var products =  if (search.isNotEmpty()) mockAllProduct.filter {
            it.name.lowercase().contains(search.lowercase())
        } else
            mockAllProduct

        if (categoryEnum != CategoryEnum.TODOS)
            products = products.filter {
                it.category == categoryEnum.getCategory()
            }

        return products
    }

    fun getProductsFiltro(categoryEnum: CategoryEnum): List<Product> {
        val products = if (categoryEnum == CategoryEnum.TODOS)
            mockAllProduct
        else mockAllProduct.filter {
            it.category == categoryEnum.getCategory()
        }

        return products
    }

    fun getUsuario(): String = "Cleyton"
}