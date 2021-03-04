package com.example.softskills.domain.usecases

import com.google.android.gms.tasks.Task
import com.google.firebase.auth.AuthResult
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase


class Authenticator()

//    private fun validateSignUpForm(
//        nameLayout: TextInputLayout,
//        emailLayout: TextInputLayout,
//        passwordLayout: TextInputLayout,
//        secondPasswordLayout: TextInputLayout
//    ): Boolean {
//        nameLayout.error = null
//        emailLayout.error = null
//        passwordLayout.error = null
//        secondPasswordLayout.error = null
//
//        var valid = true
//        if (nameLayout.editText?.text.toString().isEmpty()) {
//            nameLayout.error = "Required."
//            valid = false
//        }
//
//        if (emailLayout.editText?.text.toString().isEmpty()) {
//            emailLayout.error = "Required."
//            valid = false
//        }
//
//        if (passwordLayout.editText?.text.toString().isEmpty()) {
//            passwordLayout.error = "Required."
//            valid = false
//        }
//
//        when {
//            secondPasswordLayout.editText?.text.toString().isEmpty() -> {
//                secondPasswordLayout.error = "Required."
//                valid = false
//            }
//            secondPasswordLayout.editText?.text.toString() != passwordLayout.editText?.text.toString() -> {
//                secondPasswordLayout.error =
//                    "Different passwords..."
//                valid = false
//            }
//        }
//
//        return valid
//    }


//    private fun validateSignInForm(
//        emailLayout: TextInputLayout,
//        passwordLayout: TextInputLayout
//    ): Boolean {
//        emailLayout.error = null
//        passwordLayout.error = null
//
//        var valid = true
//
//        if (emailLayout.editText?.text.toString().isEmpty()) {
//            emailLayout.error = "Required."
//            valid = false
//        }
//
//        if (passwordLayout.editText?.text.toString().isEmpty()) {
//            passwordLayout.error = "Required."
//            valid = false
//        }
//
//        return valid
//    }

//    fun createAccount(
//        nameLayout: TextInputLayout,
//        emailLayout: TextInputLayout,
//        passwordLayout: TextInputLayout,
//        secondPasswordLayout: TextInputLayout
//    ) {
//        if (!validateSignUpForm(
//                nameLayout,
//                emailLayout,
//                passwordLayout,
//                secondPasswordLayout
//            )
//        ) return
//
//        auth.createUserWithEmailAndPassword(
//            emailLayout.editText?.text.toString(),
//            passwordLayout.editText?.text.toString()
//        )
//            .addOnCompleteListener(activity) { task ->
//                if (task.isSuccessful) {
//                    val user = auth.currentUser
//                    val bundle = Bundle()
//                    bundle.putString("EMAIL", user?.email.toString())
//                    navController.navigate(R.id.lkFragment, bundle)
//                } else {
//                    Toast.makeText(
//                        activity, "Authentication failed.",
//                        Toast.LENGTH_SHORT
//                    ).show()
//                }
//            }
//    }

//    fun signIn(email: String, password: String): String? {
//        auth.signInWithEmailAndPassword(email, password).addOnCompleteListener { task ->
//            userEmail = if (task.isSuccessful) {
//                auth.currentUser?.email
//            } else null
//        }
//        return userEmail
//    }
//}
////        if (!validateSignInForm(emailLayout, passwordLayout)) return
//
//         return auth.signInWithEmailAndPassword(email, password)
//            .addOnCompleteListener { task ->
//                if (task.isSuccessful) {
//                    user = auth.currentUser
//
//    //                    val bundle = Bundle()
//    //                    bundle.putString("EMAIL", auth.currentUser?.email.toString())
//    //                    navController.navigate(R.id.lkFragment, bundle)
//                } else {
//    //                    Toast.makeText(
//    //                        activity, "Authentication failed.",
//    //                        Toast.LENGTH_SHORT
//    //                    ).show()
//                    user = null
//                }
//            }
//        return user
//    }

