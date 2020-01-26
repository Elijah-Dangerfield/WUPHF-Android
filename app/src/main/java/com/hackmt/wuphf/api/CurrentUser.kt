package com.hackmt.wuphf.api

import android.net.Uri
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.storage.FirebaseStorage

object CurrentUser {

    private var auth = FirebaseAuth.getInstance()

    fun signUp(db: FirebaseFirestore,
               phone: String,
               carrier: String,
               username: String,
               email: String,
               password: String
               )
            : LiveData<Resource<Boolean>> {
        val result = MutableLiveData<Resource<Boolean>>()

        result.value = Resource.Loading()

        auth.createUserWithEmailAndPassword(email, password).addOnCompleteListener {
            if(it.isSuccessful){
                result.postValue( Resource.Success(true))
                createUserRecord(username,email,phone,carrier)
            }else{
                result.postValue( Resource.Error(false, it.exception?.localizedMessage ?: "Unknown Error"))
            }
        }

        return result
    }

    private fun createUserRecord(username: String, email: String, phone: String, carrier: String) {
        //TODO
    }

     fun signIn(email: String, pass: String): MutableLiveData<Resource<Boolean>> {
        val status : MutableLiveData<Resource<Boolean>> = MutableLiveData(Resource.Loading())

        auth.signInWithEmailAndPassword(email, pass).addOnCompleteListener {
            if(it.isSuccessful) status.value = Resource.Success(true)
            else status.value =  Resource.Error(message =it.exception?.localizedMessage ?: "Unknown Error")
        }
        return status
    }

}