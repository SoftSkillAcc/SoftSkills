package com.example.softskills.presentation.main

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation
import com.example.softskills.R

class MainFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_main, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val registrationBtn = view.findViewById<Button>(R.id.registration_btn)
        registrationBtn.setOnClickListener(
            Navigation.createNavigateOnClickListener(R.id.action_main_to_entryFragment)
        )

        val testBtn = view.findViewById<Button>(R.id.soft_skills_test_btn)
        testBtn.setOnClickListener(
            Navigation.createNavigateOnClickListener(R.id.action_main_to_test_main_selector_fragment)
        )
    }
}