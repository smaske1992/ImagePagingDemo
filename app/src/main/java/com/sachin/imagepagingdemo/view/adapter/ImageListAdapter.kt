package com.sachin.imagepagingdemo.view.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.sachin.imagepagingdemo.R
import com.sachin.imagepagingdemo.data.model.ImageDataResponseModel
import com.sachin.imagepagingdemo.data.model.ImageDataResponseModelItem
import com.sachin.imagepagingdemo.databinding.AdapterImageListBinding

class ImageListAdapter:RecyclerView.Adapter<ImageListAdapter.ImageListViewHolder>() {

    private var data = ArrayList<ImageDataResponseModelItem>()
    fun setImages(data: ArrayList<ImageDataResponseModelItem>){
        this.data.addAll(data)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ImageListViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.adapter_image_list,parent,false)
        return ImageListViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: ImageListViewHolder, position: Int) {
        holder.setData(data[position])
    }

    override fun getItemCount(): Int {
        return data.size
    }

    inner class ImageListViewHolder(itemView: View):RecyclerView.ViewHolder(itemView) {
        private val binding = AdapterImageListBinding.bind(itemView)
        fun setData(data:ImageDataResponseModelItem){
            Glide.with(itemView).load(data.download_url).into(binding.imgView)
        }
    }
}