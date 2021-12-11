package com.example.cybergarden.presenter.utils

import com.example.cybergarden.data.Authorisation
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.Body
import retrofit2.http.POST

private val retrofit = Retrofit.Builder()
    .addConverterFactory(GsonConverterFactory.create())
    .baseUrl(Constants.NEWS_URL)
    .build()

interface AuthorisationService {
    @POST("/v1/registration/add")
    fun addUser(@Body authorisation: Authorisation): Call<Boolean>
}

object AuthorisationApi {
    val RETROFIT_SERVICE: AuthorisationService by lazy {
        retrofit.create(AuthorisationService::class.java)
    }
}