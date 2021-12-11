package com.example.cybergarden.presenter.authorisationFragment

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import com.example.cybergarden.data.Authorisation
import com.example.cybergarden.presenter.utils.AuthorisationApi
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class AuthorisationViewModel(application: Application) : AndroidViewModel(application) {

    var userRegistrationMLD = MutableLiveData<Boolean>()

    fun addUser(authorisation : Authorisation) {
        val api = AuthorisationApi.RETROFIT_SERVICE.addUser(authorisation)

        api.enqueue(object : Callback<Boolean> {
            override fun onResponse(call: Call<Boolean>, response: Response<Boolean>) {
                userRegistrationMLD.value = response.isSuccessful
            }

            override fun onFailure(call: Call<Boolean>, t: Throwable) {}
        })
    }

}