package com.example.softskills

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.android.material.button.MaterialButton

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initBottomNavigation()
    }

    private fun initBottomNavigation() {
        val bottomNavigationView = findViewById<BottomNavigationView>(R.id.main_bottom_nav_view)
        bottomNavigationView.setOnNavigationItemSelectedListener {
            when (it.itemId) {
                R.id.item_main -> {
                    Toast.makeText(this, "item_main", Toast.LENGTH_SHORT).show()
                    true
                }
                R.id.item_personal -> {
                    Toast.makeText(this, "item_personal", Toast.LENGTH_SHORT).show()
                    true
                }
                R.id.item_chat -> {
                    Toast.makeText(this, "item_chat", Toast.LENGTH_SHORT).show()
                    true
                }
                R.id.item_tracking -> {
                    Toast.makeText(this, "item_tracking", Toast.LENGTH_SHORT).show()
                    true
                }
                R.id.item_psychologist -> {
                    Toast.makeText(this, "item_psychologist", Toast.LENGTH_SHORT).show()
                    true
                }
                else -> false
            }
        }
    }
}