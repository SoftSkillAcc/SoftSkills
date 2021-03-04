package com.example.softskills.presentation.auth.signin

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.example.softskills.MainNavigationDirections
import com.example.softskills.R
import com.example.softskills.data.repository.AuthRepositoryImpl
import com.example.softskills.domain.repository.AuthRepository
import com.example.softskills.domain.usecases.Interactor
import com.google.android.material.button.MaterialButton
import com.google.android.material.textfield.TextInputEditText

class SignInFragment : Fragment() {

    private lateinit var signInViewModel: SignInViewModel

    lateinit var emailEt: TextInputEditText
    lateinit var passwordEt: TextInputEditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        initViewModel()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_sign_in, container, false)

        emailEt = view.findViewById(R.id.emailEditText2)
        passwordEt = view.findViewById(R.id.passwordEditText2)

        val enterBtn = view.findViewById<MaterialButton>(R.id.enter_btn)
        enterBtn.setOnClickListener {
            val email = emailEt.text.toString()
            val password = passwordEt.text.toString()
            signInViewModel.signIn(email, password)
            signInViewModel.signInLiveData.observe(viewLifecycleOwner) {
                if (it != null) {
                    val action = MainNavigationDirections.actionGlobalLkFragment(it)
                    findNavController().navigate(action)
                }
            }
        }
        return view
    }

    private fun initViewModel() {
        val authRepository: AuthRepository = AuthRepositoryImpl()
        val interactor = Interactor(authRepository)

        signInViewModel = ViewModelProvider(
            this,
            SignInViewModelFactory(interactor)
        ).get(SignInViewModel::class.java)
    }
}