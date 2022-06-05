package com.example.hackathonstudentsplatform.Data.Repositorys

import android.content.Context
import android.widget.Toast
import androidx.lifecycle.MutableLiveData
import com.example.hackathonstudentsplatform.Data.Models.UserModel
import com.example.hackathonstudentsplatform.databinding.FragmentProfilePageBinding
import com.google.firebase.auth.FirebaseAuth

import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.SetOptions
import com.google.firebase.firestore.auth.User
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.tasks.await

class FirestoreRepository {

    lateinit var firestore: FirebaseFirestore
    lateinit var hashMap: HashMap<String,String>
    lateinit var auth:FirebaseAuth
    lateinit var userModel:UserModel
    lateinit var FirestoreRepos:FirestoreRepository
    lateinit var emailList:ArrayList<String>

    var user_email = MutableLiveData<String>()
    var user_name = MutableLiveData<String>()
    var user_surname = MutableLiveData<String>()
    var user_phoneNum = MutableLiveData<String>()



    var UpuserEmail = MutableLiveData<String>()
    var UpuserName = MutableLiveData<String>()
    var UpuserPhoneNum = MutableLiveData<String>()
    var UpuserSurname = MutableLiveData<String>()




    suspend fun getUserDatas():UserModel{

        auth = FirebaseAuth.getInstance()
        FirestoreRepos = FirestoreRepository()
        var currentEmail = auth.currentUser!!.email
        firestore = FirebaseFirestore.getInstance()




        val findUser = firestore.collection("Users").whereEqualTo("email",currentEmail)

        val docs = findUser.get().await().documents
        for (i in docs){
            user_email.value = i.data!!["email"].toString()
            user_name.value = i.data!!["name"].toString()
            user_surname.value = i.data!!.get("surname").toString()
            user_phoneNum.value = i.data!!["phoneNumber"].toString()
        }


        userModel = UserModel(Name = user_name.value!!, Surname = user_surname.value!!, PhoneNum = user_phoneNum.value!!, email = user_email.value!!)



        return userModel






    }



    fun addUserToFirestore(user: UserModel){

        firestore = FirebaseFirestore.getInstance()
        runBlocking {

            val Name = user.Name
            val Surname = user.Surname
            val PhoneNum = user.PhoneNum
            val email = user.email

            hashMap = HashMap()
            hashMap.put("name",Name)
            hashMap.put("surname",Surname)
            hashMap.put("phoneNum",PhoneNum)
            hashMap.put("email",email)


            firestore.collection("Users").add(hashMap).await()

        }


    }


    fun updateUserInfos(binding: FragmentProfilePageBinding,context: Context) {


        UpuserEmail.value = binding.EmailTextInput.text.toString()
        UpuserName.value = binding.NameTextInput.text.toString()
        UpuserSurname.value = binding.SurnameTextInput.text.toString()
        UpuserPhoneNum.value = binding.PhoneTextInput.text.toString()


        val UpUserhash = HashMap<String,String>()
        UpUserhash.put("email", UpuserEmail.value!!)
        UpUserhash.put("name", UpuserName.value!!)
        UpUserhash.put("surname", UpuserSurname.value!!)
        UpUserhash.put("phoneNumber", UpuserPhoneNum.value!!)


        auth = FirebaseAuth.getInstance()
        val currentEmail = auth.currentUser!!.email
        firestore = FirebaseFirestore.getInstance()

        val query =  firestore.collection("Users").whereEqualTo("email",currentEmail).get()
        query.addOnSuccessListener {
            for (doc in it) {
                firestore.collection("Users").document(doc.id).set(UpUserhash, SetOptions.merge()).addOnSuccessListener {
                    Toast.makeText(context, "Update Başarılı", Toast.LENGTH_LONG).show()

                }
            }
        }



    }



}





