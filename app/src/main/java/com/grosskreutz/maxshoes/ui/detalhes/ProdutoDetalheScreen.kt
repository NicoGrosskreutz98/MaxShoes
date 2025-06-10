package com.grosskreutz.maxshoes.ui.detalhes

import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
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
fun ProdutoDetalheScreen(produto: Product) {
    Scaffold(
        bottomBar = {
            BottomAppBar(
                containerColor = Color.Transparent,
                contentPadding = PaddingValues(16.dp)
            ) {
                Button(
                    onClick = {

                    },
                    modifier = Modifier
                        .weight(1f)
                        .height(53.dp),
                    shape = RoundedCornerShape(20.dp),
                    colors = ButtonDefaults.buttonColors(containerColor = colorResource(R.color.nav_menu_selected))
                ) {
                    Text("Adicionar no carrinho", color = Color.White)
                }

                Spacer(Modifier.width(8.dp))

                Box(
                    modifier = Modifier
                        .size(53.dp)
                        .clip(RoundedCornerShape(20.dp))
                        .border(1.dp, colorResource(R.color.nav_menu_selected), RoundedCornerShape(20.dp)),
                    contentAlignment = Alignment.Center
                ) {
                    Icon(
                        modifier = Modifier
                            .width(24.dp)
                            .height(24.dp),
                        painter = painterResource(R.drawable.carrinho),
                        contentDescription = "carrinho",
                        tint = colorResource(R.color.nav_menu_selected)
                    )
                }
            }
        }
    ) { padding ->
        Column(
            modifier = Modifier
                .padding(padding)
                .verticalScroll(rememberScrollState())
                .fillMaxSize()
        ) {
            Image(
                painter = painterResource(id = produto.image!!),
                contentDescription = produto.name,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(398.dp),
                contentScale = ContentScale.FillWidth
            )

            Column(modifier = Modifier.padding(16.dp)) {
                Row(verticalAlignment = Alignment.CenterVertically) {
                    Text(
                        text = produto.name,
                        fontWeight = FontWeight.Bold,
                        color = colorResource(R.color.product_price),
                        fontSize = 18.sp,
                        modifier = Modifier.weight(1f)
                    )
                    Icon(
                        imageVector = Icons.Default.FavoriteBorder,
                        contentDescription = null,
                        tint = Color.Gray
                    )
                }

                Spacer(Modifier.height(4.dp))

                Row(verticalAlignment = Alignment.CenterVertically) {
                    repeat(5) {
                        Icon(Icons.Default.Star, contentDescription = null, tint = Color(0xFFFFC107), modifier = Modifier.size(14.dp))
                    }
                    Spacer(modifier = Modifier.width(4.dp))
                    Text("(10)", fontSize = 10.sp, color = colorResource(R.color.avaliacoes_e_descricao))
                }

                Spacer(Modifier.height(8.dp))

                Text(
                    text = produto.description,
                    fontSize = 12.sp,
                    color = colorResource(R.color.avaliacoes_e_descricao)
                )

                Spacer(Modifier.height(16.dp))

                Text(
                    text = "R$ ${"%.2f".format(produto.price)}",
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Bold,
                    color = colorResource(R.color.product_price)
                )
            }
        }
    }
}

@Preview
@Composable
private fun ProdutoDetalheScreenPreview() {
    val product = Product()
    product.name = "Chuteira Nike Tiempo 10"
    product.price = 245.99
    product.image = R.drawable.chuteira_tiempo
    product.description = "Até mesmo as Lendas descobrem formas de evoluir. Quer esteja começando ou apenas jogando por diversão, a mais recente iteração dos calçados Club colocam você em campo sem comprometer a qualidade. Material sintéticom se molda ao seu pé e não estica demais, dando a você melhor controle. Mais leve e elegante do que qualquer outro Tiempo até o momento, o Legend 10 é para qualquer posição no campo, seja enviando um passe preciso pela defesa ou voltando para impedir uma fuga.Toque AmpliadoMaterial sintético moldado imita uma sensação acolchoada para melhorar o toque.Ajuste Natural, AdequadoMaterial sintético se molda ao seu pé e proporciona melhor controle, ajudando a mantê-lo confortável para o seu jogo.Tração para o GramadoO padrão do solado oferece tração para superfícies de gramado.Detalhes do Produto-Para uso em superfícies curtas e sintéticas.-Palmilha acolchoada"

    ProdutoDetalheScreen(product)
}