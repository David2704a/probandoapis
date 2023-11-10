package com.example.probandoapis

import retrofit2.Call
import retrofit2.http.GET

interface ApiService {

    @GET("clientes")
    fun getTraer(): Call<Cliente>
}