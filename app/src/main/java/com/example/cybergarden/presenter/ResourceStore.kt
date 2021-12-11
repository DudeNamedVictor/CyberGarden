package com.example.cybergarden.presenter

import com.example.cybergarden.R
import com.example.cybergarden.presenter.eventFragment.EventFragment
import com.example.cybergarden.presenter.newsFragment.NewsFragment

interface ResourceStore {
    companion object {
        val tabList = listOf(R.string.events, R.string.enrollee)

        val pagerFragments =
            listOf(NewsFragment.create(), EventFragment.create())
    }
}