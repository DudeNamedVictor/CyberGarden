package com.example.cybergarden.presenter.directionOfTraining

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import com.example.cybergarden.data.Direction
import com.example.cybergarden.data.DoubleItem
import com.example.cybergarden.data.FilterReq
import com.example.cybergarden.presenter.utils.DirectionApi
import com.example.cybergarden.presenter.utils.FilterApi
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class DirectionOfTrainingViewModel(application: Application) : AndroidViewModel(application) {
    var newsSizeMLD = MutableLiveData<List<Direction>>()

    fun getDirection() {
        val api = DirectionApi.RETROFIT_SERVICE.getRankedList()

        api.enqueue(object : Callback<List<Direction>> {
            override fun onResponse(
                call: Call<List<Direction>>,
                response: Response<List<Direction>>
            ) {
                newsSizeMLD.value = response.body()
            }

            override fun onFailure(call: Call<List<Direction>>, t: Throwable) {}
        })
    }

    fun postFilter(filter: FilterReq) {
        val api = FilterApi.RETROFIT_SERVICE.postFilter(filter)

        api.enqueue(object : Callback<List<DoubleItem>> {
            override fun onResponse(
                call: Call<List<DoubleItem>>,
                response: Response<List<DoubleItem>>
            ) {
                newsSizeMLD.value = response.body()?.map { it.programDto }
            }

            override fun onFailure(call: Call<List<DoubleItem>>, t: Throwable) {}
        })
    }

}