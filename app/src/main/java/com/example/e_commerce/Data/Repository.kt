package com.example.e_commerce.Data

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class Repository(val localDB:RoomDB) {

    /*private val _products = MutableLiveData<List<Product>>()
    val products: LiveData<List<Product>> = _products*/

    val products = localDB.productsDAO().observeProducts()
    suspend fun insertProduct(product: Product) = localDB.productsDAO().insert(product)
    /*fun insertProduct(product: Product) {
        GlobalScope.launch {
            localDB.productsDAO().insert(product)
        }
    }*/
    suspend fun deleteProduct(product: Product) = localDB.productsDAO().delete(product)
    suspend fun updateProduct(product: Product) = localDB.productsDAO().update(product)
}