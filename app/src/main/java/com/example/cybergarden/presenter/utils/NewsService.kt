package com.example.cybergarden.presenter.utils

import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

private val retrofit = Retrofit.Builder()
    .addConverterFactory(GsonConverterFactory.create())
    .baseUrl(Constants.NEWS_URL)
    .build()

interface CatsService {
    @GET("/v1/news/getAllCount")
    fun getAllCount(): Call<Int>
}

object NewsApi {
    val RETROFIT_SERVICE: CatsService by lazy {
        retrofit.create(CatsService::class.java)
    }
}