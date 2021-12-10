package com.example.cybergarden.presenter.currentNewsFragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.cybergarden.databinding.CurrentNewsLayoutBinding
import com.example.cybergarden.presenter.newsFragment.News

class CurrentNewsFragment(val news: News) : Fragment() {

    private lateinit var binding: CurrentNewsLayoutBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = CurrentNewsLayoutBinding.inflate(inflater, container, false)
        binding.apply {
            title.text = news.title
            description.text = news.description
            date.text = news.data
        }

        return binding.root
    }

}