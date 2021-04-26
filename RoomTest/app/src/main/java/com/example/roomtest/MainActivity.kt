package com.example.roomtest

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.TextView
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.roomtest.beans.User

class MainActivity : AppCompatActivity() {

    private lateinit var etName:EditText
    private lateinit var etSex:EditText
    private lateinit var tvInfo:TextView

    private lateinit var userViewModel: UserViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initView()
    }

    private fun initView() {
        etName = findViewById(R.id.et_name)
        etSex = findViewById(R.id.et_sex)
        tvInfo = findViewById(R.id.tv)

        userViewModel = ViewModelProvider(this).get(UserViewModel::class.java)

        userViewModel.loadUsers().observe(this, Observer { tvInfo.setText("个数 ${it.size}  \n  $it") })

    }

    fun toSave(v: View){
        val name = etName.text.toString()
        val sex = etSex.text.toString()
        var setInt = 0
        if (sex == "男")
            setInt = 1

        userViewModel.insertUser(User(name, setInt))
    }
}