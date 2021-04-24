package com.example.lifecycletest.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.lifecycletest.R
import com.example.lifecycletest.listeners.MainActivityListener

class MainActivity : AppCompatActivity() {

    private val mainActivityListener: MainActivityListener = MainActivityListener(this)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        lifecycle.addObserver(mainActivityListener)
    }
}