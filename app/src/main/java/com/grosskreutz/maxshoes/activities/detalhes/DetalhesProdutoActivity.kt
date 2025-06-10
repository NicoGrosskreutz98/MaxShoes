package com.grosskreutz.maxshoes.activities.detalhes

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.grosskreutz.maxshoes.model.Product
import com.grosskreutz.maxshoes.ui.detalhes.ProdutoDetalheScreen
import com.grosskreutz.maxshoes.ui.theme.MaxShoesTheme

class DetalhesProdutoActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val produto: Product? = intent.getSerializableExtra("produto") as Product?

        setContent {
            MaxShoesTheme {
                ProdutoDetalheScreen(produto!!)
            }
        }
    }
}