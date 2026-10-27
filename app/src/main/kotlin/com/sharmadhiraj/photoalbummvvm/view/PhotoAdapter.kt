package com.sharmadhiraj.photoalbummvvm.view

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.sharmadhiraj.photoalbummvvm.databinding.ItemPhotoBinding
import com.sharmadhiraj.photoalbummvvm.model.PhotoItem

class PhotoAdapter(private val actions: PhotoActions) :
    ListAdapter<PhotoItem, PhotoAdapter.ViewHolder>(DiffCallback) {

    class ViewHolder(val binding: ItemPhotoBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        ViewHolder(ItemPhotoBinding.inflate(LayoutInflater.from(parent.context), parent, false))
            .also { it.binding.actions = actions }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.binding.item = getItem(position)
    }

    private object DiffCallback : DiffUtil.ItemCallback<PhotoItem>() {
        override fun areItemsTheSame(old: PhotoItem, new: PhotoItem) = old.photo.id == new.photo.id
        override fun areContentsTheSame(old: PhotoItem, new: PhotoItem) = old == new
    }
}
