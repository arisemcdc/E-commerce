package com.example.e_commerce.data

import android.content.Context
import android.util.Log
import androidx.room.Room
import androidx.test.core.app.ApplicationProvider
import androidx.test.espresso.matcher.ViewMatchers.assertThat
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.example.e_commerce.Data.Product
import com.example.e_commerce.Data.ProductsDAO
import com.example.e_commerce.Data.Repository
import com.example.e_commerce.Data.RoomDB
import com.example.e_commerce.EcommerceApp
import junit.framework.TestCase
import kotlinx.coroutines.runBlocking
import org.hamcrest.CoreMatchers.equalTo
import org.junit.After
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import java.io.IOException

/*@RunWith(AndroidJUnit4::class)
class ProductsDataTest : TestCase(){
    fun getProducts() = runBlocking {
        val data = EcommerceApp.repository.localDB.productsDAO().getProducts()
        Log.d("myLog", data.toString())
        Unit
    }
}*/
@RunWith(AndroidJUnit4::class)
class ProductsDataTest {
    private lateinit var productsDAO: ProductsDAO
    private lateinit var db: RoomDB

    @Before
    fun createDb() {
        val context = ApplicationProvider.getApplicationContext<Context>()
        val db = Room.inMemoryDatabaseBuilder(
            context, RoomDB::class.java).build()
        productsDAO = db.productsDAO()
    }
    @After
    @Throws(IOException::class)
    fun closeDb() {
        db.close()
    }

    @Test
    @Throws(Exception::class)
    fun writeProductAndReadInList() = runBlocking {
        val product = Product("ddd", 120.00, 12, "2")
        productsDAO.insert(product)
        val products = productsDAO.getProductById("2")
        assertThat(products[0], equalTo(product))
    }
}
