package com.trinitydigital.room

import android.app.Application
import androidx.room.Room
import androidx.room.RoomDatabase
import com.trinitydigital.room.data.AppDataBase

class MyApp : Application() {

    private var db: AppDataBase? = null

    override fun onCreate() {
        super.onCreate()
        app = this

        db = Room.databaseBuilder(this, AppDataBase::class.java, "MY_DATABASE")
            .allowMainThreadQueries()
            .build()
    }

    fun getDB() = db

    companion object {
        var app: MyApp? = null
    }
}