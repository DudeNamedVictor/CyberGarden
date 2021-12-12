package com.example.cybergarden.presenter.singInFragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.example.cybergarden.R
import com.example.cybergarden.data.Authorisation
import com.example.cybergarden.databinding.SingInLayoutBinding

class SignInFragment : Fragment() {

    private val viewModel: SingInViewModel by viewModels()
    private lateinit var binding: SingInLayoutBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = SingInLayoutBinding.inflate(inflater, container, false)

        binding.actionButton.setOnClickListener {
            if (binding.login.text.isNullOrEmpty() || binding.password.text.isNullOrEmpty()) {
                Toast.makeText(requireContext(), R.string.error_message, Toast.LENGTH_SHORT)
                    .show()
            } else {
                viewModel.authorization(
                    Authorisation(
                        binding.login.text.toString(),
                        "",
                        "",
                        "",
                        "",
                        binding.password.text.toString()
                    )
                )
            }
        }

        viewModel.userRegistrationMLD.observe(this, {
            if (it) {
                findNavController().navigate(R.id.loginFragment_to_mainFragment)
            } else {
                Toast.makeText(requireContext(), R.string.error_login, Toast.LENGTH_SHORT).show()
            }
        })

        binding.noAccount.setOnClickListener {
            findNavController().navigate(R.id.loginFragment_to_authorisationFragment)
        }

        return binding.root
    }

}