package com.example.softskills.presentation.test

import androidx.recyclerview.widget.RecyclerView

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import com.example.softskills.R
import com.example.softskills.data.DataList
import com.example.softskills.data.LifeSkills

class TestLifeSkillsSelectorAdapter(private var onItemListClickListener: OnItemListClickListener) :
    RecyclerView.Adapter<TestLifeSkillsSelectorAdapter.TestItemViewHolder>() {

    private val listOfSkills = DataList.skillsList

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TestItemViewHolder {
        val view: View =
            LayoutInflater.from(parent.context).inflate(R.layout.item_prof_selector, parent, false)
        return TestItemViewHolder(view)
    }

    override fun onBindViewHolder(holder: TestItemViewHolder, position: Int) {
        holder.bind()
    }

    override fun getItemCount(): Int = listOfSkills.size

    inner class TestItemViewHolder(item: View) : RecyclerView.ViewHolder(item) {
        private val itemBtn = item.findViewById<Button>(R.id.prof_item_btn)
        fun bind() {
            itemBtn.text = listOfSkills[adapterPosition].skill
            itemBtn.setOnClickListener { checkTest(listOfSkills[adapterPosition], adapterPosition) }
        }
    }

    interface OnItemListClickListener {
        fun onItemClick(data: LifeSkills, position: Int)
    }

    private fun checkTest(data: LifeSkills, position: Int) {
        onItemListClickListener.onItemClick(data, position)
    }
}
