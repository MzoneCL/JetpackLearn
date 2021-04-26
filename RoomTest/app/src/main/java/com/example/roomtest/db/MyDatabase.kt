package com.example.roomtest.db

import android.content.Context
import android.util.Log
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.roomtest.beans.User

@Database(entities = [User::class], version = 1)
abstract class MyDatabase : RoomDatabase() {

    abstract fun userDao() : UserDao

    companion object {

        private val TAG = this.javaClass.name

        private val DB_NAME = "my_db"

        private var instance:MyDatabase? =null

        @Synchronized
        fun getInstance(context: Context) : MyDatabase{
            instance?.let { return it }
            Log.e(TAG, "创建数据库...")
            return Room.databaseBuilder(context.applicationContext, MyDatabase::class.java, DB_NAME).build().apply { instance = this }
        }
    }

}