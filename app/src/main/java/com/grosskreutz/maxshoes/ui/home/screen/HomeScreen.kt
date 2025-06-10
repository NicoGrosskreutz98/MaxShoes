package com.grosskreutz.maxshoes.ui.home.screen

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.grosskreutz.maxshoes.R
import com.grosskreutz.maxshoes.mock.mockAllProduct
import com.grosskreutz.maxshoes.ui.home.states.HomeUiState
import com.grosskreutz.maxshoes.ui.home.components.CardProductItem
import com.grosskreutz.maxshoes.ui.home.components.CategoryMenu
import com.grosskreutz.maxshoes.ui.home.components.ShearchTextField
import com.grosskreutz.maxshoes.ui.home.enum.getCategory
import com.grosskreutz.maxshoes.ui.home.events.HomeUiEvents
import com.grosskreutz.maxshoes.ui.home.viewmodel.HomeViewModel

@Composable
fun HomeScreen(
    modifier: Modifier = Modifier,
    states: HomeUiState = HomeUiState(),
    OnEvent: (HomeUiEvents) -> Unit = {}
) {

    var search by remember { mutableStateOf("") }

    Column(modifier = modifier
        .fillMaxSize()
        .background(Color.Transparent)
        .padding(top = 16.dp, bottom = 16.dp)) {

        Text(
            text = "Olá, ${states.usuario}",
            fontWeight = FontWeight.Bold,
            color = colorResource(R.color.product_price),
            fontSize = 14.sp,
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 16.dp),
            textAlign = TextAlign.Center
        )

        Row(
            modifier = Modifier
                .padding(16.dp)
                .fillMaxWidth()
                .height(50.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            ShearchTextField(
                modifier = Modifier.weight(1f),
                text = search
            ){
                search = it
            }

            Spacer(modifier = Modifier.width(8.dp))

            Box(
                modifier = Modifier
                    .size(50.dp)
                    .clip(RoundedCornerShape(16.dp))
                    .background(colorResource(R.color.orange))
                    .clickable {
                        OnEvent(HomeUiEvents.OnSearch(search))
                    },
                contentAlignment = Alignment.Center
            ) {
                Icon(
                    imageVector = Icons.Default.Search,
                    contentDescription = "Pesquisar",
                    tint = Color.White
                )
            }
        }

        Spacer(modifier = Modifier.height(16.dp))

        CategoryMenu(categories = states.categoryList, selected = states.selectedCategory.getCategory()){
            OnEvent(HomeUiEvents.OnChangeCategory(it))
        }

        Spacer(modifier = Modifier.height(16.dp))

        if (states.listProducts.isNotEmpty())
            LazyVerticalGrid(
                columns = GridCells.Fixed(2),
                verticalArrangement = Arrangement.spacedBy(16.dp),
                horizontalArrangement = Arrangement.spacedBy(16.dp),
                modifier = Modifier
                    .fillMaxSize()
                    .padding(start = 16.dp, end = 16.dp)
            ) {
                items(states.listProducts.size) { idx ->
                    val product = states.listProducts[idx]
                    CardProductItem(product = product){
                        OnEvent(HomeUiEvents.OnClick(it))
                    }
                }
            }
        else
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(top = 100.dp),
                contentAlignment = Alignment.TopCenter,
            ) {
                Text(
                    text = "Nada para exibir em ${states.selectedCategory.getCategory().lowercase()}",
                    color = colorResource(R.color.product_price),
                    fontSize = 20.sp,
                    textAlign = TextAlign.Center
                )
            }

    }
}

@Preview
@Composable
private fun HomeScreenPreview() {
    HomeScreen()
}