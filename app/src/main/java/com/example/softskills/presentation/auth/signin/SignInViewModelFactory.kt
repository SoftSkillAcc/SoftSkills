package com.example.softskills.presentation.auth.signin

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.softskills.domain.usecases.Interactor

class SignInViewModelFactory(private val interactor: Interactor) : ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass == SignInViewModel::class.java) {
            return SignInViewModel(interactor) as T
        }
        return null as T
    }
}