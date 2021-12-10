package com.example.cybergarden.presenter.newsFragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.cybergarden.databinding.NewsFragmentLayoutBinding

class NewsFragment : Fragment() {

    private lateinit var binding: NewsFragmentLayoutBinding
    private val viewModel: NewsViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = NewsFragmentLayoutBinding.inflate(inflater, container, false)
        binding.recyclerView.layoutManager = LinearLayoutManager(requireContext())
        binding.recyclerView.adapter = NewsAdapter(fillList())

        return binding.root
    }

    private fun fillList(): List<String> {
        val data = mutableListOf<String>()
        (0..30).forEach { i -> data.add("$i element") }
        return data
    }

    companion object {
        fun create(): NewsFragment {
            return NewsFragment()
        }
    }

}