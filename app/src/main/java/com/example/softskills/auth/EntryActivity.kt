package com.example.softskills.auth

import android.os.Bundle
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentTransaction
import com.example.softskills.R
import com.google.android.material.textfield.TextInputLayout
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase

class EntryActivity : AppCompatActivity(), EntryFragment.Companion.Listener,
    SignUpFragment.Companion.Listener, SignInFragment.Companion.Listener {

    private val auth: FirebaseAuth by lazy { Firebase.auth }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_entry)

        if (savedInstanceState == null) {
            val entryFragment = EntryFragment()
            val ft = supportFragmentManager.beginTransaction()
            ft.replace(R.id.fragment_container, entryFragment)
            ft.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE)
            ft.commit()
        }
    }

    private fun transactToFragment(fragment: Fragment) {
        val ft = supportFragmentManager.beginTransaction()
        ft.replace(R.id.fragment_container, fragment)
        ft.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE)
        ft.addToBackStack(null)
        ft.commit()
    }

    override fun signUpClicked() {
        val signUpFragment = SignUpFragment()
        transactToFragment(signUpFragment)
    }

    override fun signInClicked() {
        val signInFragment = SignInFragment()
        transactToFragment(signInFragment)
    }


    override fun createAccClicked() {
        createAccount(
            findViewById<EditText>(R.id.emailEditText).text.toString(),
            findViewById<EditText>(R.id.passwordEditText).text.toString()
        )
    }

    override fun enterAccount() {
        signIn(
            findViewById<EditText>(R.id.emailEditText2).text.toString(),
            findViewById<EditText>(R.id.passwordEditText2).text.toString()
        )
    }

    private fun validateForm(): Boolean {
        var valid = true

        val name = findViewById<EditText>(R.id.nameEditText).text.toString()
        if (name.isNullOrEmpty()) {
            findViewById<TextInputLayout>(R.id.nameInputLayout).error = "Required."
            valid = false
        }

        val email = findViewById<EditText>(R.id.emailEditText).text.toString()
        if (email.isNullOrEmpty()) {
            findViewById<TextInputLayout>(R.id.emailInputLayout).error = "Required."
            valid = false
        }

        val password = findViewById<EditText>(R.id.passwordEditText).text.toString()
        if (password.isNullOrEmpty()) {
            findViewById<TextInputLayout>(R.id.passwordInputLayout).error = "Required."
            valid = false
        }

        val secondPassword = findViewById<EditText>(R.id.passwordReEditText).text.toString()
        when {
            secondPassword.isNullOrEmpty() -> {
                findViewById<TextInputLayout>(R.id.passwordReInputLayout).error = "Required."
                valid = false
            }
            secondPassword != password -> {
                findViewById<TextInputLayout>(R.id.passwordReInputLayout).error =
                    "Different passwords..."
                valid = false
            }
        }
        return valid
    }

    private fun validateForm2(): Boolean {
        var valid = true

        val email = findViewById<EditText>(R.id.emailEditText2).text.toString()
        if (email.isNullOrEmpty()) {
            findViewById<TextInputLayout>(R.id.emailInputLayout2).error = "Required."
            valid = false
        }

        val password = findViewById<EditText>(R.id.passwordEditText2).text.toString()
        if (password.isNullOrEmpty()) {
            findViewById<TextInputLayout>(R.id.passwordInputLayout2).error = "Required."
            valid = false
        }
        return valid
    }

    private fun createAccount(email: String, password: String) {
        if (!validateForm()) {
            return
        }
        auth.createUserWithEmailAndPassword(email, password)
            .addOnCompleteListener(this) { task ->
                if (task.isSuccessful) {
                    // Sign in success, update UI with the signed-in user's information
                    val user = auth.currentUser
                    val lkFragment = user?.email?.let { LkFragment(it) }
                    if (lkFragment != null) {
                        transactToFragment(lkFragment)
                    }
                } else {
                    Toast.makeText(
                        baseContext, "Authentication failed.",
                        Toast.LENGTH_SHORT
                    ).show()
                }
            }
    }

    private fun signIn(email: String, password: String) {
        if (!validateForm2()) {
            return
        }

        auth.signInWithEmailAndPassword(email, password)
            .addOnCompleteListener(this) { task ->
                if (task.isSuccessful) {
                    // Sign in success, update UI with the signed-in user's information
                    val user = auth.currentUser
                    val lkFragment = user?.email?.let { LkFragment(it) }
                    if (lkFragment != null) {
                        transactToFragment(lkFragment)
                    }
                } else {
                    Toast.makeText(
                        baseContext, "Authentication failed.",
                        Toast.LENGTH_SHORT
                    ).show()
                }
            }
    }

}