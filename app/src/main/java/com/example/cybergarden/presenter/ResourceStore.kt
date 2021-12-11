package com.example.cybergarden.presenter

import com.example.cybergarden.R
import com.example.cybergarden.presenter.eventFragment.EventFragment
import com.example.cybergarden.presenter.newsFragment.NewsFragment
import com.example.cybergarden.presenter.testsFragment.TestsFragment

interface ResourceStore {
    companion object {
        val tabList = listOf(R.string.news, R.string.events, R.string.tests)

        val pagerFragments =
            listOf(NewsFragment.create(), EventFragment.create(), TestsFragment.create())
    }
}