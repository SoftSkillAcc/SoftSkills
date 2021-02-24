package com.example.softskills.auth

import android.app.Activity
import android.os.Bundle
import android.widget.Toast
import androidx.navigation.NavController
import com.example.softskills.R
import com.google.android.material.textfield.TextInputLayout
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase


class Authenticator(
    private val activity: Activity,
    private val navController: NavController
) {

    private val auth: FirebaseAuth by lazy { Firebase.auth }

    private fun validateSignUpForm(
        nameLayout: TextInputLayout,
        emailLayout: TextInputLayout,
        passwordLayout: TextInputLayout,
        secondPasswordLayout: TextInputLayout
    ): Boolean {
        nameLayout.error = null
        emailLayout.error = null
        passwordLayout.error = null
        secondPasswordLayout.error = null

        var valid = true
        if (nameLayout.editText?.text.toString().isEmpty()) {
            nameLayout.error = "Required."
            valid = false
        }

        if (emailLayout.editText?.text.toString().isEmpty()) {
            emailLayout.error = "Required."
            valid = false
        }

        if (passwordLayout.editText?.text.toString().isEmpty()) {
            passwordLayout.error = "Required."
            valid = false
        }

        when {
            secondPasswordLayout.editText?.text.toString().isEmpty() -> {
                secondPasswordLayout.error = "Required."
                valid = false
            }
            secondPasswordLayout.editText?.text.toString() != passwordLayout.editText?.text.toString() -> {
                secondPasswordLayout.error =
                    "Different passwords..."
                valid = false
            }
        }

        return valid
    }


    private fun validateSignInForm(
        emailLayout: TextInputLayout,
        passwordLayout: TextInputLayout
    ): Boolean {
        emailLayout.error = null
        passwordLayout.error = null

        var valid = true

        if (emailLayout.editText?.text.toString().isEmpty()) {
            emailLayout.error = "Required."
            valid = false
        }

        if (passwordLayout.editText?.text.toString().isEmpty()) {
            passwordLayout.error = "Required."
            valid = false
        }

        return valid
    }

    fun createAccount(
        nameLayout: TextInputLayout,
        emailLayout: TextInputLayout,
        passwordLayout: TextInputLayout,
        secondPasswordLayout: TextInputLayout
    ) {
        if (!validateSignUpForm(
                nameLayout,
                emailLayout,
                passwordLayout,
                secondPasswordLayout
            )
        ) return

        auth.createUserWithEmailAndPassword(
            emailLayout.editText?.text.toString(),
            passwordLayout.editText?.text.toString()
        )
            .addOnCompleteListener(activity) { task ->
                if (task.isSuccessful) {
                    val user = auth.currentUser
                    val bundle = Bundle()
                    bundle.putString("EMAIL", user?.email.toString())
                    navController.navigate(R.id.lkFragment, bundle)
                } else {
                    Toast.makeText(
                        activity, "Authentication failed.",
                        Toast.LENGTH_SHORT
                    ).show()
                }
            }
    }

    fun signIn(
        emailLayout: TextInputLayout,
        passwordLayout: TextInputLayout
    ) {
        if (!validateSignInForm(emailLayout, passwordLayout)) return

        auth.signInWithEmailAndPassword(
            emailLayout.editText?.text.toString(),
            passwordLayout.editText?.text.toString()
        )
            .addOnCompleteListener(activity) { task ->
                if (task.isSuccessful) {
                    val user = auth.currentUser
                    val bundle = Bundle()
                    bundle.putString("EMAIL", user?.email.toString())
                    navController.navigate(R.id.lkFragment, bundle)
                } else {
                    Toast.makeText(
                        activity, "Authentication failed.",
                        Toast.LENGTH_SHORT
                    ).show()
                }
            }
    }
}
