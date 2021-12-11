package com.example.cybergarden.presenter.singInFragment

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import com.example.cybergarden.data.Authorisation
import com.example.cybergarden.presenter.utils.AuthorisationApi
import com.example.cybergarden.presenter.utils.Constants
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class SingInViewModel(application: Application) : AndroidViewModel(application) {
    var userRegistrationMLD = MutableLiveData<Boolean>()

    fun authorization(authorisation : Authorisation) {
        val api = AuthorisationApi.RETROFIT_SERVICE.authorization(authorisation)

        api.enqueue(object : Callback<Boolean> {
            override fun onResponse(call: Call<Boolean>, response: Response<Boolean>) {
                userRegistrationMLD.value = response.body()
                Constants.FIRST_LAUNCH = false
            }

            override fun onFailure(call: Call<Boolean>, t: Throwable) {}
        })
    }
}