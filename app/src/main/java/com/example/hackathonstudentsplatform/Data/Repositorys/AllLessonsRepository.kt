package com.example.hackathonstudentsplatform.Data.Repositorys

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import com.example.hackathonstudentsplatform.Data.Models.LessonModel
import com.google.firebase.firestore.FirebaseFirestore
import kotlinx.coroutines.DelicateCoroutinesApi
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.tasks.await

class AllLessonsRepository {

    lateinit var firestore: FirebaseFirestore
    lateinit var model:LessonModel
    lateinit var list:ArrayList<LessonModel>


    @JvmName("getList1")
    @OptIn(DelicateCoroutinesApi::class)
    fun getList(): ArrayList<LessonModel> {
        firestore = FirebaseFirestore.getInstance()
        runBlocking {
            val db = firestore.collection("AllLessons").get().await()
            println("db alındı!!")
            list = ArrayList()
            launch {
                val documents = db.documents
                println(documents)
                for (document in documents){
                    val LesName = document.get("LesName") as String
                    val teacherName = document.get("teacherName") as String
                    model = LessonModel(lessonName = LesName,teacherName = teacherName)
                    list.add(model)
                    println("listeye Lesson Model eklendi!")

                }
            }

        }
        return list
    }



    }


