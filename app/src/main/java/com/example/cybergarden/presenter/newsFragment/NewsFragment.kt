package com.example.cybergarden.presenter.newsFragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.example.cybergarden.databinding.NewsFragmentLayoutBinding

class NewsFragment : Fragment() {

    private lateinit var binding: NewsFragmentLayoutBinding
    private val viewModel: NewsViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = NewsFragmentLayoutBinding.inflate(inflater, container, false)

        return binding.root
    }

}