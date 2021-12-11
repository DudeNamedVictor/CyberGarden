package com.example.cybergarden.data

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class News(val image: String, val title: String, val description: String, val data: String) :
    Parcelable