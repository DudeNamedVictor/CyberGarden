package com.example.cybergarden.presenter.dialog_fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.cybergarden.R
import com.example.cybergarden.databinding.DialogLayoutBinding
import com.example.cybergarden.presenter.utils.Constants

class DialogFragment : Fragment() {

    private lateinit var binding: DialogLayoutBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = DialogLayoutBinding.inflate(inflater, container, false)
        binding.toolbar.apply {
            toolbarTitle.setText(R.string.filter)
            back.visibility = View.VISIBLE
            back.setOnClickListener {
                findNavController().popBackStack()
            }
        }

        binding.actionButton.setOnClickListener {
            Constants.math = binding.math.isChecked
            Constants.inform = binding.inform.isChecked
            Constants.other = binding.other.isChecked
            Constants.summ = binding.summ.text.toString()
            Constants.FILTER = true
            findNavController().popBackStack()
        }

        return binding.root
    }

}