package com.example.softskills.presentation.auth.signin

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.example.softskills.domain.usecases.Interactor

class SignInViewModel(private val interactor: Interactor) : ViewModel() {

    lateinit var signInLiveData: LiveData<String?>

    fun signIn(email: String, password: String) {
        signInLiveData = interactor.signIn(email, password)
    }
}