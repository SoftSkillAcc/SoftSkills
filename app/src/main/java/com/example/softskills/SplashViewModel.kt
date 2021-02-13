package com.example.softskills

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class SplashViewModel : ViewModel() {
    var state: MutableLiveData<AppState> = MutableLiveData()

    init {
        state.value = AppState.Loading(null)
    }
}