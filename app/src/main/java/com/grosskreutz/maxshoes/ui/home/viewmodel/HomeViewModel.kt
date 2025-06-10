package com.grosskreutz.maxshoes.ui.home.viewmodel

import android.content.Intent
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.grosskreutz.maxshoes.model.Product
import com.grosskreutz.maxshoes.ui.home.enum.getEnum
import com.grosskreutz.maxshoes.ui.home.events.HomeUiEvents
import com.grosskreutz.maxshoes.ui.home.states.HomeUiState
import com.grosskreutz.maxshoes.activities.detalhes.DetalhesProdutoActivity
import com.grosskreutz.maxshoes.dao.ProductsRepository
import com.grosskreutz.maxshoes.ui.home.enum.CategoryEnum
import com.grosskreutz.maxshoes.ui.home.enum.getCategory
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class HomeViewModel(
    private val packageName: String,
    private val repository: ProductsRepository
): ViewModel() {

    private val _uiState = MutableStateFlow(HomeUiState())
    val uiState: StateFlow<HomeUiState> = _uiState.asStateFlow()

    private val _startActivityEvent = MutableSharedFlow<Intent>()
    val startActivityEvent = _startActivityEvent.asSharedFlow()

    init {
        initStates()
    }


    fun onEvent(event: HomeUiEvents){
        when(event){
            is HomeUiEvents.OnChangeCategory -> changeCategory(event.category)
            is HomeUiEvents.OnClick -> openProduct(event.product)
            is HomeUiEvents.OnSearch -> search(event.search)
        }
    }

    private fun changeCategory(category: String){
        var categoryEnum = category.getEnum()

        viewModelScope.launch {
            _uiState.update { states ->
                states.copy(
                    selectedCategory = categoryEnum,
                    listProducts = repository.getProductsFiltro(categoryEnum)
                )
            }
        }
    }

    private fun openProduct(product: Product){
        viewModelScope.launch {
            val newIntent =
                Intent().apply {
                    setClassName(packageName, DetalhesProdutoActivity::class.java.name)
                }
            newIntent.putExtra("produto", product)
            _startActivityEvent.emit(newIntent)
        }
    }

    private fun search(search: String){
        viewModelScope.launch {
            _uiState.update { states ->
                states.copy(
                    listProducts = repository.getProductsFiltro(search, _uiState.value.selectedCategory)
                )
            }
        }
    }

    private fun getCategoryList() : List<String> {
        return listOf("Todos", "Tênis", "Botas", "Chuteiras", "Sapatênis")
    }

    private fun initStates(){
        viewModelScope.launch {
            _uiState.update { states ->
                states.copy(
                    categoryList = getCategoryList(),
                    usuario = repository.getUsuario(),
                    listProducts = repository.getProducts()
                )
            }
        }
    }
}