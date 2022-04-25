package com.sachin.imagepagingdemo.data.model

data class ImageDataResponseModelItem(
    val author: String,
    val download_url: String,
    val height: Int,
    val id: String,
    val url: String,
    val width: Int
)

data class ImageDataResponseModel(
    val imageList:ArrayList<ImageDataResponseModelItem>

    )