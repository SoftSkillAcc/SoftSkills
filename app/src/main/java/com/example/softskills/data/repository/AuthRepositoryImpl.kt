package com.example.softskills.data.repository

import androidx.lifecycle.MutableLiveData
import com.example.softskills.domain.repository.AuthRepository
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase

class AuthRepositoryImpl : AuthRepository {

    private val auth: FirebaseAuth by lazy { Firebase.auth }

    override fun signIn(email: String, password: String): MutableLiveData<String?> {
        val signInMutableLiveData = MutableLiveData<String?>()
        auth.signInWithEmailAndPassword(email, password).addOnCompleteListener { task ->
            if (task.isSuccessful) {
                signInMutableLiveData.value = auth.currentUser?.email
            } else {
                signInMutableLiveData.value = null
            }
        }
        return signInMutableLiveData
    }
}