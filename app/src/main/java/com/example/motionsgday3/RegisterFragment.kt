package com.example.motionsgday3

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.motionsgday3.databinding.FragmentRegisterBinding

class RegisterFragment : Fragment() {
    private var _binding : FragmentRegisterBinding? = null
    private val binding get() = _binding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
            _binding = FragmentRegisterBinding.inflate(layoutInflater)
            return binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding?.apply {
            btnSigninRegister.setOnClickListener {
                navigateToLogin()
            }
            tvSignupRegister.setOnClickListener {
                val direction = RegisterFragmentDirections.actionRegisterFragmentToLoginFragment()
                findNavController().navigate(direction)
            }
            tvRegisterTitle.setOnClickListener {
                navigateToRegister()
            }
            tvForgotButtonRegister.setOnClickListener {
                navigateToRegister()
            }
            imbBackRegister.setOnClickListener {
                navigateBack()
            }
            imbAppleRegister.setOnClickListener {
                navigateToLogin()
            }
            imbFacebookRegister.setOnClickListener {
                navigateToLogin()
            }
            imbGoogleRegister.setOnClickListener {
                navigateToLogin()
            }
        }
    }

    private fun navigateToRegister() {
        findNavController().navigate(R.id.action_registerFragment_to_loginFragment)
    }

    private fun navigateToLogin() {
        binding?.apply {
            val email = tietEmailRegister.text.toString()

            val password = tietPasswordRegister.text.toString()
            if (email.isEmpty()){
                tilEmailRegister.error = "email can't empty"
            }
            else if(password.isEmpty()){
                tilPasswordRegister.error = "password can't empty"
            }
            else if(!isValidEmail(email)){
                tilEmailRegister.error = "format email it's wrong"
            }
            if (email.isNotEmpty() && password.isNotEmpty() && isValidEmail(email)){
                val direction = RegisterFragmentDirections.actionRegisterFragmentToLoginFragment(email,password)
                findNavController().navigate(direction)
            }
        }
    }

    fun isValidEmail(email : String) : Boolean{
        val emailRegex = "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+\$"
        return email.matches(emailRegex.toRegex())
    }

    private fun navigateBack(){
        findNavController().popBackStack()
    }
}