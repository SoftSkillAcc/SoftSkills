package com.example.softskills.presentation.di

import com.example.softskills.presentation.test.TestMainSelectorViewModel
import com.example.softskills.presentation.test.TestSkillsSelectorViewModel
import org.koin.android.viewmodel.dsl.viewModel
import org.koin.dsl.module

val application = module {
    viewModel { TestMainSelectorViewModel() }
    viewModel { TestSkillsSelectorViewModel() }
}

