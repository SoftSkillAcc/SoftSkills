package com.example.softskills.auth

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.softskills.R
import com.google.android.material.button.MaterialButton

class SignUpFragment : Fragment() {

    companion object {
        interface Listener {
            fun createAccClicked()
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
        val view = inflater.inflate(R.layout.fragment_sign_up, container, false)
        view.findViewById<MaterialButton>(R.id.create_acc_btn)
            .setOnClickListener { listener.createAccClicked() }
        return view
    }
}