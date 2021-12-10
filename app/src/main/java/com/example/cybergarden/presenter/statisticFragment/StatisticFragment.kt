package com.example.cybergarden.presenter.statisticFragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.cybergarden.databinding.StatisticFragmentLauoutBinding

class StatisticFragment : Fragment() {

    private lateinit var binding: StatisticFragmentLauoutBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = StatisticFragmentLauoutBinding.inflate(inflater, container, false)

        return binding.root
    }

    companion object {
        fun create(): StatisticFragment {
            return StatisticFragment()
        }
    }

}