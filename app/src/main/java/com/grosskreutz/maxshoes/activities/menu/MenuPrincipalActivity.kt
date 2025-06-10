package com.grosskreutz.maxshoes.activities.menu

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.lifecycleScope
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.grosskreutz.maxshoes.activities.menu.menu_itens.BottomNavItem
import com.grosskreutz.maxshoes.ui.carrinho.CarrinhoScreen
import com.grosskreutz.maxshoes.ui.home.events.HomeUiEvents
import com.grosskreutz.maxshoes.ui.home.screen.HomeScreen
import com.grosskreutz.maxshoes.ui.home.states.HomeUiState
import com.grosskreutz.maxshoes.ui.home.viewmodel.HomeViewModel
import com.grosskreutz.maxshoes.ui.menu.NavigationBarBottom
import com.grosskreutz.maxshoes.ui.perfil.PerfilScreen
import com.grosskreutz.maxshoes.ui.theme.MaxShoesTheme
import kotlinx.coroutines.launch
import org.koin.androidx.viewmodel.ext.android.getViewModel

class MenuPrincipalActivity : ComponentActivity() {
    @SuppressLint("CoroutineCreationDuringComposition")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            val homeViewModel: HomeViewModel = getViewModel()
            val uiState by homeViewModel.uiState.collectAsState()

            MaxShoesTheme {
                MainScrean(
                    uiStatesHomeScrean = uiState,
                    onEventsHomeUiEvents = homeViewModel::onEvent
                )
            }

            lifecycleScope.launch {
                homeViewModel.startActivityEvent.collect { intent ->
                    startActivity(intent)
                }
            }
        }
    }

    override fun onBackPressed() {
        super.onBackPressed()
        finish()
    }
}

@Composable
fun MainScrean(
    uiStatesHomeScrean: HomeUiState = HomeUiState(),
    onEventsHomeUiEvents: (HomeUiEvents) -> Unit = {}
) {
    val navController = rememberNavController()
    val currentBackStack by navController.currentBackStackEntryAsState()
    val currentDestination = currentBackStack?.destination?.route

    Scaffold(
        bottomBar = {
            NavigationBarBottom(navHostController = navController, current = currentDestination)
        }
    ) { paddingValues ->
        NavHost(
            navController = navController,
            startDestination = BottomNavItem.Home.route,
            modifier = Modifier.padding(paddingValues)
        ) {
            composable(BottomNavItem.Home.route) {
                HomeScreen(
                    states = uiStatesHomeScrean,
                    OnEvent = onEventsHomeUiEvents
                )
            }
            composable(BottomNavItem.Carrinho.route) { CarrinhoScreen() }
            composable(BottomNavItem.Perfil.route) { PerfilScreen() }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun MainScreanPreview() {
    MaxShoesTheme {
        MainScrean()
    }
}