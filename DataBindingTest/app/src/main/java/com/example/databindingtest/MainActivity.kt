package com.example.databindingtest

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.databinding.DataBindingUtil
import com.example.databindingtest.beans.Book
import com.example.databindingtest.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private var book:Book? = null
    private var activityMainBinding:ActivityMainBinding? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
      //  setContentView(R.layout.activity_main)

        activityMainBinding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        activityMainBinding?.imgUrl = "https://source.unsplash.com/random"

        book = Book("人类简史", 29.9, 4.9)

        activityMainBinding?.book = book
        activityMainBinding?.myOnClickListener = object : MyOnClickListener {
            override fun onClick() {
                book = Book("Databinding", 19.9, 4.3)
                Log.e(this.javaClass.name, "Databinding")
                activityMainBinding?.book = book
            }
        }

    }

    fun toChange(v: View) {
        book = Book("传统", 19.9, 4.3)
        Log.e(this.javaClass.name, "传统")
        activityMainBinding?.book = book
    }

    fun nextImg(v : View){
      //  activityMainBinding?.imgUrl = "11"
        activityMainBinding?.imgUrl = "https://source.unsplash.com/random"
    }


    interface MyOnClickListener {
        fun onClick()
    }
}