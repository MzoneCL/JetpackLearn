package com.example.livedatatest

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import java.util.*

class TimerWithLiveDataViewModel : ViewModel() {

    val TAG:String = this.javaClass.name

    private var curSec: MutableLiveData<Int>? = null
    private var timer: Timer? = null

    public fun getCurSec(): MutableLiveData<Int> {
        if (curSec == null){
            curSec = MutableLiveData()
            curSec?.value = 0
        }

        return curSec!!
    }

    public fun statTiming() {
        if (timer == null){
            timer = Timer()
            val timerTask: TimerTask = object : TimerTask() {
                override fun run() {
                   // Log.e(this.javaClass.name, "Value: ${curSec?.value}")
                    curSec?.postValue(curSec?.value?.plus(1))
                }
            }

            timer?.schedule(timerTask, 1000, 1000)
            Log.e(TAG, "开始计时...")
        }
    }

    fun resetTimeToSecs(sec: Int) {
        curSec?.value = sec
        Log.e(TAG, "重置时间为 $sec s")
    }

    override fun onCleared() {
        super.onCleared()
        timer?.cancel()
        Log.e(TAG, "计时结束...")
    }

}