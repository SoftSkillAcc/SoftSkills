package com.example.softskills.ui.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.View
import android.widget.FrameLayout
import android.widget.Toast
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.viewpager2.widget.ViewPager2
import com.example.softskills.R
import com.example.softskills.viewmodel.SplashViewModel
import com.example.softskills.model.data.AppState
import com.example.softskills.ui.adapter.OnboardingAdapter
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator

class SplashActivity : AppCompatActivity() {
    private val splashViewModel by lazy {
        ViewModelProvider(this).get(SplashViewModel::class.java)
    }
    private var observer = Observer<AppState> { changeState(it) }
    private val onBtnClickListener: OnboardingAdapter.OnBtnClickListener =
        object : OnboardingAdapter.OnBtnClickListener {
            override fun onItemClick() {
                splashViewModel.state.value = AppState.Success(null)
            }
        }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)
        splashViewModel.state.observe(this, observer)
        initViewPager()
    }

    private fun initViewPager() {
        val viewPager = findViewById<ViewPager2>(R.id.view_pager_onboarding)
        val tabLayout = findViewById<TabLayout>(R.id.tab_onboarding)
        viewPager.adapter = OnboardingAdapter(onBtnClickListener)
        TabLayoutMediator(tabLayout, viewPager) { _, _ -> }.attach()
    }

    private fun changeState(appState: AppState) {
        when (appState) {
            is AppState.Loading -> {
                Handler(Looper.getMainLooper()).postDelayed({
                    splashViewModel.state.value = AppState.Default(null)
                }, 5000)
            }
            is AppState.Default -> {
                Toast.makeText(this, "AppState is Default", Toast.LENGTH_SHORT)
                    .show()
                val onboardingLayout = findViewById<FrameLayout>(R.id.onboarding_layout)
                val splashLayout = findViewById<ConstraintLayout>(R.id.splash_layout)
                splashLayout.visibility = View.GONE
                onboardingLayout.visibility = View.VISIBLE
            }
            is AppState.Success -> {
                Toast.makeText(this, "AppState is Success", Toast.LENGTH_SHORT)
                    .show()
                val intent = Intent(this, EntryActivity::class.java)
                startActivity(intent)
            }
            is AppState.Error -> Toast.makeText(this, "AppState is Error", Toast.LENGTH_SHORT)
                .show()
        }
    }
}