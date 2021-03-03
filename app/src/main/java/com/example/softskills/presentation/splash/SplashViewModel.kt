package com.example.softskills.presentation.splash

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.softskills.domain.model.data.AppState

class SplashViewModel : ViewModel() {
    var state: MutableLiveData<AppState> = MutableLiveData()

    init {
        state.value = AppState.Loading(null)
    }
}