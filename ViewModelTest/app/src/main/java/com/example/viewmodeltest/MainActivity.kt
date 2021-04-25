package com.example.viewmodeltest

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TextView
import androidx.lifecycle.ViewModelProvider

class MainActivity : AppCompatActivity() {

    private var tv: TextView? = null
    private var timerViewModel: TimerViewModel? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initView()
    }

    private fun initView() {
        tv = findViewById(R.id.tv_time)
        timerViewModel = ViewModelProvider(this).get(TimerViewModel::class.java)
        timerViewModel?.setOnTimeChangeListener(object : TimerViewModel.OnTimeChangeListener {
            override fun onChanged(sec: Int) {
                runOnUiThread { tv?.setText("$sec s") }
            }
        })

        timerViewModel?.startTiming()
    }

    fun toActivity2(view: View) {
        startActivity(Intent(this, MainActivity2::class.java))
    }
}