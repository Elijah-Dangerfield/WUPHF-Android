package com.hackmt.wuphf.api

import android.net.Uri
import androidx.lifecycle.LiveData
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.storage.FirebaseStorage

object CurrentUser {

    private var auth = FirebaseAuth.getInstance()

//    fun signUp(db: FirebaseFirestore,
//               store: FirebaseStorage,
//               phone: String,
//               carrier: String,
//               username: String,
//               email: String,
//               password: String
//               )
//            : LiveData<Resource<Boolean>> {
//
////        auth.createUserWithEmailAndPassword(email, password).addOnCompleteListener {
////            if(it.isSuccessful){
////                authStatus.value = Resource.Success(true)
////                store.getReference("/user_profile_test/${uid!!}").putFile(profilePicture)
////                db.collection(Endpoints.USERS).document(uid.toString()).set(User(username, listOf()))
////            }else{
////                authStatus.value = Resource.Error(message =it.exception?.localizedMessage ?: "Unknown Error")
////            }
////        }
//
//    }
}