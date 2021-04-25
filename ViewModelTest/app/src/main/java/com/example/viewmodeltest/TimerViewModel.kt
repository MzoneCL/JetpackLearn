package com.example.viewmodeltest

import android.util.Log
import androidx.lifecycle.ViewModel
import java.util.*

class TimerViewModel : ViewModel() {

    private var timer: Timer? = null
    private var curSec:Int = 0
    private var onTimeChangeListener:OnTimeChangeListener? =null

    public fun startTiming() {
        if (timer == null){
            curSec = 0
            timer = Timer()
            val timerTask = object : TimerTask(){
                override fun run() {
                    curSec++
                    onTimeChangeListener?.onChanged(curSec)
                }
            }

            timer?.schedule(timerTask, 1000, 1000)
            Log.e(this.javaClass.name, "开始计时...")
        }
    }

    fun setOnTimeChangeListener(onTimeChangeListener: OnTimeChangeListener) {
        this.onTimeChangeListener = onTimeChangeListener
    }

    interface OnTimeChangeListener {
        fun onChanged(sec: Int)
    }

    override fun onCleared() {
        super.onCleared()
        Log.e(this.javaClass.name, "onCleared()")
        Log.e(this.javaClass.name, "停止计时...")
        timer?.cancel()
    }

}