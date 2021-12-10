package com.example.cybergarden.presenter

import com.example.cybergarden.R
import com.example.cybergarden.presenter.newsFragment.NewsFragment
import com.example.cybergarden.presenter.statisticFragment.StatisticFragment
import com.example.cybergarden.presenter.testsFragment.TestsFragment

interface ResourceStore {
    companion object {
        val tabList = listOf(R.string.news, R.string.tests, R.string.statistic)

        val pagerFragments =
            listOf(NewsFragment.create(), TestsFragment.create(), StatisticFragment.create())
    }
}