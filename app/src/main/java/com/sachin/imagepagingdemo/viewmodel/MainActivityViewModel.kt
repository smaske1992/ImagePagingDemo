package com.sachin.imagepagingdemo.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.sachin.imagepagingdemo.data.model.ImageDataResponseModelItem
import com.sachin.imagepagingdemo.data.repository.NetworkRepository
import kotlinx.coroutines.launch

class MainActivityViewModel:ViewModel() {
    val imageList = MutableLiveData<ArrayList<ImageDataResponseModelItem>>()
    private val networkRepository = NetworkRepository()

    fun getImages(page:Int,limit:Int){
        viewModelScope.launch{
            val response = networkRepository.getImageList(page,limit)
            imageList.value = response
        }
    }
}