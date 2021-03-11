package com.example.softskills.presentation.test

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.recyclerview.widget.RecyclerView
import com.example.softskills.R
import com.example.softskills.data.LifeSkills
import com.example.softskills.data.Profession

class TestSkillsSelectorAdapter(private val onItemListClickListener: OnItemListClickListener) :
    RecyclerView.Adapter<TestSkillsSelectorAdapter.TestItemViewHolder>() {

    private var dataListProfession: List<Profession> = emptyList()
    private var dataListLifeSkills: List<LifeSkills> = emptyList()

    fun setData(dataListProfession: List<Profession>, dataListLifeSkills: List<LifeSkills>) {
        this.dataListProfession = dataListProfession
        this.dataListLifeSkills = dataListLifeSkills
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TestItemViewHolder {
        val view: View =
            LayoutInflater.from(parent.context).inflate(R.layout.item_prof_selector, parent, false)
        return TestItemViewHolder(view)
    }

    override fun onBindViewHolder(holder: TestItemViewHolder, position: Int) {
        if (dataListLifeSkills.isNotEmpty()) {
            holder.bindLifeSkills()
        }
        if (dataListProfession.isNotEmpty()) {
            holder.bindProfession()
        }
    }

    override fun getItemCount(): Int {
        return when {
            dataListProfession.isNotEmpty() -> {
                dataListProfession.size
            }
            dataListLifeSkills.isNotEmpty() -> {
                dataListLifeSkills.size
            }
            else -> 0
        }
    }

    inner class TestItemViewHolder(item: View) : RecyclerView.ViewHolder(item) {
        private val itemBtn = item.findViewById<Button>(R.id.prof_item_btn)
        fun bindProfession() {
            itemBtn.text = dataListProfession[adapterPosition].professionName
            itemBtn.setOnClickListener {
                checkProfessionTest(
                    dataListProfession[adapterPosition],
                    adapterPosition
                )
            }
        }

        fun bindLifeSkills() {
            itemBtn.text = dataListLifeSkills[adapterPosition].skill
            itemBtn.setOnClickListener {
                checkLifeSKillsTest(
                    dataListLifeSkills[adapterPosition],
                    adapterPosition
                )
            }
        }
    }

    interface OnItemListClickListener {
        fun onItemClick(data: Any, position: Int)
    }

    private fun checkProfessionTest(data: Profession, position: Int) {
        onItemListClickListener.onItemClick(data, position)
    }

    private fun checkLifeSKillsTest(data: LifeSkills, position: Int) {
        onItemListClickListener.onItemClick(data, position)
    }
}