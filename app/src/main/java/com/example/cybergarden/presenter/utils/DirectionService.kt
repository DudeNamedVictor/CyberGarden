package com.example.cybergarden.presenter.utils

import com.example.cybergarden.data.Direction
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

private val retrofit = Retrofit.Builder()
    .addConverterFactory(GsonConverterFactory.create())
    .baseUrl(Constants.NEWS_URL)
    .build()

interface DirectionService {
    @GET("/v1/program/getAll")
    fun getRankedList(): Call<List<Direction>>
}

object DirectionApi {
    val RETROFIT_SERVICE: DirectionService by lazy {
        retrofit.create(DirectionService::class.java)
    }
}