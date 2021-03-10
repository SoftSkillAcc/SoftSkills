package com.example.softskills.presentation.test

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.softskills.R
import com.example.softskills.data.Profession

class TestProfessionalSelector : Fragment(R.layout.fragment_test_profession_selector) {
    private val onItemListClickListener: TestProfessionalSelectorAdapter.OnItemListClickListener =
        object : TestProfessionalSelectorAdapter.OnItemListClickListener {
            override fun onItemClick(data: Profession, position: Int) {
                findNavController().navigate(R.id.action_test_professionalSelector_to_test_description_fragment)
            }
        }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val profTestRecycler = view.findViewById<RecyclerView>(R.id.profession_selector_rv)
        profTestRecycler.adapter = TestProfessionalSelectorAdapter(onItemListClickListener)
        profTestRecycler.layoutManager = GridLayoutManager(context, 2)
    }
}
