package com.example.softskills.presentation.test

import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import com.example.softskills.R
import org.koin.android.viewmodel.ext.android.viewModel

class TestMainSelectorFragment : Fragment(R.layout.fragment_test_main_selector) {
    companion object {
        const val PREFERENCES = "service"
        const val SKILLS = "skills"
    }

    private val selectorModel: TestMainSelectorViewModel by viewModel()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val btnIsWorkSkills = view.findViewById<Button>(R.id.main_selector_work_skills_btn)
        val btnIsLifeSkills = view.findViewById<Button>(R.id.main_selector_life_skills_btn)
        val sharedPreferences: SharedPreferences = requireActivity().getSharedPreferences(
            PREFERENCES, Context.MODE_PRIVATE)
        val editor: SharedPreferences.Editor = sharedPreferences.edit()
        btnIsWorkSkills.setOnClickListener {
            editor.putInt(SKILLS, 0).apply()
            view.findNavController()
                .navigate(R.id.action_test_main_selector_fragment_to_test_skills_selector)
        }
        btnIsLifeSkills.setOnClickListener {
            editor.putInt(SKILLS, 1).apply()
            view.findNavController()
                .navigate(R.id.action_test_main_selector_fragment_to_test_skills_selector)
        }
    }
}