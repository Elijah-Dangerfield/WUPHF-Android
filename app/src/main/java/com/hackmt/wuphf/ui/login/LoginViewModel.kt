package com.hackmt.wuphf.ui.login

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.hackmt.wuphf.api.CurrentUser
import com.hackmt.wuphf.api.Resource

class LoginViewModel : ViewModel() {

    var loginStatus =  MutableLiveData<Resource<Boolean>>()

    fun login(email: String, password: String){
        loginStatus = CurrentUser.signIn(email, password)
    }
}