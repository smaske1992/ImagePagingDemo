package com.sachin.imagepagingdemo.data.repository

import com.sachin.imagepagingdemo.retrofit.RetrofitConfiguration

class NetworkRepository {
    suspend fun getImageList(page:Int,limit:Int) = RetrofitConfiguration.retrofitAPIServices.getImageList(page,limit)
}