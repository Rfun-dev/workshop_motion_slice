package com.example.motionsgday3

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.motionsgday3.databinding.FragmentSelectionBinding


class SelectionFragment : Fragment() {
    private var _binding: FragmentSelectionBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        _binding = FragmentSelectionBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(
            view,
            savedInstanceState
        )

        binding.apply {
            btnSignin.setOnClickListener {
                navigateToLogin()
            }
            btnSignup.setOnClickListener {
                navigateToRegister()
            }
        }

//        binding.btnSignin.setOnClickListener {
//            navigateToLogin()
//        }
//        binding.btnSignup.setOnClickListener {
//            navigateToRegister()
//        }
    }

    private fun navigateToLogin(){
        findNavController().navigate(R.id.action_selectionFragment_to_loginFragment)

    }

    private fun navigateToRegister(){
        val direction = SelectionFragmentDirections.actionSelectionFragmentToRegisterFragment()
        findNavController().navigate(direction)
    }
}