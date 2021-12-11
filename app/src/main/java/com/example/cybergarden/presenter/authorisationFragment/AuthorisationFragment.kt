package com.example.cybergarden.presenter.authorisationFragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.example.cybergarden.R
import com.example.cybergarden.data.Authorisation
import com.example.cybergarden.databinding.AuthorisationFragmentLayoutBinding

class AuthorisationFragment : Fragment() {

    private val viewModel: AuthorisationViewModel by viewModels()
    private lateinit var binding: AuthorisationFragmentLayoutBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = AuthorisationFragmentLayoutBinding.inflate(inflater, container, false)

        binding.actionButton.setOnClickListener {
            viewModel.addUser(
                Authorisation(
                    binding.login.text.toString(),
                    binding.fio.text.toString(),
                    "",
                    binding.mobilePhone.text.toString(),
                    binding.snils.text.toString(),
                    binding.password.text.toString()
                )
            )
        }

        viewModel.userRegistrationMLD.observe(this, {
            if (it) {
                findNavController().navigate(R.id.authorisationFragment_to_mainFragment)
            }
        })

        return binding.root
    }

}