package com.example.hackathonstudentsplatform.Views

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.Navigation
import com.example.hackathonstudentsplatform.Data.Repositorys.AuthRepository
import com.example.hackathonstudentsplatform.Data.ViewModels.FirebaseViewModel
import com.example.hackathonstudentsplatform.R
import com.example.hackathonstudentsplatform.databinding.FragmentStudentHomeScreenBinding
import kotlinx.coroutines.runBlocking

class StudentHomeScreen : Fragment() {

    lateinit var binding: FragmentStudentHomeScreenBinding
    lateinit var AuthviewModel: FirebaseViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        AuthviewModel = ViewModelProvider(this).get(FirebaseViewModel::class.java)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = FragmentStudentHomeScreenBinding.inflate(inflater)

        // Inflate the layout for this fragment
        return binding.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        binding.AllLessonsCard.setOnClickListener {
            val action = StudentHomeScreenDirections.actionStudentHomeScreenToAllLessonsFragment()
            Navigation.findNavController(view).navigate(action)
        }

        binding.ProfilePageCard.setOnClickListener {
            val action = StudentHomeScreenDirections.actionStudentHomeScreenToProfilePageFragment()
            Navigation.findNavController(it).navigate(action)
        }


        super.onViewCreated(view, savedInstanceState)
    }


}