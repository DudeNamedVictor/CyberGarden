package com.example.cybergarden.presenter

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.cybergarden.databinding.MainFragmentLayoutBinding
import com.google.android.material.tabs.TabLayoutMediator

class MainFragment : Fragment() {

    private lateinit var binding: MainFragmentLayoutBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = MainFragmentLayoutBinding.inflate(inflater, container, false)
        renderViewPager()
        renderTabLayer()

        return binding.root
    }

    private fun renderViewPager() {
        binding.viewpager.adapter = object : FragmentStateAdapter(this) {

            override fun createFragment(position: Int): Fragment {
                return ResourceStore.pagerFragments[position]
            }

            override fun getItemCount(): Int {
                return ResourceStore.tabList.size
            }
        }
    }

    private fun renderTabLayer() {
        TabLayoutMediator(binding.tabs, binding.viewpager) { tab, position ->
            tab.text = getString(ResourceStore.tabList[position])
        }.attach()
    }

}