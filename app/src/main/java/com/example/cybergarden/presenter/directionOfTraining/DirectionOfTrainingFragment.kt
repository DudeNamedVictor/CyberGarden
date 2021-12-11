package com.example.cybergarden.presenter.directionOfTraining

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.cybergarden.R
import com.example.cybergarden.data.Direction
import com.example.cybergarden.data.News
import com.example.cybergarden.databinding.DirectionOfTrainingLayoutBinding
import com.example.cybergarden.presenter.newsFragment.NewsAdapter

class DirectionOfTrainingFragment : Fragment() {

    private val viewModel: DirectionOfTrainingViewModel by viewModels()
    private lateinit var binding: DirectionOfTrainingLayoutBinding
    private val data = mutableListOf<Direction>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = DirectionOfTrainingLayoutBinding.inflate(inflater, container, false)
        binding.toolbar.toolbarTitle.setText(R.string.events)

        binding.recyclerView.layoutManager = LinearLayoutManager(requireContext())
        binding.recyclerView.adapter = DirectionAdapter(data)

        viewModel.getDirection()

        viewModel.newsSizeMLD.observe(this, {
            data.addAll(it)
            binding.recyclerView.adapter?.notifyDataSetChanged()
        })

        return binding.root
    }

}