package com.trinitydigital.room.data

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class EtData(
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    var etOne: String,
    var etTwo: String,
    var etThree: String,
    var etFour: String
)