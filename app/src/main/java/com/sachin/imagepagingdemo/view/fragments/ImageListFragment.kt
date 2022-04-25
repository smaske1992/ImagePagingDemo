package com.sachin.imagepagingdemo.view.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.sachin.imagepagingdemo.databinding.FragmentImageListBinding
import com.sachin.imagepagingdemo.view.adapter.ImageListAdapter
import com.sachin.imagepagingdemo.viewmodel.MainActivityViewModel

class ImageListFragment : Fragment() {

    private var isLoading = false
    private var binding:FragmentImageListBinding?=null
    private val adapter = ImageListAdapter()
    private lateinit var viewModel:MainActivityViewModel
    private var page = 1
    private val limit = 10
    private lateinit var layoutManager : LinearLayoutManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {

        }
        viewModel = ViewModelProvider(this)[MainActivityViewModel::class.java]
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentImageListBinding.inflate(LayoutInflater.from(context),container,false)
        return binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        layoutManager = LinearLayoutManager(context)
        binding?.recImages?.layoutManager = layoutManager
        binding?.recImages?.adapter = adapter
        viewModel.getImages(page,limit)
        viewModel.imageList.observe(viewLifecycleOwner) {
            adapter.setImages(it)
        }

        binding?.recImages?.addOnScrollListener(object : RecyclerView.OnScrollListener(){
            override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {
                super.onScrolled(recyclerView, dx, dy)

                if (!isLoading) {
                    if (layoutManager.findLastCompletelyVisibleItemPosition() == adapter.itemCount - 1) {
                        viewModel.getImages(page++,limit)
                        isLoading = true
                    }
                }
            }
        })


    }
}