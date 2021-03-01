package com.example.softskills.presentation.auth

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.softskills.MainNavigationDirections
import com.example.softskills.R
import com.google.android.material.button.MaterialButton

class SignUpFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_sign_up, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val createAccBtn = view.findViewById<MaterialButton>(R.id.create_acc_btn)
        createAccBtn.setOnClickListener {
            val action = MainNavigationDirections.actionGlobalLkFragment("UUUUUU")
            findNavController().navigate(action)
        }
    }
}