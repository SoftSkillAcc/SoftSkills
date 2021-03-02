package com.example.softskills.presentation.auth

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.Navigation
import androidx.navigation.fragment.findNavController
import com.example.softskills.MainNavigationDirections
import com.example.softskills.R
import com.google.android.material.button.MaterialButton
import com.google.android.material.textfield.TextInputEditText

class SignInFragment : Fragment() {

//    private val signInViewModel: SignInViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_sign_in, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
//
//        signInViewModel.signInLivedata.observe(viewLifecycleOwner) {
//            Log.d("AAA", "mmm")
//        }

        val enterBtn = view.findViewById<MaterialButton>(R.id.enter_btn)
        val email = view.findViewById<TextInputEditText>(R.id.emailEditText2).text.toString()
        val password = view.findViewById<TextInputEditText>(R.id.passwordEditText2).text.toString()

        enterBtn.setOnClickListener {
//            viewmodel method
//            Navigation.createNavigateOnClickListener(R.id.action_global_lkFragment)
//            signInViewModel.signIn(email, password)
            val action = MainNavigationDirections.actionGlobalLkFragment("Eugene")
            findNavController().navigate(action)
        }
    }


}