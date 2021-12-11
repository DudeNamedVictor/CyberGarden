package com.example.cybergarden.presenter.eventFragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
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

        return binding.root
    }

    private fun initializeItems() {
        binding.inDirectionOfTraining.apply {
            title.setText(R.string.in_direction_of_training)
            description.setText(R.string.choose_your_direction)
        }
        binding.careerGuidance.apply {
            title.setText(R.string.career_guidance)
            description.setText(R.string.career_guidance_test)
        }
        binding.rankedLists.apply {
            title.setText(R.string.ranked_lists)
            description.setText(R.string.ranked_lists_description)
        }
        binding.questions.apply {
            title.setText(R.string.questions)
            description.setText(R.string.questions_description)
        }
    }

    companion object {
        fun create(): EventFragment {
            return EventFragment()
        }
    }

}