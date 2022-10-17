package com.cowok.hijrah.chapter6topic4mvvm.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.cowok.hijrah.chapter6topic4mvvm.model.getAllCarItem
import com.cowok.hijrah.chapter6topic4mvvm.network.RetrofitCar
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class ViewModelCar: ViewModel() {
    private lateinit var liveDataCar: MutableLiveData<List<getAllCarItem>?>

    init {
        liveDataCar = MutableLiveData()
    }

    fun getliveDataCar(): MutableLiveData<List<getAllCarItem>?> {
        return liveDataCar
    }

    fun callApiCar(){
        RetrofitCar.instance.getAllCar()
            .enqueue(object : Callback<List<getAllCarItem>> {
                override fun onResponse(
                    call: Call<List<getAllCarItem>>,
                    response: Response<List<getAllCarItem>>
                ) {
                    if (response.isSuccessful){
                        liveDataCar.postValue(response.body())
                    }else{
                        liveDataCar.postValue(null)
                    }
                }

                override fun onFailure(call: Call<List<getAllCarItem>>, t: Throwable) {
                    liveDataCar.postValue(null)
                }

            })
    }
}