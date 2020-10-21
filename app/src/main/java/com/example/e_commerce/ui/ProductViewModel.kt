package com.example.e_commerce.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.Transformations
import androidx.lifecycle.ViewModel
import com.example.e_commerce.Data.Product
import com.example.e_commerce.EcommerceApp

class ProductViewModel : ViewModel() {
    private val repository = EcommerceApp.repository
    private var _productId: String? = null
    val products = repository.products
    val product: LiveData<Product> = Transformations.map(products){ products->
        products.find {_productId == it.id}!!
    }
    suspend fun insertProduct(product: Product) = repository.insertProduct(product)
    suspend fun updateProduct(product: Product) = repository.updateProduct(product)
    fun setProductId(id: String?){
        _productId = id
    }
}