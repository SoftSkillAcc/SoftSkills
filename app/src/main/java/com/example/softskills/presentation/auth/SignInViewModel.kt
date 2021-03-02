package com.example.softskills.presentation.auth

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.softskills.domain.usecases.Authenticator
import com.google.firebase.auth.FirebaseUser

class SignInViewModel : ViewModel() {

    private val authenticator: Authenticator = Authenticator()
    val signInLivedata = MutableLiveData<String>()

    fun signIn(email: String, password: String) {
        val userEmail = authenticator.signIn(email, password)
        signInLivedata.postValue(userEmail)
//        signInLivedata.value = "Eugene ZZZ"

//        task.addOnCompleteListener {
//            if (it.isSuccessful) {
//                val user = authenticator
//                signInLivedata.postValue
//                //                    val bundle = Bundle()
//                //                    bundle.putString("EMAIL", auth.currentUser?.email.toString())
//                //                    navController.navigate(R.id.lkFragment, bundle)
//            } else {
//                //                    Toast.makeText(
//                //                        activity, "Authentication failed.",
//                //                        Toast.LENGTH_SHORT
//                //                    ).show()
//                user = null
//            }
//
//        }
    }
}