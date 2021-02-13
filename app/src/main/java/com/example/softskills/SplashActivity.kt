package com.example.softskills

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider

class SplashActivity : AppCompatActivity() {
    private val splashViewModel by lazy {
        ViewModelProvider(this).get(SplashViewModel::class.java)
    }
    private var observer = Observer<AppState> { changeState(it) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)
        splashViewModel.state.observe(this, observer)
    }

    private fun changeState(appState: AppState) {
        when (appState) {
            is AppState.Loading -> {
                Handler(Looper.getMainLooper()).postDelayed({
                    splashViewModel.state.value = AppState.Success(null)
                    val intent = Intent(this, MainActivity::class.java)
                    startActivity(intent)
                }, 5000)
            }
            is AppState.Default -> Toast.makeText(this,"AppState is Default", Toast.LENGTH_SHORT).show()
            is AppState.Success -> Toast.makeText(this,"AppState is Success", Toast.LENGTH_SHORT).show()
            is AppState.Error -> Toast.makeText(this,"AppState is Error", Toast.LENGTH_SHORT).show()
        }
    }
}