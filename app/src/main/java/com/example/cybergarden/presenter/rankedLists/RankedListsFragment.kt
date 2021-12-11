package com.example.cybergarden.presenter.rankedLists

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.cybergarden.R
import com.example.cybergarden.databinding.RankedListLayoutBinding

class RankedListsFragment : Fragment() {

    private val viewModel: RankedListsViewModel by viewModels()
    private lateinit var binding: RankedListLayoutBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = RankedListLayoutBinding.inflate(inflater, container, false)

        binding.toolbar.toolbarTitle.setText(R.string.events)

        binding.recyclerView.layoutManager = LinearLayoutManager(requireContext())
        binding.recyclerView.adapter = RankedListAdapter(testData())

        return binding.root
    }

    private fun testData(): List<RanketItems> {
        var data = mutableListOf<RanketItems>()
        data.add(RanketItems("adwdawdawdsa", "12"))
        data.add(RanketItems("bege4g4", "13"))
        data.add(RanketItems("zrbzvzzs", "12"))
        data.add(RanketItems("g4aeggs", "32"))
        data.add(RanketItems("F3FFESFZ", "12421"))
        data.add(RanketItems("gsgeg4g", "43"))
        return data
    }

}