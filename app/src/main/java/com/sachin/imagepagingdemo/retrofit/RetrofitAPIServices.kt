package com.sachin.imagepagingdemo.retrofit

import com.sachin.imagepagingdemo.data.model.ImageDataResponseModel
import com.sachin.imagepagingdemo.data.model.ImageDataResponseModelItem
import retrofit2.http.GET
import retrofit2.http.Path

interface RetrofitAPIServices {
    @GET("list?page={page}&limit={limit}")
    suspend fun getImageList(
        @Path("page") page:Int,
        @Path("limit") limit:Int
    ):ArrayList<ImageDataResponseModelItem>
}