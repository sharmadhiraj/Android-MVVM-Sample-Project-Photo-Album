package com.smartmobe.photoalbummvvm.viewmodel;

import android.databinding.BindingAdapter;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.smartmobe.photoalbummvvm.model.Photo;

/**
 * Created by Dhiraj Sharma on April 05, 2017
 */

public class PhotoDetailViewModel {

    private Photo photo;

    public PhotoDetailViewModel(Photo photo) {
        this.photo = photo;
    }

    public String getTitle(){
        return photo.getTitle();
    }

    public String getImageUrl(){
        return photo.getUrl();
    }

    @BindingAdapter({"image"})
    public static void loadImage(ImageView view, String url) {
        Glide.with(view.getContext()).load(url).into(view);
    }
}
