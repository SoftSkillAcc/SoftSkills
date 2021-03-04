package com.example.softskills.domain.usecases

import androidx.lifecycle.MutableLiveData
import com.example.softskills.domain.repository.AuthRepository

class Interactor(private val authRepository: AuthRepository) {

    fun signIn(email: String, password: String): MutableLiveData<String?> {
        return authRepository.signIn(email, password)
    }
}