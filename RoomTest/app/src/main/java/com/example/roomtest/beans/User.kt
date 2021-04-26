package com.example.roomtest.beans

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "user")
data class User( var name: String, var sex: Int){
    @PrimaryKey(autoGenerate = true)
    var id: Long = 0
}