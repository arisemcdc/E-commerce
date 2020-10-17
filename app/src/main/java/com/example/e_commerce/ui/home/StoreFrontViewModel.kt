package com.example.e_commerce.ui.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.e_commerce.Data.Product
import com.example.e_commerce.EcommerceApp

class StoreFrontViewModel : ViewModel() {
    private val repository = EcommerceApp.repository
    val products = repository.products
    suspend fun deleteProduct(product: Product) = repository.deleteProduct(product)
}