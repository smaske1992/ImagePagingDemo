package com.sachin.imagepagingdemo.retrofit

import com.google.gson.Gson
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitConfiguration {

    private const val BASE_URL = "https://picsum.photos/v2/"
    val retrofitAPIServices: RetrofitAPIServices = getRetrofitInstance().create(RetrofitAPIServices::class.java)
    private fun getRetrofitInstance():Retrofit{
        return Retrofit.Builder().baseUrl(BASE_URL).addConverterFactory(GsonConverterFactory.create()).build()
    }

}