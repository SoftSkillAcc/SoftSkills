package com.example.softskills.presentation.test

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.softskills.R

class TestProfessionalSelector : Fragment(R.layout.fragment_test_profession_selector) {
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val profTestRecycler = view.findViewById<RecyclerView>(R.id.profession_selector_rv)
        profTestRecycler.adapter = TestProfessionalSelectorAdapter()
        profTestRecycler.layoutManager = GridLayoutManager(context, 2)
    }
}
