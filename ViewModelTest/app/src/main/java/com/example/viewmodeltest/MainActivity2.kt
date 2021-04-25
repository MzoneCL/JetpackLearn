package com.example.viewmodeltest

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import androidx.lifecycle.ViewModelProvider

class MainActivity2 : AppCompatActivity() {

    private var timerViewModel: TimerViewModel? = null
    private var tv: TextView? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)

        initView()
    }

    private fun initView () {
        tv = findViewById(R.id.tv_2)
        timerViewModel = ViewModelProvider(this).get(TimerViewModel::class.java)

        timerViewModel?.setOnTimeChangeListener(object : TimerViewModel.OnTimeChangeListener{
            override fun onChanged(sec: Int) {
                runOnUiThread{ tv?.setText("$sec s") }
            }
        })

        timerViewModel?.startTiming()
    }
}