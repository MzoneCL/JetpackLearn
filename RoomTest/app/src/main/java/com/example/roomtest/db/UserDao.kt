package com.example.roomtest.db

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy.REPLACE
import androidx.room.Query
import com.example.roomtest.beans.User

@Dao
interface UserDao {
    @Insert
    fun insertUser(user: User) : Long

    @Query("SELECT * FROM user WHERE name = :name")
    fun loadUserByName(name: String): LiveData<User>

    @Query("SELECT * FROM user")
    fun loadUsers() : LiveData<List<User>>
}