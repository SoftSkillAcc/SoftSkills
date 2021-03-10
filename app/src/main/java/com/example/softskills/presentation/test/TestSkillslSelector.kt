package com.example.softskills.presentation.test

import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.softskills.R
import com.example.softskills.presentation.test.TestMainSelectorFragment.Companion.SKILLS
import org.koin.android.viewmodel.ext.android.viewModel

class TestSkillslSelector : Fragment(R.layout.fragment_test_skills_selector) {
    private val skillsSelectorViewModel: TestSkillsSelectorViewModel by viewModel()

    private val onItemListClickListener: TestSkillsSelectorAdapter.OnItemListClickListener =
        object : TestSkillsSelectorAdapter.OnItemListClickListener {
            override fun onItemClick(data: Any, position: Int) {
                findNavController().navigate(R.id.action_test_skills_selector_to_test_description_fragment)
            }
        }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val profTestRecycler = view.findViewById<RecyclerView>(R.id.profession_selector_rv)
        val skillsTestRecyclerAdapter = TestSkillsSelectorAdapter(onItemListClickListener)
        val sharedPreferences: SharedPreferences = requireActivity().getSharedPreferences(
            TestMainSelectorFragment.PREFERENCES, Context.MODE_PRIVATE)
        profTestRecycler.adapter = skillsTestRecyclerAdapter
        profTestRecycler.layoutManager = GridLayoutManager(context, 2)

        if (sharedPreferences.getInt(SKILLS, 2) == 0) {
            skillsSelectorViewModel.listProfessionLiveData.observe(viewLifecycleOwner,
                {
                    skillsTestRecyclerAdapter.setData(it, emptyList())
                })
        }
        if (sharedPreferences.getInt(SKILLS, 2) == 1) {
            skillsSelectorViewModel.listLifeSkillsLiveData.observe(viewLifecycleOwner,
                {
                    skillsTestRecyclerAdapter.setData(emptyList(), it)
                })
        }
    }
}
