package com.example.e_commerce

import android.app.Application
import androidx.room.Room
import com.example.e_commerce.Data.Repository
import com.example.e_commerce.Data.RoomDB

class EcommerceApp: Application() {

        companion object {
        lateinit var repository: Repository
    }
        override fun onCreate() {
            super.onCreate()
            val db = Room.databaseBuilder(applicationContext, RoomDB::class.java, "db").build()
            repository = Repository(db)
        }
    }
