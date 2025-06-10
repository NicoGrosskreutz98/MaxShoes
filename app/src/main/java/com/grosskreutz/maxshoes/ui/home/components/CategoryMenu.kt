package com.grosskreutz.maxshoes.ui.home.components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
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

@Composable
fun CategoryMenu(modifier: Modifier = Modifier,
                 categories: List<String> = emptyList(),
                 selected: String = "Todos",
                 OnChangeCategory : (String) -> Unit = {}
) {

    var selectedCategory by remember { mutableStateOf(selected) }

    LazyRow(
        modifier = Modifier
            .height(31.dp),
        horizontalArrangement = Arrangement.spacedBy(8.dp),
        contentPadding = PaddingValues(horizontal = 16.dp)
    ) {
        items(categories.size) { idx ->
            val isSelected = categories[idx] == selectedCategory

            Box(
                modifier = Modifier
                    .background(
                        color = if (isSelected) colorResource(R.color.orange) else Color.Transparent,
                        shape = RoundedCornerShape(12.dp))
                    .clip(RoundedCornerShape(12.dp))
                    .border(border = BorderStroke(
                        1.dp,
                        if (isSelected) colorResource(R.color.orange) else colorResource(R.color.unselected_category)),
                        shape = RoundedCornerShape(12.dp)
                    )
                    .clickable {
                        selectedCategory = categories[idx]
                        OnChangeCategory(selectedCategory)
                    }
            ) {
                Text(modifier = Modifier
                        .padding(horizontal = 16.dp, vertical = 4.dp),
                    text = categories[idx],
                    color = if (isSelected) Color.White else colorResource(R.color.gray),
                    fontWeight = if (isSelected) FontWeight.Bold else FontWeight.Normal,
                    fontSize = 10.sp
                )
            }
        }
    }
}

@Preview
@Composable
private fun CategoryMenuPreview() {
    val categories = listOf("Todos", "Tênis", "Botas", "Chuteiras", "Sapatênis")
    CategoryMenu(categories = categories)
}