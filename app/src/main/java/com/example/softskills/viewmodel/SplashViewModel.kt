package com.example.softskills.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.softskills.model.data.AppState

class SplashViewModel : ViewModel() {
    var state: MutableLiveData<AppState> = MutableLiveData()

    init {
        state.value = AppState.Loading(null)
    }
}