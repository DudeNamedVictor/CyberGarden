package com.example.cybergarden.presenter

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.cybergarden.databinding.MainActivityLayoutBinding
import com.google.android.material.tabs.TabLayoutMediator

class MainActivity : AppCompatActivity() {

    private lateinit var binding: MainActivityLayoutBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = MainActivityLayoutBinding.inflate(layoutInflater)
        val view: View = binding.root
        setContentView(view)

        renderViewPager()
        renderTabLayer()

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