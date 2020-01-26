package com.hackmt.wuphf.ui.start


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import com.hackmt.wuphf.R
import kotlinx.android.synthetic.main.fragment_start.*


class StartFragmnet : Fragment() {

    val navController: NavController by lazy {
        NavHostFragment.findNavController(this)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_start, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)


        btn_register.setOnClickListener{
            navController.navigate(R.id.action_startFragmnet_to_registerFragment)
        }

        btn_login.setOnClickListener{
            navController.navigate(R.id.action_startFragmnet_to_loginFragment)
        }
    }
}
