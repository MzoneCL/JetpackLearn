package com.example.roomtest

import android.app.Application
import com.example.roomtest.db.MyDatabase

class MyApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        myDatabase = MyDatabase.getInstance(applicationContext)
    }

    // 伴生对象
    // 实现类似于 static 属性
    companion object {
        lateinit var myDatabase : MyDatabase
    }

}