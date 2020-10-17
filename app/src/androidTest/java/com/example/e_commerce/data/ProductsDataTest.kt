package com.example.e_commerce.data

import android.util.Log
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.example.e_commerce.Data.ProductsDAO
import com.example.e_commerce.Data.Repository
import junit.framework.TestCase
import kotlinx.coroutines.runBlocking
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class ProductsDataTest : TestCase(){
    fun getProducts() = runBlocking {
        //val data = ProductsDAO.getProducts()
        //Log.d("myLog", data.toString())
        Unit
    }
}