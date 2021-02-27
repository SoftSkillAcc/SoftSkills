package com.example.softskills.ui.fragment.auth

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.softskills.R
import com.google.android.material.button.MaterialButton

class SignInFragment : Fragment() {

    companion object {
        interface Listener {
            fun enterAccount()
        }
    }

    private lateinit var listener: Listener

    override fun onAttach(context: Context) {
        super.onAttach(context)
        listener = context as Listener
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val root = inflater.inflate(R.layout.fragment_sign_in, container, false)
        root.findViewById<MaterialButton>(R.id.enter_btn)
            .setOnClickListener { listener.enterAccount() }
        return root
    }
}