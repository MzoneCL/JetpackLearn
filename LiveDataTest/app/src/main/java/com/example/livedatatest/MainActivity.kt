package com.example.livedatatest

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.TextView
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider

class MainActivity : AppCompatActivity() {

    private lateinit var tv:TextView
    private lateinit var timerWithLiveDataViewModel: TimerWithLiveDataViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        Log.e(this.javaClass.name, "Thread id: ${Thread.currentThread().id}")

        initView()
    }

    private fun initView() {
        tv = findViewById(R.id.tv)
        timerWithLiveDataViewModel =  ViewModelProvider(this).get(TimerWithLiveDataViewModel::class.java)

        val curSecLiveData:MutableLiveData<Int> = timerWithLiveDataViewModel.getCurSec()
        curSecLiveData.observe(this, Observer<Int> {
            tv.setText("$it s")
        })

        timerWithLiveDataViewModel.statTiming()
    }

    fun toSetTimeZero(v: View) {
        timerWithLiveDataViewModel.resetTimeToSecs(0)
    }
}