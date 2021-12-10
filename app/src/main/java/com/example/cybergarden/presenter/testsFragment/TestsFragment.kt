package com.example.cybergarden.presenter.testsFragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.cybergarden.databinding.TestsFragmentLayoutBinding
import com.example.cybergarden.presenter.statisticFragment.StatisticFragment

class TestsFragment : Fragment() {

    private lateinit var binding: TestsFragmentLayoutBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = TestsFragmentLayoutBinding.inflate(inflater, container, false)

        return binding.root
    }

    companion object {
        fun create(): TestsFragment {
            return TestsFragment()
        }
    }

}