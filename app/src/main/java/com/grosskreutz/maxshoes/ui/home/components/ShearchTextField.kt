package com.grosskreutz.maxshoes.ui.home.components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.grosskreutz.maxshoes.R

@Composable
fun ShearchTextField(
    modifier: Modifier = Modifier,
    text: String = "",
    onTextChange : (String) -> Unit = {}
) {

    var value by remember { mutableStateOf(text) }

    BasicTextField(
        modifier = modifier
            .fillMaxWidth()
            .fillMaxHeight()
            .background(Color.Transparent, shape = RoundedCornerShape(16.dp))
            .border(border = BorderStroke(1.dp, colorResource(R.color.search_border)), shape = RoundedCornerShape(16.dp)),
        value = value,
        onValueChange = {
            value = it
            onTextChange(value)
        },
        textStyle = TextStyle.Default.copy(
            fontSize = 15.sp,
            textAlign = TextAlign.Start,
            fontWeight = FontWeight(400),
            lineHeight = 16.5.sp,
            color = Color.Black
        ),
        keyboardOptions = KeyboardOptions(
            keyboardType = KeyboardType.Text,
            imeAction = ImeAction.Done
        ),
        singleLine = true,
        maxLines = 1,
        cursorBrush = SolidColor(Color.Black),
        decorationBox = { innerTextField ->
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 19.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {

                Spacer(modifier = Modifier.width(6.dp))
                Box {
                    if (value.isEmpty()) {
                        Text(
                            text = "Pesquisar",
                            fontSize = 15.sp,
                            textAlign = TextAlign.Center,
                            fontWeight = FontWeight(400),
                            lineHeight = 16.5.sp,
                            color = colorResource(R.color.gray)
                        )
                    }
                    innerTextField()
                }
            }
        }
    )
}

@Preview
@Composable
private fun ShearchTextFieldPreview() {
    ShearchTextField()
}