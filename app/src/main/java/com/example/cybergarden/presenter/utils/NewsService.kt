package com.example.cybergarden.presenter.utils

import com.example.cybergarden.data.News
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST

private val retrofit = Retrofit.Builder()
    .addConverterFactory(GsonConverterFactory.create())
    .baseUrl(Constants.NEWS_URL)
    .build()

interface NewsService {
    @GET("/v1/news/getAllCount")
    fun getAllCount(): Call<Int>

    @POST("/v1/news/getPaged")
    fun getNews(@Body page: Int): Call<List<News>>

    @GET("/v1/news/getAll")
    fun getAllNews(): Call<List<News>>
}

object NewsApi {
    val RETROFIT_SERVICE: NewsService by lazy {
        retrofit.create(NewsService::class.java)
    }
}