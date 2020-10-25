package com.example.e_commerce.ui.BackEnd

import androidx.lifecycle.ViewModel
import com.example.e_commerce.Data.Product
import com.example.e_commerce.EcommerceApp

class BackEndViewModel : ViewModel() {
    private val repository = EcommerceApp.repository
    /*private val _products = MutableLiveData<List<Product>>()
    val products: LiveData<List<Product>> = _products*/
    val products = repository.products
    suspend fun insertProduct(product: Product) = repository.insertProduct(product)
    suspend fun deleteProduct(product: Product) = repository.deleteProduct(product)
    suspend fun updateProduct(product: Product) = repository.updateProduct(product)
}