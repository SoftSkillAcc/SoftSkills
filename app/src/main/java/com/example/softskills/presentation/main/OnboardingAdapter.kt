package com.example.softskills.presentation.main

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.softskills.R

class OnboardingAdapter(private val onBtnClickListener: OnBtnClickListener) :
    RecyclerView.Adapter<OnboardingAdapter.ItemVH>() {
    private val amount = 2
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemVH = ItemVH(
        LayoutInflater.from(parent.context).inflate(
            R.layout.fragment_onboarding_first, parent, false
        )
    )

    override fun onBindViewHolder(holder: ItemVH, position: Int) {
        holder.bind()
    }

    override fun getItemCount(): Int = amount

    inner class ItemVH(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private var skipBtn = itemView.findViewById<Button>(R.id.onboarding_skip_btn)
        private var onboardingText = itemView.findViewById<TextView>(R.id.onboarding_text)
        fun bind() {
            onboardingText.text = "Преимущество ${adapterPosition + 1}"
            skipBtn.setOnClickListener { skipOnboarding() }
        }
    }

    private fun skipOnboarding() {
        onBtnClickListener.onItemClick()
    }

    interface OnBtnClickListener {
        fun onItemClick()
    }
}