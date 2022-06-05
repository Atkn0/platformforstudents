package com.example.hackathonstudentsplatform.Views

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.get
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.hackathonstudentsplatform.Data.Adapters.AllLessonsRecyclerViewAdapter
import com.example.hackathonstudentsplatform.Data.Models.LessonModel
import com.example.hackathonstudentsplatform.Data.ViewModels.AllLessonsViewModel
import com.example.hackathonstudentsplatform.R
import com.example.hackathonstudentsplatform.databinding.FragmentAllLessonsBinding
import kotlinx.coroutines.DelicateCoroutinesApi
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch


class AllLessonsFragment : Fragment() {

    lateinit var binding: FragmentAllLessonsBinding
    lateinit var allLessonsViewModel: AllLessonsViewModel
    lateinit var adapter : AllLessonsRecyclerViewAdapter
    lateinit var list:ArrayList<LessonModel>


    override fun onCreate(savedInstanceState: Bundle?) {

        allLessonsViewModel = ViewModelProvider(this).get(AllLessonsViewModel::class.java)
        allLessonsViewModel.getAllLessons()

        list = allLessonsViewModel.getAllLessons()
        adapter = AllLessonsRecyclerViewAdapter(list = list)

        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = FragmentAllLessonsBinding.inflate(inflater)

        val view = binding.root



        binding.AllLessonsRecyclerView.layoutManager = LinearLayoutManager(activity)
        binding.AllLessonsRecyclerView.adapter = adapter





        // Inflate the layout for this fragment
        return view
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }


}

