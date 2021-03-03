package com.example.softskills.presentation.test

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.softskills.R

class TestActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_test)
        supportFragmentManager.beginTransaction()
            .replace(R.id.test_activity_fragment_container, TestMainSelectorFragment())
            .commit()
    }
}