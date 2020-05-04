package com.sharmadhiraj.photoalbummvvm.viewmodel;

import android.widget.ImageView;

import androidx.databinding.BindingAdapter;

import com.bumptech.glide.Glide;
import com.sharmadhiraj.photoalbummvvm.model.Photo;

/**
 * Created by Dhiraj Sharma on April 05, 2017
 */

public class PhotoDetailViewModel {

    private Photo photo;

    public PhotoDetailViewModel(Photo photo) {
        this.photo = photo;
    }

    @BindingAdapter({"image"})
    public static void loadImage(ImageView view, String url) {
        Glide.with(view.getContext()).load(url).into(view);
    }

    public String getTitle() {
        return photo.getTitle();
    }

    public String getImageUrl() {
        return photo.getUrl();
    }
}
