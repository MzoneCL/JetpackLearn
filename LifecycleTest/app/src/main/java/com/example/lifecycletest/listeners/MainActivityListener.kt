package com.example.lifecycletest.listeners

import android.content.Context
import android.util.Log
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleObserver
import androidx.lifecycle.OnLifecycleEvent

class MainActivityListener constructor(private var lifecycleOwner: Context) : LifecycleObserver {

    @OnLifecycleEvent(Lifecycle.Event.ON_CREATE)
    fun onMainActivityCreate() {
        Log.e(lifecycleOwner.javaClass.name, "on MainActivity Create.")
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_START)
    fun onMainActivityStart() {
        Log.e(lifecycleOwner.javaClass.name, "on MainActivity Start.")
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_RESUME)
    fun onMainActivityResume() {
        Log.e(lifecycleOwner.javaClass.name, "on MainActivity Resume.")
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_PAUSE)
    fun onMainActivityPause() {
        Log.e(lifecycleOwner.javaClass.name, "on MainActivity Pause.")
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_STOP)
    fun onMainActivityStop() {
        Log.e(lifecycleOwner.javaClass.name, "on MainActivity Stop.")
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
    fun onMainActivityDestroy() {
        Log.e(lifecycleOwner.javaClass.name, "on MainActivity Destroy.")
    }

}