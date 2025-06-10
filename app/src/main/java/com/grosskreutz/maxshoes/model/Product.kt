package com.grosskreutz.maxshoes.model

import java.io.Serializable


data class Product(
    var name: String = "",
    var description: String = "",
    var category: String = "Todos",
    var price: Double = 0.0,
    var image: Int? = null
) : Serializable