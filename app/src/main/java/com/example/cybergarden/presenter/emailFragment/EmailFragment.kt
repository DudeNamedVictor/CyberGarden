package com.example.cybergarden.presenter.emailFragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.cybergarden.R
import com.example.cybergarden.databinding.EmailLayoutBinding

class EmailFragment : Fragment() {

    private lateinit var binding: EmailLayoutBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = EmailLayoutBinding.inflate(inflater, container, false)
        binding.toolbar.apply {
            toolbarTitle.setText(R.string.email)
            back.visibility = View.VISIBLE
            back.setOnClickListener {
                findNavController().popBackStack()
            }
        }

        binding.actionButton.setOnClickListener {
            if (binding.email.text.isNullOrEmpty() || binding.message.text.isNullOrEmpty()) {
                Toast.makeText(requireContext(), R.string.error_message, Toast.LENGTH_SHORT)
                    .show()
            } else {
                Toast.makeText(requireContext(), R.string.success_message, Toast.LENGTH_SHORT)
                    .show()
                findNavController().popBackStack()
            }
        }

        return binding.root
    }

}