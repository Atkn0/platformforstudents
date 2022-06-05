package com.example.hackathonstudentsplatform.Data.ViewModels

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.hackathonstudentsplatform.Data.Models.LessonModel
import com.example.hackathonstudentsplatform.Data.Repositorys.AllLessonsRepository


class AllLessonsViewModel:ViewModel() {

    private var allLessonsRepo = AllLessonsRepository()



    fun getAllLessons(): ArrayList<LessonModel> {

        return allLessonsRepo.getList()

    }


}