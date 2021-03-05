package com.example.softskills.presentation.test

import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation
import com.example.softskills.R

class TestMainSelectorFragment : Fragment(R.layout.fragment_test_main_selector) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val btnIsWorkSkills = view.findViewById<Button>(R.id.main_selector_work_skills_btn)
        btnIsWorkSkills.setOnClickListener(
            Navigation.createNavigateOnClickListener(R.id.action_test_main_selector_fragment_to_test_professional_selector)
        )
    }
}