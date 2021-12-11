package com.example.cybergarden.presenter.rankedLists

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import com.example.cybergarden.data.RanketItems
import com.example.cybergarden.presenter.utils.EventApi
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class RankedListsViewModel(application: Application) : AndroidViewModel(application) {

    var rankedListMLD = MutableLiveData<List<RanketItems>>()

    fun getRankedList() {
        val api = EventApi.RETROFIT_SERVICE.getRankedList()

        api.enqueue(object : Callback<List<RanketItems>> {
            override fun onResponse(
                call: Call<List<RanketItems>>,
                response: Response<List<RanketItems>>
            ) {
                rankedListMLD.value = response.body()
            }

            override fun onFailure(call: Call<List<RanketItems>>, t: Throwable) {}
        })
    }

}