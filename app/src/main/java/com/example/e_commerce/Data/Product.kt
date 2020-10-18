package com.example.e_commerce.Data

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.*
@Entity(tableName = "products")
data class Product (
    @PrimaryKey
    val id:String = UUID.randomUUID().toString(),
    //var id: String = "",
    val name:String = "",
    val price: Double? = null,
    val amount: Int? = null
)
//val products = arrayListOf<Product>()

    /*val product1 = Product("Apple iPod touch 5 32Gb", 8888.0, 5)
    val product2 = Product("Samsung Galaxy S Duos S7562", 7230.0, 2)
    val product3 = Product("Canon EOS 600D Kit", 15659.0, 4)
    val product4 = Product("Samsung Galaxy Tab 2 10.1 P5100 16Gb", 13290.0, 9)
    val product5 = Product("PocketBook Touch", 5917.0, 5)
    val product6 = Product("Samsung Galaxy Note II 16Gb", 17049.50, 2)
    val product7 = Product("Nikon D3100 Kit", 12190.0, 4)
    val product8 = Product("Canon EOS 1100D Kit", 10985.0, 2)
    val product9 = Product("Sony Xperia acro S", 11800.99, 1)
    val product10 = Product("Lenovo G580", 8922.0, 1)*/
/*fun fillExampleProductsList(){
    products.add(product1)
    products.add(product2)
    products.add(product3)
    products.add(product4)
    products.add(product5)
    products.add(product6)
    products.add(product7)
    products.add(product8)
    products.add(product9)
    products.add(product10)
}*/
