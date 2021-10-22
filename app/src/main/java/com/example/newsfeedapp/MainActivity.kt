package com.example.newsfeedapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.example.newsfeedapp.features.bokmarks_screen.ui.BookmarksScreenFragment
import com.example.newsfeedapp.features.main_screen.ui.MainScreenFragment
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // commit обязателен

        val bottomNavigationView = findViewById<BottomNavigationView>(R.id.bottomNavigationView)
        bottomNavigationView.setOnItemSelectedListener {
            when (it.itemId) {
                R.id.mainTab -> setFragment(MainScreenFragment())
                R.id.bookmarkTab -> setFragment(BookmarksScreenFragment.newInstance())
            }
            true
        }
        bottomNavigationView.selectedItemId = R.id.mainTab
    }

    private fun setFragment(fragment: Fragment) {
        supportFragmentManager.beginTransaction()
            .replace(R.id.container, fragment).commit()
    }
}