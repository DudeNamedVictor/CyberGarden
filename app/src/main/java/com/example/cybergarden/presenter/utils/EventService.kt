package com.example.cybergarden.presenter.utils

import com.example.cybergarden.data.RanketItems
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

private val retrofit = Retrofit.Builder()
    .addConverterFactory(GsonConverterFactory.create())
    .baseUrl(Constants.NEWS_URL)
    .build()

interface EventService {
    @GET("/v1/ranklist/getAll")
    fun getRankedList(): Call<List<RanketItems>>
}

object EventApi {
    val RETROFIT_SERVICE: EventService by lazy {
        retrofit.create(EventService::class.java)
    }
}