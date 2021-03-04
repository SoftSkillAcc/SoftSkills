package com.example.softskills.domain.repository

import androidx.lifecycle.MutableLiveData

interface AuthRepository {
    fun signIn(email: String, password: String): MutableLiveData<String?>
}