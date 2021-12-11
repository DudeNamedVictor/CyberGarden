package com.example.cybergarden.presenter.utils

import com.example.cybergarden.data.DoubleItem
import com.example.cybergarden.data.FilterReq
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.Body
import retrofit2.http.POST

private val retrofit = Retrofit.Builder()
    .addConverterFactory(GsonConverterFactory.create())
    .baseUrl(Constants.NEWS_URL)
    .build()

interface FilterService {
    @POST("/v1/filter/getRequest")
    fun postFilter(@Body filterReq: FilterReq): Call<List<DoubleItem>>
}

object FilterApi {
    val RETROFIT_SERVICE: FilterService by lazy {
        retrofit.create(FilterService::class.java)
    }
}