package com.example.cybergarden.presenter.rankedLists

import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.cybergarden.R
import com.example.cybergarden.data.RanketItems
import com.example.cybergarden.databinding.RankedListLayoutBinding

class RankedListsFragment : Fragment() {

    private val viewModel: RankedListsViewModel by viewModels()
    private lateinit var binding: RankedListLayoutBinding
    private var data = mutableListOf<RanketItems>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = RankedListLayoutBinding.inflate(inflater, container, false)

        binding.toolbar.toolbarTitle.setText(R.string.events)

        binding.recyclerView.layoutManager = LinearLayoutManager(requireContext())
        binding.recyclerView.adapter = RankedListAdapter(data)

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel.getRankedList()
        setObservers()

        val mainHandler = Handler(Looper.getMainLooper())

        mainHandler.post(object : Runnable {
            override fun run() {
                viewModel.getRankedList()
                mainHandler.postDelayed(this, 5000)
            }
        })

    }

    private fun setObservers() {
        viewModel.rankedListMLD.observe(this, { it ->
            data.clear()
            data.addAll(it.sortedByDescending { it.score })
            binding.recyclerView.adapter?.notifyDataSetChanged()
        })
    }

}