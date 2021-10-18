package com.example.newsfeedapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.newsfeedapp.features.main_screen.MainScreenFragment

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        supportFragmentManager.beginTransaction().replace(R.id.container, MainScreenFragment())
            .commit()
    }
}