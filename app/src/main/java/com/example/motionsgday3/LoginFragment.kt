package com.example.motionsgday3

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.example.motionsgday3.databinding.FragmentLoginBinding


class LoginFragment : Fragment() {
    private var _binding: FragmentLoginBinding? = null
    private val binding get() = _binding!!

    private val args : LoginFragmentArgs by navArgs()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        _binding = FragmentLoginBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(
            view,
            savedInstanceState
        )

        val username = args.email
        val password = args.password

        binding.apply {
            if (username?.isNotEmpty() as Boolean && password?.isNotEmpty() as Boolean){
                tietUsernameLogin.setText(username)
                tietPasswordLogin.setText(password)
            }
            btnSigninLogin.setOnClickListener {
                navigateToHome()
            }
            tvSignupLogin.setOnClickListener {
                navigateToRegister()
            }
            tvForgotButtonLogin.setOnClickListener {
                navigateToRegister()
            }
            imbBackLogin.setOnClickListener {
                navigateBack()
            }
            imbAppleLogin.setOnClickListener {
                navigateToHomeWithPlatform("Apple")
            }
            imbFacebookLogin.setOnClickListener {
                navigateToHomeWithPlatform("Facebook")
            }
            imbGoogleLogin.setOnClickListener {
                navigateToHomeWithPlatform("Google")
            }
        }
    }

    private fun navigateToRegister() {
       findNavController().navigate(R.id.action_loginFragment_to_registerFragment)
    }

    private fun navigateToHome() {
        binding.apply {
            val username = tietUsernameLogin.text.toString()
            val password = tietPasswordLogin.text.toString()
            if(username.isEmpty()){
                tilUsernameLogin.error = "username can't empty"
            }else if(password.isEmpty()){
                tilPasswordLogin.error = "password can't empty"
            }
            if(username.isNotEmpty() && password.isNotEmpty()){
                val direction = LoginFragmentDirections.actionLoginFragmentToHomeFragment(username,password)
                findNavController().navigate(direction)
            }
        }
    }

    private fun navigateToHomeWithPlatform(platform : String) {
        binding.apply {
            val direction = LoginFragmentDirections.actionLoginFragmentToHomeFragment(platform = platform)
            findNavController().navigate(direction)
        }
    }


    private fun navigateBack(){
        findNavController().popBackStack()
    }

}