package com.example.clickr

import retrofit2.Call
import retrofit2.http.GET

interface apiInterface {

    @GET("photos")
    fun getData(): Call<DataModel>

}