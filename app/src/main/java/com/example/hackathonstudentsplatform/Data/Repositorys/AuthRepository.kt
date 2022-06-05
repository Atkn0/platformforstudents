package com.example.hackathonstudentsplatform.Data.Repositorys

import android.view.View
import android.widget.Toast
import androidx.lifecycle.MutableLiveData
import androidx.navigation.Navigation
import com.example.hackathonstudentsplatform.Data.Models.UserModel
import com.example.hackathonstudentsplatform.Views.LoginScreenFragmentDirections
import com.example.hackathonstudentsplatform.Views.RegisterPageFragmentDirections
import com.example.hackathonstudentsplatform.Views.StudentHomeScreenDirections
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.runBlocking

class AuthRepository {

    private var auth:FirebaseAuth = FirebaseAuth.getInstance()
    val currentUserMutableLiveData = auth.currentUser
    val FireRepo = FirestoreRepository()


    fun logOut(view: View){

        runBlocking {
            auth.signOut()
            println("SignOut Oldu")
        }

        val action = StudentHomeScreenDirections.actionStudentHomeScreenToLoginScreenFragment()
        Navigation.findNavController(view).navigate(action)


    }


    fun signInWithEmailPassword(email:String,password:String,view:View){
        auth.signInWithEmailAndPassword(email, password).addOnCompleteListener{
            when {
                it.isSuccessful-> {



                    val action = LoginScreenFragmentDirections.actionLoginScreenFragmentToStudentHomeScreen()
                    Navigation.findNavController(view).navigate(action)


                }


            }
        }

    }


    fun registerWithEmailPassword(email:String, password: String,Surname:String = "",PhoneNum:String = "",Name:String = "",view:View){
        auth.createUserWithEmailAndPassword(email,password).addOnCompleteListener {
            when {
                it.isSuccessful -> {
                    val userModel = UserModel(Name = Name,Surname = Surname,PhoneNum = PhoneNum,email = email)
                    FireRepo.addUserToFirestore(userModel)

                    val action = RegisterPageFragmentDirections.actionRegisterPageFragmentToStudentHomeScreen()
                    Navigation.findNavController(view).navigate(action)


                }
            }
        }
    }






}