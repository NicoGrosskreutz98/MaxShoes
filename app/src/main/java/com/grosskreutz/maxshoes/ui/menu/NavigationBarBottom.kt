package com.grosskreutz.maxshoes.ui.menu

import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.grosskreutz.maxshoes.R
import com.grosskreutz.maxshoes.activities.menu.menu_itens.BottomNavItem

@Composable
fun NavigationBarBottom(
    modifier: Modifier = Modifier,
    navHostController: NavHostController? = null,
    current: String? = ""
) {

    NavigationBar(
        modifier = modifier
            .height(77.dp)
            .padding(8.dp) ,
        containerColor = Color.Transparent
    ) {
        BottomNavItem.menuItens.forEach { menu ->
                val selected = (current ?: "") == menu.route

                NavigationBarItem(
                    modifier = Modifier
                        .height(45.dp)
                        .width(74.dp)
                        .padding(8.dp),
                    selected = false,
                    onClick = {
                        navHostController!!.navigate(menu.route)
                    },
                    icon = {
                        Icon(
                            modifier = Modifier
                                .width(74.dp)
                                .height(45.dp),
                            painter = painterResource(menu.icon),
                            contentDescription = menu.label,
                            tint = if (selected) colorResource(R.color.nav_menu_selected)
                            else colorResource(R.color.nav_menu_unselected)
                        )
                    },
                    label = {
                        Text(menu.label ,
                            color = if (selected) colorResource(R.color.nav_menu_selected)
                            else colorResource(R.color.nav_menu_unselected)
                        )
                    }
                )
        }
    }
}

@Preview
@Composable
private fun NavigationBarBottomPreview() {
    NavigationBarBottom()
}