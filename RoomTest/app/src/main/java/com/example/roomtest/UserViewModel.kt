package com.example.roomtest

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.example.roomtest.beans.User
import com.example.roomtest.db.MyDatabase
import com.example.roomtest.db.UserDao

class UserViewModel : ViewModel() {

    private var userRepository : UserRepository? = null

    private var user : LiveData<User>? = null
    private var users : LiveData<List<User>>? = null

    init {
        userRepository = UserRepository(MyApplication.myDatabase.userDao())
        users = userRepository?.loadUsers()
    }

    fun getUser(name : String) : LiveData<User> {
        if (user == null){
            user = userRepository?.getUserByName(name)
        }

        return user!!
    }

    fun insertUser(user : User){
        userRepository?.insertUser(user)
    }

    fun loadUsers() :LiveData<List<User>> {
        return users!!
    }

    override fun onCleared() {
        super.onCleared()
    }

}