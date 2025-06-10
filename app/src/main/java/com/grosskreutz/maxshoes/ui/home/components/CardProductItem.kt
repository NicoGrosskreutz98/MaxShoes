package com.grosskreutz.maxshoes.ui.home.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.grosskreutz.maxshoes.R
import com.grosskreutz.maxshoes.model.Product

@Composable
fun CardProductItem(modifier: Modifier = Modifier,
                    product: Product,
                    OnClick: (Product) -> Unit = {}
) {
    Column(
        modifier = Modifier
            .width(168.dp)
            .wrapContentHeight()
            .background(Color.Transparent)
            .clickable {
                OnClick(product)
            }
    ) {
        Image(
            painter = painterResource(id = product.image!!),
            contentDescription = product.name,
            contentScale = ContentScale.FillWidth,
            modifier = Modifier
                .clip(RoundedCornerShape(16.dp))
                .fillMaxWidth()
                .height(180.dp)
                .padding(0.dp)
        )
        Text(
            text = product.name,
            fontWeight = FontWeight.SemiBold,
            fontSize = 10.sp,
            maxLines = 1,
            color = colorResource(R.color.gray),
            modifier = Modifier
                .padding(top = 16.dp, end = 2.dp)
                .fillMaxWidth()
        )
        Text(
            text = "R$ ${"%.2f".format(product.price)}",
            fontWeight = FontWeight.Bold,
            color = colorResource(R.color.product_price),
            fontSize = 14.sp,
            modifier = Modifier
                .padding(top = 8.dp)
                .fillMaxWidth()
        )
    }
}

@Preview
@Composable
private fun CardProductItemPreview() {
    val product = Product()
    product.name = "Chuteira Nike Tiempo 10"
    product.price = 245.99
    product.image = R.drawable.chuteira_tiempo

    CardProductItem(product = product)
}