package com.trinitydigital.room.data

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = [EtData::class], version = 1)
abstract class AppDataBase : RoomDatabase() {
    abstract fun getDao(): ETDao
}