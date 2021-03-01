package com.example.softskills.presentation.auth

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation
import com.example.softskills.R
import com.google.android.material.button.MaterialButton

class EntryFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_entry, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val signUpBtn = view.findViewById<MaterialButton>(R.id.signUp)
        signUpBtn.setOnClickListener(
            Navigation.createNavigateOnClickListener(R.id.action_entryFragment_to_signUpFragment)
        )

        val signInBtn = view.findViewById<MaterialButton>(R.id.signIn)
        signInBtn.setOnClickListener(
            Navigation.createNavigateOnClickListener(R.id.action_entryFragment_to_signInFragment)
        )
    }
}