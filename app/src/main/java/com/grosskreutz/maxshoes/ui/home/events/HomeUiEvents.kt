package com.grosskreutz.maxshoes.ui.home.events

import com.grosskreutz.maxshoes.model.Product

sealed class HomeUiEvents {
    data class OnChangeCategory(val category: String) : HomeUiEvents()
    data class OnSearch(val search: String) : HomeUiEvents()
    data class OnClick(val product: Product) : HomeUiEvents()
}