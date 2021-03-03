package com.example.softskills.presentation.test

import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.fragment.app.Fragment
import com.example.softskills.R

class TestMainSelectorFragment : Fragment(R.layout.fragment_test_main_selector) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val btnIsWorkSkills = view.findViewById<Button>(R.id.main_selector_work_skills_btn)
        btnIsWorkSkills.setOnClickListener {
            requireActivity().supportFragmentManager.beginTransaction()
                .replace(R.id.test_activity_fragment_container, TestProfessionalSelector())
                .commit()
        }
    }
}