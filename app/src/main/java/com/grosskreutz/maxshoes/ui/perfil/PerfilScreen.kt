package com.grosskreutz.maxshoes.ui.perfil

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import com.grosskreutz.maxshoes.R

@Composable
fun PerfilScreen(modifier: Modifier = Modifier) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Transparent),
        contentAlignment = Alignment.Center
    ){
        Text(
            text = "Perfil",
            color = colorResource(R.color.product_price),
            fontSize = 40.sp,
            textAlign = TextAlign.Center
        )
    }
}

@Preview
@Composable
private fun PerfilScreenPreview() {
    PerfilScreen()
}