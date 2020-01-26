package com.hackmt.wuphf.ui.login


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import com.hackmt.wuphf.R
import com.hackmt.wuphf.api.Resource
import com.hackmt.wuphf.util.hideKeyBoardOnPressAway
import com.hackmt.wuphf.util.showWhen
import kotlinx.android.synthetic.main.fragment_login.*
import kotlinx.android.synthetic.main.fragment_start.*
import kotlinx.android.synthetic.main.fragment_start.btn_login

class LoginFragment : Fragment() {
    val navController: NavController by lazy {
        NavHostFragment.findNavController(this)
    }

    val viewModel: LoginViewModel by lazy {
        ViewModelProviders.of(this).get(LoginViewModel::class.java)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_login, container, false)
    }


    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        btn_login.setOnClickListener{
            viewModel.login(tv_email_input.text.trim().toString(), tv_password_input.text.trim().toString())
        }

        listOf(tv_email_input, tv_password_input).forEach { it.hideKeyBoardOnPressAway() }

        viewModel.loginStatus.observe(viewLifecycleOwner, Observer {status ->

            pb_login.showWhen(status is Resource.Loading)
            when(status){
                is Resource.Success ->  navController.navigate(R.id.action_loginFragment_to_messgageFragment)
                is Resource.Loading -> btn_login.visibility = View.INVISIBLE
                is Resource.Error -> Toast.makeText(context, status.message,Toast.LENGTH_LONG ).show()
            }
        })
    }
}
