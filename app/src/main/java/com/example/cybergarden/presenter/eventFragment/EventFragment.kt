package com.example.cybergarden.presenter.eventFragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.cybergarden.R
import com.example.cybergarden.databinding.EventFragmentLayoutBinding

class EventFragment : Fragment() {

    private lateinit var binding: EventFragmentLayoutBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = EventFragmentLayoutBinding.inflate(inflater, container, false)
        binding.toolbar.toolbarTitle.setText(R.string.enrollee)
        initializeItems()
        setOnClickListeners()

        return binding.root
    }

    private fun initializeItems() {
        binding.inDirectionOfTraining.apply {
            title.setText(R.string.in_direction_of_training)
            description.setText(R.string.choose_your_direction)
        }
        binding.rankedLists.apply {
            title.setText(R.string.ranked_lists)
            description.setText(R.string.ranked_lists_description)
        }
        binding.questions.apply {
            title.setText(R.string.questions)
            description.setText(R.string.questions_description)
        }
        binding.email.apply {
            title.setText(R.string.email)
            description.setText(R.string.email_description)
        }
    }

    private fun setOnClickListeners() {
        binding.rankedLists.root.setOnClickListener {
            findNavController().navigate(R.id.ranked_list_fragment)
        }
        binding.questions.root.setOnClickListener {
            findNavController().navigate(R.id.questions_fragment)
        }
        binding.inDirectionOfTraining.root.setOnClickListener {
            findNavController().navigate(R.id.direction_of_training)
        }
        binding.email.root.setOnClickListener {
            findNavController().navigate(R.id.email_fragment)
        }
    }

    companion object {
        fun create(): EventFragment {
            return EventFragment()
        }
    }

}