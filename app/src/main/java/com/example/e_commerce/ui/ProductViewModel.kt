package com.example.e_commerce.ui

import androidx.lifecycle.ViewModel
import com.example.e_commerce.Data.Product
import com.example.e_commerce.EcommerceApp

class ProductViewModel : ViewModel() {
    private val repository = EcommerceApp.repository
    val products = repository.products
    suspend fun insertProduct(product: Product) = repository.insertProduct(product)
    suspend fun updateProduct(product: Product) = repository.updateProduct(product)
}