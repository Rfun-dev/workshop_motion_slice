package com.example.motionsgday3

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.fragment.navArgs
import com.example.motionsgday3.databinding.FragmentHomeBinding

class HomeFragment : Fragment() {
    var _binding : FragmentHomeBinding? = null
    val binding get() = _binding
    val args : HomeFragmentArgs by navArgs()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentHomeBinding.inflate(layoutInflater)
        return binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val platform = args.platform
        val username = args.username
        if(platform?.isNotEmpty() as Boolean){
            showToast("signup with $platform Account")
        }
        if(username?.isNotEmpty() as Boolean){
            showToast("hii, $username")
        }
    }

    private fun showToast(value: String) {
        Toast.makeText(context,value,Toast.LENGTH_SHORT).show()
    }
}