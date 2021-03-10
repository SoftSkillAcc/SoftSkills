package com.example.softskills.presentation.test

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.softskills.R
import com.example.softskills.data.LifeSkills

class TestLifeSkillsSelector : Fragment(R.layout.fragment_test_life_skills_selector) {

    private val onItemListClickListener: TestLifeSkillsSelectorAdapter.OnItemListClickListener =
        object : TestLifeSkillsSelectorAdapter.OnItemListClickListener {
            override fun onItemClick(data: LifeSkills, position: Int) {
                findNavController().navigate(R.id.action_test_life_skills_selector_to_test_description_fragment)
            }
        }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val lifeSkillsRecycler = view.findViewById<RecyclerView>(R.id.life_skills_selector_rv)
        lifeSkillsRecycler.adapter = TestLifeSkillsSelectorAdapter(onItemListClickListener)
        lifeSkillsRecycler.layoutManager = GridLayoutManager(context, 2)
    }
}
