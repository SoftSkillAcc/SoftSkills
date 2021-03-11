package com.example.softskills.presentation.test

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.softskills.data.DataList
import com.example.softskills.data.LifeSkills
import com.example.softskills.data.Profession

class TestSkillsSelectorViewModel : ViewModel() {
    val listProfessionLiveData: MutableLiveData<List<Profession>> = MutableLiveData()
    val listLifeSkillsLiveData: MutableLiveData<List<LifeSkills>> = MutableLiveData()

    init {
        listProfessionLiveData.value = DataList.professionList
        listLifeSkillsLiveData.value = DataList.skillsList
    }

}