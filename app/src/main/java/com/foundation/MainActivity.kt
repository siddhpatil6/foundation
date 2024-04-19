package com.foundation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.viewModels
import androidx.lifecycle.LifecycleObserver
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.foundation.adapter.FoundationCodeAdapter
import com.foundation.data.FoundationPhotosItem
import com.foundation.di.FoundationListViewModelFactory
import com.foundation.viewmodel.FoundationViewModel


class MainActivity : ComponentActivity(), LifecycleObserver {

    private val foundationListViewModel: FoundationViewModel by viewModels { FoundationListViewModelFactory() }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        getPhotosListAPI()
    }

    private fun getPhotosListAPI(){
        foundationListViewModel.getListOfPhotos()
        foundationListViewModel.photosItem.observe(this, Observer { response ->
            generateDataList(response)
        })
    }

    private fun generateDataList(photoList: List<FoundationPhotosItem>) {
        val recyclerView = findViewById<RecyclerView>(R.id.rvPhotos)
        val adapter = FoundationCodeAdapter()
        val layoutManager: RecyclerView.LayoutManager = GridLayoutManager(this@MainActivity,3)
        recyclerView.layoutManager = layoutManager
        recyclerView.adapter = adapter
        adapter.submitList(photoList)
        recyclerView.setItemViewCacheSize(photoList.size);

    }
}

