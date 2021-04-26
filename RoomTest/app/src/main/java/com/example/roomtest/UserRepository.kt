package com.example.roomtest

import android.os.AsyncTask
import android.util.Log
import androidx.lifecycle.LiveData
import com.example.roomtest.beans.User
import com.example.roomtest.db.UserDao

class UserRepository(private val userDao: UserDao) {

    private val TAG: String = this.javaClass.name

    fun getUserByName(name: String): LiveData<User>? {
        return userDao.loadUserByName(name)
    }

    fun insertUser(user: User) {
        AsyncTask.execute(Runnable {
            val res = userDao.insertUser(user)
            Log.e(TAG, "插入成功 + $res")
        })
    }

    fun loadUsers(): LiveData<List<User>> {
        return userDao.loadUsers()
    }

}