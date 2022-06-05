package com.example.hackathonstudentsplatform.Views

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.Navigation
import com.example.hackathonstudentsplatform.R
import com.example.hackathonstudentsplatform.Data.ViewModels.FirebaseViewModel
import com.example.hackathonstudentsplatform.databinding.FragmentLoginScreenBinding


class LoginScreenFragment : Fragment(R.layout.fragment_login_screen) {


    lateinit var binding: FragmentLoginScreenBinding

    lateinit var authViewModel : FirebaseViewModel



    override fun onCreate(savedInstanceState: Bundle?) {
        authViewModel = ViewModelProvider(this@LoginScreenFragment).get(FirebaseViewModel::class.java)



        super.onCreate(savedInstanceState)
    }



    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = FragmentLoginScreenBinding.inflate(inflater,container,false)



        // Inflate the layout for this fragment
        return binding.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        //fix these line, u have to do that before the ViewCreated
        val testCurrentUser = authViewModel.authRepo.currentUserMutableLiveData

        if (testCurrentUser!=null){
            val action = LoginScreenFragmentDirections.actionLoginScreenFragmentToStudentHomeScreen()
            Navigation.findNavController(binding.root).navigate(action)

             // closing this fragment
        }



        goToRegister()
        loginButtonFunc()
        super.onViewCreated(view, savedInstanceState)
    }

    fun goToRegister(){

        binding.RegistertextSmall.setOnClickListener {
            val action = LoginScreenFragmentDirections.actionLoginScreenFragmentToRegisterPageFragment()
            Navigation.findNavController(it).navigate(action)
        }

    }

    fun loginButtonFunc(){

        binding.LoginButton.setOnClickListener {
            val email = binding.emailEditText.text.toString()
            val password = binding.passwordEditText.text.toString()

            authViewModel.loginWithEmailPassword(email, password,it)


        }
    }




    }












