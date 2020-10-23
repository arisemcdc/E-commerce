package com.example.e_commerce.ui

import androidx.lifecycle.*
import com.example.e_commerce.Data.Product
import com.example.e_commerce.EcommerceApp
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class ProductViewModel : ViewModel() {
   /* val name:String = "",
    val price: Double? = null,
    val amount: Int? = null,*/
    // Two-way databinding, exposing MutableLiveData
    //val name = MutableLiveData<String>()
    // Two-way databinding, exposing MutableLiveData
    //val price = MutableLiveData<Double>()
    // Two-way databinding, exposing MutableLiveData
    //val amount = MutableLiveData<Int>()
    private val repository = EcommerceApp.repository
    private var _productId: String? = null
    val products = repository.products
    val product: LiveData<Product> = Transformations.map(products){ products->
        products.find {_productId == it.id}!!
    }
    val name = Transformations.map(product){
        it.name.toString()
    }
    val price = Transformations.map(product){
        it.price.toString()
    }
    val amount = Transformations.map(product){
        it.amount.toString()
    }
    suspend fun insertProduct(product: Product) = repository.insertProduct(product)
    suspend fun updateProduct(product: Product) = repository.updateProduct(product)
    fun setProductId(id: String?){
        _productId = id
    }
    fun saveChanges(){
        if (_productId == null) {
            viewModelScope.launch {
                insertProduct(product.value!!)
            }
        }
        else {
            viewModelScope.launch {
                updateProduct(product.value!!)
            }
        }
    }
}