package com.sharmadhiraj.photoalbummvvm.viewmodel;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;

import androidx.databinding.BaseObservable;
import androidx.databinding.BindingAdapter;

import com.sharmadhiraj.photoalbummvvm.model.Photo;
import com.sharmadhiraj.photoalbummvvm.view.activity.PhotoDetailActivity;
import com.squareup.picasso.Picasso;

/**
 * Created by Dhiraj Sharma on April 05, 2017
 */

public class PhotoItemViewModel extends BaseObservable {

    private final Context context;
    private Photo photo;

    public PhotoItemViewModel(Photo photo, Context context) {
        this.photo = photo;
        this.context = context;
    }

    @BindingAdapter({"image"})
    public static void loadImage(ImageView view, String url) {
        Picasso.get().load(url).into(view);
    }

    public void setPhoto(Photo photo) {
        this.photo = photo;
        notifyChange();
    }

    public String getImageUrl() {
        return photo.getThumbnailUrl();
    }

    public String getTitle() {
        return photo.getTitle();
    }


    public void onItemClick(View view) {
        context.startActivity(PhotoDetailActivity.launchDetail(view.getContext(), photo));
    }

}
