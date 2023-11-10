package com.example.probandoapis

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitClient {

    private val retrofit = Retrofit.Builder()
        .baseUrl("http://192.168.101.9:8000/api/")
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    val consumirApi = retrofit.create(ApiService::class.java)
}