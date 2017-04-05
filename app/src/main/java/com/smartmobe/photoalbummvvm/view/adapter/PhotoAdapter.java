/**
 * Copyright 2016 Erik Jhordan Rey.
 * <p>
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * <p>
 * http://www.apache.org/licenses/LICENSE-2.0
 * <p>
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.smartmobe.photoalbummvvm.view.adapter;

import android.databinding.DataBindingUtil;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.smartmobe.photoalbummvvm.R;
import com.smartmobe.photoalbummvvm.databinding.ItemPhotoBinding;
import com.smartmobe.photoalbummvvm.model.Photo;
import com.smartmobe.photoalbummvvm.viewmodel.PhotoItemViewModel;

import java.util.Collections;
import java.util.List;

public class PhotoAdapter extends RecyclerView.Adapter<PhotoAdapter.PhotoAdapterViewHolder> {

    private List<Photo> photos;

    public PhotoAdapter() {
        this.photos = Collections.emptyList();
    }

    @Override
    public PhotoAdapterViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        ItemPhotoBinding itemPhotoBinding =
                DataBindingUtil.inflate(LayoutInflater.from(parent.getContext()), R.layout.item_photo,
                        parent, false);
        return new PhotoAdapterViewHolder(itemPhotoBinding);
    }

    @Override
    public void onBindViewHolder(PhotoAdapterViewHolder holder, int position) {
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

    public static class PhotoAdapterViewHolder extends RecyclerView.ViewHolder {

        ItemPhotoBinding itemPhotoBinding;

        public PhotoAdapterViewHolder(ItemPhotoBinding itemPhotoBinding) {
            super(itemPhotoBinding.itemPhoto);
            this.itemPhotoBinding = itemPhotoBinding;
        }

        void bindPhoto(Photo photo) {
            if (itemPhotoBinding.getPhotoItemViewModel() == null) {
                itemPhotoBinding.setPhotoItemViewModel(
                        new PhotoItemViewModel(photo, itemView.getContext()));
            } else {
                itemPhotoBinding.getPhotoItemViewModel().setPhoto(photo);
            }
        }
    }
}
