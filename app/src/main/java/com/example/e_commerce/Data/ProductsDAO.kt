package com.example.e_commerce.Data

import androidx.lifecycle.LiveData
import androidx.room.*

@Dao

interface ProductsDAO{
    @Query("SELECT * FROM products")
    fun observeProducts(): LiveData<List<Product>>
    @Query("SELECT * FROM products")
    suspend fun getProducts(): List<Product>
    @Insert
    suspend fun insert(product: Product)
    @Update
    suspend fun update(product: Product)
    @Delete
    suspend fun delete(product: Product)
}