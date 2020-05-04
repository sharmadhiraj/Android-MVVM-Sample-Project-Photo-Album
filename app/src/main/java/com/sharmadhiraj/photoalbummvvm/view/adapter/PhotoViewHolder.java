package com.sharmadhiraj.photoalbummvvm.view.adapter;

import androidx.recyclerview.widget.RecyclerView;

import com.sharmadhiraj.photoalbummvvm.databinding.ItemPhotoBinding;
import com.sharmadhiraj.photoalbummvvm.model.Photo;
import com.sharmadhiraj.photoalbummvvm.viewmodel.PhotoItemViewModel;

class PhotoViewHolder extends RecyclerView.ViewHolder {
    private ItemPhotoBinding itemPhotoBinding;

    PhotoViewHolder(ItemPhotoBinding itemPhotoBinding) {
        super(itemPhotoBinding.itemPhoto);
        this.itemPhotoBinding = itemPhotoBinding;
    }

    void bindPhoto(Photo photo) {
        if (itemPhotoBinding.getPhotoItemViewModel() == null) {
            itemPhotoBinding.setPhotoItemViewModel(new PhotoItemViewModel(photo, itemView.getContext()));
        } else {
            itemPhotoBinding.getPhotoItemViewModel().setPhoto(photo);
        }
    }
}

