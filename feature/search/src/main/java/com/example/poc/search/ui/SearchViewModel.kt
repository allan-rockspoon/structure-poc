package com.example.poc.search.ui

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.cachedIn
import com.example.poc.search.data.ProductRepository

internal class SearchViewModel(
    private val productRepository: ProductRepository = ProductRepository()
) : ViewModel() {

    var uiState by mutableStateOf(SearchUiState())
        private set

    init {
        loadProducts()
    }

    /**
     * Updates the UI state with a paging data of products for lazy loading.
     */
    fun loadProducts(query: String = "", pageSize: Int = 10) {
        uiState = try {
            uiState.copy(
                products = productRepository.getPagingData(
                    query = query,
                    pageSize = pageSize
                ).cachedIn(viewModelScope),
                isLoading = false
            )
        } catch (e: Exception) {
            uiState.copy(
                error = e,
                isLoading = false
            )
        }
    }
}