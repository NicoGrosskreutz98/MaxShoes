package com.grosskreutz.maxshoes.activities.menu.menu_itens

import com.grosskreutz.maxshoes.R

sealed class BottomNavItem(val route: String, val icon: Int, val label: String) {
    object Home : BottomNavItem("home", R.drawable.home, "Home")
    object Carrinho : BottomNavItem("carrinho", R.drawable.carrinho, "Carrinho")
    object Perfil : BottomNavItem("perfil", R.drawable.perfil, "Perfil")

    companion object{
        val menuItens = listOf(Home, Carrinho, Perfil)
    }
}