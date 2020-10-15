package com.example.e_commerce.Data

import androidx.room.Database
import androidx.room.RoomDatabase
@Database(entities = [Product::class], version = 1)
abstract class RoomDB : RoomDatabase(){
    abstract fun productsDAO() :ProductsDAO
}