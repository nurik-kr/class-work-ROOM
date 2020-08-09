package com.trinitydigital.room.data

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query

@Dao
interface ETDao {

    @Insert
    fun insertEtData(data: EtData)

    @Query("SELECT * FROM EtData")
    fun getAllEtData(): List<EtData>

    @Delete
    fun delete(data: EtData)
}