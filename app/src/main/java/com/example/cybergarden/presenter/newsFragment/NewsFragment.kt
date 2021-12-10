package com.example.cybergarden.presenter.newsFragment

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.cybergarden.R
import com.example.cybergarden.databinding.NewsFragmentLayoutBinding

class NewsFragment : Fragment() {

    private val viewModel: NewsViewModel by viewModels()

    private lateinit var binding: NewsFragmentLayoutBinding
    private val data = mutableListOf<News>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = NewsFragmentLayoutBinding.inflate(inflater, container, false)
        binding.toolbar.toolbarTitle.setText(R.string.events)

        binding.recyclerView.layoutManager = LinearLayoutManager(requireContext())
        binding.recyclerView.adapter = NewsAdapter(fillList())

        binding.recyclerView.addOnItemTouchListener(
            NewsAdapter.RecyclerItemClickListener(binding.recyclerView,
                object : NewsAdapter.RecyclerItemClickListener.OnItemClickListener {
                    override fun onItemClick(view: View, position: Int) {
                        Log.d("adadwadadada", position.toString())
                    }
                })
        )

        return binding.root
    }

    private fun fillList(): List<News> {
        data.add(News("adwadadw", "afrhjxh", "sefesgseegsg", "affsegsgsf"))
        data.add(News("adwadadw", "afrhjxh", "sefesgseegsg", "affsegsgsf"))
        data.add(News("adwadadw", "afrhjxh", "sefesgseegsg", "affsegsgsf"))
        data.add(News("adwadadw", "afrhjxh", "sefesgseegsg", "affsegsgsf"))
        data.add(News("adwadadw", "afrhjxh", "sefesgseegsg", "affsegsgsf"))
        data.add(News("adwadadw", "afrhjxh", "sefesgseegsg", "affsegsgsf"))
        data.add(News("adwadadw", "afrhjxh", "sefesgseegsg", "affsegsgsf"))
        data.add(News("adwadadw", "afrhjxh", "sefesgseegsg", "affsegsgsf"))
        return data
    }

    companion object {
        fun create(): NewsFragment {
            return NewsFragment()
        }
    }

}