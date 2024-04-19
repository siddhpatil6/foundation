package com.foundation.adapter

import android.graphics.Bitmap
import android.util.LruCache
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.foundation.R
import com.foundation.data.FoundationPhotosItem
import com.foundation.databinding.ForthcodeItemBinding


class FoundationCodeAdapter(
) : ListAdapter<FoundationPhotosItem, FoundationCodeAdapter.ForthCodeViewHolder>(DiffCallback) {

    private val imageCache: LruCache<String, Bitmap>

    init {
        // Calculate the maximum memory available to the app for the cache
        val maxMemory = Runtime.getRuntime().maxMemory().toInt() / 1024
        // Use 1/8th of the available memory for this memory cache
        val cacheSize = maxMemory / 8
        imageCache = LruCache(cacheSize)
    }

    inner class ForthCodeViewHolder(private val itemRowBinding:ForthcodeItemBinding) : RecyclerView.ViewHolder(itemRowBinding.root) {
        fun bind(item: FoundationPhotosItem) {
            val bitmap = imageCache.get(item.thumbnailUrl)
            if (bitmap==null){
                itemRowBinding.model = item
                itemRowBinding.executePendingBindings();
            }else{
                itemRowBinding.ivThumbNail.setImageBitmap(bitmap)
            }

        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ForthCodeViewHolder {
        val binding: ForthcodeItemBinding = DataBindingUtil.inflate(
            LayoutInflater.from(parent.context),
            R.layout.foundation_item, parent, false
        )
        return ForthCodeViewHolder(binding)

    }

    override fun onBindViewHolder(holder: ForthCodeViewHolder, position: Int) {
        holder.bind(getItem(position))

    }

    companion object {
        private val DiffCallback = object : DiffUtil.ItemCallback<FoundationPhotosItem>() {
            override fun areItemsTheSame(
                oldItem: FoundationPhotosItem,
                newItem: FoundationPhotosItem
            ): Boolean {
                return oldItem.id == newItem.id
            }

            override fun areContentsTheSame(
                oldItem: FoundationPhotosItem,
                newItem: FoundationPhotosItem
            ): Boolean {
                return oldItem == newItem
            }
        }
    }
}
