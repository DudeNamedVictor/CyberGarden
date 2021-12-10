package com.example.cybergarden.presenter.eventFragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.cybergarden.databinding.EventFragmentLayoutBinding

class EventFragment : Fragment() {

    private lateinit var binding: EventFragmentLayoutBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = EventFragmentLayoutBinding.inflate(inflater, container, false)

        return binding.root
    }

    companion object {
        fun create(): EventFragment {
            return EventFragment()
        }
    }

}