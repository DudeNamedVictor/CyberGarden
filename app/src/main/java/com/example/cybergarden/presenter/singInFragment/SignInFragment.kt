package com.example.cybergarden.presenter.singInFragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.example.cybergarden.R
import com.example.cybergarden.databinding.SingInLayoutBinding
import com.example.cybergarden.presenter.statisticFragment.SingInViewModel

class SignInFragment : Fragment() {

    private val viewModel: SingInViewModel by viewModels()
    private lateinit var binding: SingInLayoutBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = SingInLayoutBinding.inflate(inflater, container, false)

        binding.noAccount.setOnClickListener {
            findNavController().navigate(R.id.loginFragment_to_authorisationFragment)
        }

        return binding.root
    }

}