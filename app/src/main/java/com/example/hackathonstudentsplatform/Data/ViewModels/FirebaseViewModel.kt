package com.example.hackathonstudentsplatform.Data.ViewModels

import android.content.Context
import android.view.View
import androidx.lifecycle.ViewModel
import com.example.hackathonstudentsplatform.Data.Models.UserModel
import com.example.hackathonstudentsplatform.Data.Repositorys.AuthRepository
import com.example.hackathonstudentsplatform.Data.Repositorys.FirestoreRepository
import com.google.firebase.firestore.auth.User
import kotlinx.coroutines.*

class FirebaseViewModel:ViewModel() {

    val authRepo = AuthRepository()
    val FirestoreRepos = FirestoreRepository()
    lateinit var userModel: UserModel



    fun loginWithEmailPassword(email:String,password:String,view:View){
        authRepo.signInWithEmailPassword(email, password,view)
    }

    fun logOut(view: View){
        authRepo.logOut(view)
    }

    fun registerWithEmailPassword(email:String,password: String,name:String = "",surname:String="",phoneNum:String="",view:View){
        authRepo.registerWithEmailPassword(email,password,surname,phoneNum,name, view = view)
    }

    suspend fun getUserDatas():UserModel{


        val deneme = FirestoreRepos.getUserDatas()





        return deneme




    }



}




