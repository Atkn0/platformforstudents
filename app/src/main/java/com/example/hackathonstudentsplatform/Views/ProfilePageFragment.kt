package com.example.hackathonstudentsplatform.Views

import android.os.Bundle
import android.text.Editable
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.hackathonstudentsplatform.Data.Models.UserModel
import com.example.hackathonstudentsplatform.Data.Repositorys.FirestoreRepository
import com.example.hackathonstudentsplatform.Data.ViewModels.FirebaseViewModel
import com.example.hackathonstudentsplatform.R
import com.example.hackathonstudentsplatform.databinding.FragmentProfilePageBinding
import com.google.firebase.firestore.auth.User
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking


class ProfilePageFragment : Fragment() {

    lateinit var FirestoreRepo :FirestoreRepository
    lateinit var binding: FragmentProfilePageBinding
    lateinit var deneme:UserModel
    val FirebaseViewModel = com.example.hackathonstudentsplatform.Data.ViewModels.FirebaseViewModel()

    override fun onCreate(savedInstanceState: Bundle?) {

        FirestoreRepo = FirestoreRepository()

        runBlocking {
            launch {
                deneme = FirebaseViewModel.getUserDatas()

            }
        }



        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = FragmentProfilePageBinding.inflate(inflater)
        val view = binding.root
        val myContext = activity



        binding.UpdateButton.setOnClickListener {
            FirestoreRepo.updateUserInfos(binding,myContext!!)
        }



        // Inflate the layout for this fragment
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {


        binding.EmailTextInput.setText(deneme.email)
        binding.NameTextInput.setText(deneme.Name)
        binding.SurnameTextInput.setText(deneme.Surname)
        binding.PhoneTextInput.setText(deneme.PhoneNum)




        super.onViewCreated(view, savedInstanceState)
    }


}