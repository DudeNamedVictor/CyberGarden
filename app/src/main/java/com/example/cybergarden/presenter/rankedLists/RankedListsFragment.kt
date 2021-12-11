package com.example.cybergarden.presenter.rankedLists

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.cybergarden.databinding.RankedListLayoutBinding

class RankedListsFragment : Fragment() {

    private lateinit var binding: RankedListLayoutBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = RankedListLayoutBinding.inflate(inflater, container, false)

        return binding.root
    }

}