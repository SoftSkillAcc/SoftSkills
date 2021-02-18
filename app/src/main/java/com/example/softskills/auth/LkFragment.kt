package com.example.softskills.auth

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.example.softskills.R

class LkFragment() : Fragment() {

    constructor(email: String) : this() {
        this.email = email
    }

    private lateinit var email: String

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_lk, container, false)
        view.findViewById<TextView>(R.id.email).text = email
        return view
    }
}