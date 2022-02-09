package com.udacity.shoestore.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.navigation.fragment.findNavController
import com.udacity.shoestore.R
import com.udacity.shoestore.databinding.FragmentLoginBinding
import kotlinx.android.synthetic.main.fragment_login.*


class LoginFragment : Fragment() {

    private lateinit var binding: FragmentLoginBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_login,container,false)

        binding.signUpButton.setOnClickListener {
            if (validateUserInfo()) {
                findNavController().navigate(R.id.action_loginFragment_to_welcomeFragment)
            } else {
                Toast.makeText(requireContext(), "Incorrect username/password please check again", Toast.LENGTH_LONG).show()
            }
        }

        binding.loginButton.setOnClickListener {
            if (validateUserInfo()) {
                findNavController().navigate(R.id.action_loginFragment_to_welcomeFragment)
            } else {
                Toast.makeText(activity, "Incorrect username/password please check again", Toast.LENGTH_LONG).show()
            }
        }


        // Inflate the layout for this fragment
        return binding.root
    }

    private fun validateUserInfo(): Boolean {

        val name = editTextEmail.text.toString()
        val password = editTextPassword.text.toString()

        return !(name.isEmpty() || password.isEmpty())

    }

}