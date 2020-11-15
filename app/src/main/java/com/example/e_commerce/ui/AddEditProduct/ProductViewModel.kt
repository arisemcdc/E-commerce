package com.example.e_commerce.ui.AddEditProduct

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.e_commerce.Data.Product
import com.example.e_commerce.EcommerceApp
import com.example.e_commerce.R
import com.example.e_commerce.Util.Event
import kotlinx.coroutines.launch


class ProductViewModel : ViewModel() {
    // Two-way databinding, exposing MutableLiveData
    val name = MutableLiveData<String>()
    // Two-way databinding, exposing MutableLiveData
    val price = MutableLiveData<String>()
    // Two-way databinding, exposing MutableLiveData
    val amount = MutableLiveData<String>()
    private val repository = EcommerceApp.repository
    private var _productId: String? = null
    private val _snackbarText = MutableLiveData<Event<Int>>()
    val snackbarText: LiveData<Event<Int>> = _snackbarText
    val products = repository.products

    suspend fun insertProduct(product: Product) = repository.insertProduct(product)
    suspend fun updateProduct(product: Product) = repository.updateProduct(product)
    fun setProductId(id: String?){
        _productId = id
        if (id != null){
            val product = products.value?.find {_productId == it.id}
            product?.let{
                setProductsValues(it)
            }
        }
    }

    private fun setProductsValues(product: Product){
        name.value = product.name
        price.value = product.price.toString()
        amount.value = product.amount.toString()
    }

    fun saveChanges(){
        val nameValue = name.value
        val priceValue = price.value?.toDoubleOrNull()
        val amountValue = amount.value?.toIntOrNull()

        if (nameValue ==null || priceValue == null || amountValue == null ){
            _snackbarText.value = Event(R.string.empty_task_message)
            return
        }

        if (_productId == null) {
            val product = Product(nameValue, priceValue, amountValue)
            viewModelScope.launch {
                insertProduct(product)
            }
        }
        else {
            viewModelScope.launch {
                val product = Product(nameValue, priceValue, amountValue, _productId!!)
                updateProduct(product)
            }
        }
        
    }
}