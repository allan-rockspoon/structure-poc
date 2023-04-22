package com.example.poc.search.data

import kotlinx.coroutines.flow.Flow

interface ProductLocalDataSource {

    val products: Flow<List<Product>>

    suspend fun list(
        query: String? = null,
        pageSize: Int? = null,
        cursorId: Long = 0
    ): List<Product>
}