package com.sharmadhiraj.photoalbummvvm.view.adapter;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.sharmadhiraj.photoalbummvvm.R;
import com.sharmadhiraj.photoalbummvvm.databinding.ItemPhotoBinding;
import com.sharmadhiraj.photoalbummvvm.model.Photo;

import java.util.Collections;
import java.util.List;

public class PhotoListAdapter extends RecyclerView.Adapter<PhotoViewHolder> {

    private List<Photo> photos;

    public PhotoListAdapter() {
        this.photos = Collections.emptyList();
    }

    @Override
    @NonNull
    public PhotoViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        ItemPhotoBinding itemPhotoBinding = DataBindingUtil.inflate(
                LayoutInflater.from(parent.getContext()),
                R.layout.item_photo,
                parent, false
        );
        return new PhotoViewHolder(itemPhotoBinding);
    }

    @Override
    public void onBindViewHolder(PhotoViewHolder holder, int position) {
        holder.bindPhoto(photos.get(position));
    }

    @Override
    public int getItemCount() {
        return photos.size();
    }

    public void setPhotos(List<Photo> photos) {
        this.photos = photos;
        notifyDataSetChanged();
    }

}
