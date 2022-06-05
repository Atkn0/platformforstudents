package com.example.hackathonstudentsplatform.Views

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.hackathonstudentsplatform.Data.ViewModels.FirebaseViewModel
import com.example.hackathonstudentsplatform.R
import com.example.hackathonstudentsplatform.databinding.FragmentRegisterPageBinding


class RegisterPageFragment : Fragment() {

    lateinit var binding: FragmentRegisterPageBinding
    val FirebaseViewModel = com.example.hackathonstudentsplatform.Data.ViewModels.FirebaseViewModel()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = FragmentRegisterPageBinding.inflate(inflater,container,false)
        val view = binding.root
        // Inflate the layout for this fragment
        return view

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        binding.button.setOnClickListener {

            val email = binding.registerEmailText.text.toString()
            val password = binding.registerPasswordText.text.toString()
            val view = it

            FirebaseViewModel.registerWithEmailPassword(email = email,password = password,view = view)



        }

        super.onViewCreated(view, savedInstanceState)
    }




}