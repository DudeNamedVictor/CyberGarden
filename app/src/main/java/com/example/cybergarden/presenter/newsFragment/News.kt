package com.example.cybergarden.presenter.newsFragment

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class News(val image: String, val title: String, val description: String, val data: String) :
    Parcelable