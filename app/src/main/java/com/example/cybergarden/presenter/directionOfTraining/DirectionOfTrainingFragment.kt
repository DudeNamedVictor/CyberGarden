package com.example.cybergarden.presenter.directionOfTraining

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.example.cybergarden.databinding.DirectionOfTrainingLayoutBinding

class DirectionOfTrainingFragment : Fragment() {

    private val viewModel: DirectionOfTrainingViewModel by viewModels()
    private lateinit var binding: DirectionOfTrainingLayoutBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = DirectionOfTrainingLayoutBinding.inflate(inflater, container, false)

        return binding.root
    }

}