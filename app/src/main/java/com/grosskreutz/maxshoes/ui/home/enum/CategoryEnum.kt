package com.grosskreutz.maxshoes.ui.home.enum

enum class CategoryEnum {
    TODOS,
    TENIS,
    BOTAS,
    CHUTEIRAS,
    SAPATENIS
}

fun CategoryEnum.getCategory() : String {
    return when(this){
        CategoryEnum.TODOS -> "Todos"
        CategoryEnum.TENIS -> "Tênis"
        CategoryEnum.BOTAS -> "Botas"
        CategoryEnum.CHUTEIRAS -> "Chuteiras"
        CategoryEnum.SAPATENIS -> "Sapatênis"
    }
}

fun String.getEnum() : CategoryEnum {
    return when(this){
        "Todos" -> CategoryEnum.TODOS
        "Tênis" -> CategoryEnum.TENIS
        "Botas" -> CategoryEnum.BOTAS
        "Chuteiras" -> CategoryEnum.CHUTEIRAS
        "Sapatênis" -> CategoryEnum.SAPATENIS
        else -> CategoryEnum.TODOS
    }
}

