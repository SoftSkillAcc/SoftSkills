package com.example.softskills.ui.fragment.auth

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import com.example.softskills.R
import com.google.android.material.button.MaterialButton

class SignInFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_sign_in, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val enterBtn = view.findViewById<MaterialButton>(R.id.enter_btn)
        enterBtn.setOnClickListener(
            Navigation.createNavigateOnClickListener(R.id.action_global_lkFragment)
        )
    }
}