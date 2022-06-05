package com.example.hackathonstudentsplatform.Data.Adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.lifecycle.MutableLiveData
import androidx.recyclerview.widget.RecyclerView
import com.example.hackathonstudentsplatform.Data.Models.LessonModel
import com.example.hackathonstudentsplatform.databinding.AllLessonsRowBinding

class AllLessonsRecyclerViewAdapter(val list: ArrayList<LessonModel>): RecyclerView.Adapter<AllLessonsRecyclerViewAdapter.LessonHolder>() {
    class LessonHolder(val binding: AllLessonsRowBinding): RecyclerView.ViewHolder(binding.root) {

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): LessonHolder {
        val binding = AllLessonsRowBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return LessonHolder(binding)
    }

    override fun onBindViewHolder(holder: LessonHolder, position: Int) {
        holder.binding.teacherText.text = list[position].teacherName
        holder.binding.LessonText.text = list[position].lessonName
    }

    override fun getItemCount(): Int {
        return list.size
    }
}