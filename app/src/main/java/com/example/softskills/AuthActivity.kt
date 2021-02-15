package com.example.softskills

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.TextView
import com.google.android.gms.auth.api.signin.GoogleSignIn
import com.google.android.gms.auth.api.signin.GoogleSignInAccount
import com.google.android.gms.auth.api.signin.GoogleSignInOptions
import com.google.android.gms.common.SignInButton
import com.google.android.gms.common.api.ApiException
import com.google.android.gms.tasks.Task
import com.google.android.material.button.MaterialButton

class AuthActivity : AppCompatActivity() {

    companion object {
        // Используется, чтобы определить результат Activity регистрации через
        // Google
        private const val RC_SIGN_IN = 40404
        private const val TAG = "GoogleAuth"
    }

    // Конфигурация запроса на регистрацию пользователя, чтобы получить
    // идентификатор пользователя, его почту и основной профайл
    // (регулируется параметром)
    private val gso by lazy {
        GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
            .requestEmail()
            .build()
    }

    // Клиент для регистрации пользователя через Google
    // Получаем клиента для регистрации и данные по клиенту
    private val googleSignInClient by lazy { GoogleSignIn.getClient(this, gso) }

    // Кнопка регистрации через Google
    private lateinit var buttonSignIn: SignInButton
    private lateinit var buttonSingOut: MaterialButton
    private lateinit var token: TextView


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        token = findViewById(R.id.token)

        // Кнопка регистрации пользователя
        buttonSignIn = findViewById(R.id.sign_in_button)
        buttonSignIn.setOnClickListener { signIn() }

        buttonSingOut = findViewById(R.id.sing_out_button)
        buttonSingOut.setOnClickListener { signOut() }

    }

    override fun onStart() {
        super.onStart()
        enableSign()
        // Проверим, входил ли пользователь в это приложение через Google
        val account = GoogleSignIn.getLastSignedInAccount(this)
        account?.let {
            disableSign()
            account.email?.let { email -> updateUI(email) };

        }
    }

    // Получаем результаты аутентификации от окна регистрации пользователя
    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == RC_SIGN_IN) {
            // Когда сюда возвращается Task, результаты аутентификации уже
            // готовы
            val task = GoogleSignIn.getSignedInAccountFromIntent(data)
            handleSignInResult(task)
        }
    }

    // Инициируем регистрацию пользователя
    private fun signIn() {
        val signInIntent = googleSignInClient.signInIntent
        startActivityForResult(signInIntent, RC_SIGN_IN)
    }

    // Выход из учётной записи в приложении
    private fun signOut() {
        googleSignInClient.signOut()
            .addOnCompleteListener(this) {
                updateUI("email")
                enableSign()
            }
    }


    //https://developers.google.com/identity/sign-in/android/backend-auth?authuser=1
    // Получаем данные пользователя
    private fun handleSignInResult(completedTask: Task<GoogleSignInAccount>) {
        try {
            val account = completedTask.getResult(ApiException::class.java)

            // Регистрация прошла успешно
            disableSign()
            account?.email?.let { updateUI(it) }
        } catch (e: ApiException) {
            // The ApiException status code indicates the detailed failure
            // reason. Please refer to the GoogleSignInStatusCodes class
            // reference for more information.
            Log.w(TAG, "signInResult:failed code=" + e.statusCode)
        }
    }

    // Обновляем данные о пользователе на экране
    private fun updateUI(idToken: String) {
        token.text = idToken
    }

    private fun enableSign() {
        buttonSignIn.isEnabled = true
        buttonSingOut.isEnabled = false
    }

    private fun disableSign() {
        buttonSignIn.isEnabled = false
        buttonSingOut.isEnabled = true
    }

}