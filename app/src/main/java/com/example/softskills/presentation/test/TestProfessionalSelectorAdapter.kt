package com.example.softskills.presentation.test

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.recyclerview.widget.RecyclerView
import com.example.softskills.R
import com.example.softskills.data.ProfessionList

class TestProfessionalSelectorAdapter :
    RecyclerView.Adapter<TestProfessionalSelectorAdapter.TestItemViewHolder>() {

    private val listOfProfession = ProfessionList.professionList

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TestItemViewHolder {
        val view: View =
            LayoutInflater.from(parent.context).inflate(R.layout.item_prof_selector, parent, false)
        return TestItemViewHolder(view)
    }

    override fun onBindViewHolder(holder: TestItemViewHolder, position: Int) {
        holder.bind()
    }

    override fun getItemCount(): Int = listOfProfession.size

    inner class TestItemViewHolder(item: View) : RecyclerView.ViewHolder(item) {
        private val itemBtn = item.findViewById<Button>(R.id.prof_item_btn)
        fun bind() {
            itemBtn.text = listOfProfession[adapterPosition].professionName
        }
    }
}
