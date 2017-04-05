package com.smartmobe.photoalbummvvm.viewmodel;

import android.content.Context;
import android.databinding.BaseObservable;
import android.databinding.BindingAdapter;
import android.view.View;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.smartmobe.photoalbummvvm.model.Photo;
import com.smartmobe.photoalbummvvm.view.activity.PhotoDetailActivity;

/**
 * Created by Dhiraj Sharma on April 05, 2017
 */

public class PhotoItemViewModel extends BaseObservable {

    private Photo photo;
    private Context context;

    public PhotoItemViewModel(Photo photo, Context context) {
        this.photo = photo;
        this.context = context;
    }

    @BindingAdapter({"image"})
    public static void loadImage(ImageView view, String url) {
        Glide.with(view.getContext()).load(url).centerCrop().into(view);
    }

    public void setPhoto(Photo photo) {
        this.photo = photo;
        notifyChange();
    }

    public String getImageUrl(){
        return photo.getThumbnailUrl();
    }

    public String getTitle() {
        return photo.getTitle();
    }


    public void onItemClick(View view){
        context.startActivity(PhotoDetailActivity.launchDetail(view.getContext(), photo));
    }

}
