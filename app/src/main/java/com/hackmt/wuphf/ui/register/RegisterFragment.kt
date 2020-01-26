package com.hackmt.wuphf.ui.register


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import com.hackmt.wuphf.R
import kotlinx.android.synthetic.main.fragment_register.*
import kotlinx.android.synthetic.main.fragment_start.*
import kotlinx.android.synthetic.main.fragment_start.btn_register

/**
 * A simple [Fragment] subclass.
 */
class RegisterFragment : Fragment() {

    val navController: NavController by lazy {
        NavHostFragment.findNavController(this)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_register, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        btn_register.setOnClickListener{
            navController.navigate(R.id.action_registerFragment_to_messgageFragment)
        }
    }
}
