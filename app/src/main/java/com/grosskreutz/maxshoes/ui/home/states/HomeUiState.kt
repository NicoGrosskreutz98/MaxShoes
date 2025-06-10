package com.grosskreutz.maxshoes.ui.home.states

import com.grosskreutz.maxshoes.mock.mockAllProduct
import com.grosskreutz.maxshoes.model.Product
import com.grosskreutz.maxshoes.ui.home.enum.CategoryEnum

data class HomeUiState (
    val listProducts: List<Product> = mockAllProduct,
    val selectedCategory: CategoryEnum = CategoryEnum.TODOS,
    val categoryList: List<String> = emptyList(),
    val usuario: String = ""
)