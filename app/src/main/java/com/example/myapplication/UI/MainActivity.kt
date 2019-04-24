package com.example.myapplication.UI

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.example.myapplication.R

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        supportFragmentManager.beginTransaction().replace(
            R.id.mainFrame,
            LoginFragment()
        ).commit()
    }
}
