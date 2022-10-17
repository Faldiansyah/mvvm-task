package com.cowok.hijrah.chapter6topic4mvvm.network

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitCar {
    const val BASE_URL = "https://rent-cars-api.herokuapp.com/"

    val instance: RestfullApiCar by lazy {
        val retrofit = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
        retrofit.create(RestfullApiCar::class.java)
    }
}