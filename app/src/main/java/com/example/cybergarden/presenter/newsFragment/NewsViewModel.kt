package com.example.cybergarden.presenter.newsFragment

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import com.example.cybergarden.presenter.utils.NewsApi
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class NewsViewModel(application: Application) : AndroidViewModel(application) {

    var newsSizeMLD = MutableLiveData<Int>()
    var newsMLD = MutableLiveData<List<News>>()

    fun newsSizeRequest() {
        val api = NewsApi.RETROFIT_SERVICE.getAllCount()

        api.enqueue(object : Callback<Int> {
            override fun onResponse(
                call: Call<Int>,
                response: Response<Int>
            ) {
                newsSizeMLD.value = response.body()
            }

            override fun onFailure(call: Call<Int>, t: Throwable) {}
        })
    }

    fun getNews() {
        val api = NewsApi.RETROFIT_SERVICE.getAllNews()

        api.enqueue(object : Callback<List<News>> {
            override fun onResponse(
                call: Call<List<News>>,
                response: Response<List<News>>
            ) {
                newsMLD.value = response.body()
            }

            override fun onFailure(call: Call<List<News>>, t: Throwable) {}
        })
    }

}