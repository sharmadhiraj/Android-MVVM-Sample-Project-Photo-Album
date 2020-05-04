package com.sharmadhiraj.photoalbummvvm.view.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import com.sharmadhiraj.photoalbummvvm.R;
import com.sharmadhiraj.photoalbummvvm.databinding.PhotoDetailActivityBinding;
import com.sharmadhiraj.photoalbummvvm.model.Photo;
import com.sharmadhiraj.photoalbummvvm.util.ViewUtil;
import com.sharmadhiraj.photoalbummvvm.viewmodel.PhotoDetailViewModel;

/**
 * Created by Dhiraj Sharma on April 05, 2017
 */

public class PhotoDetailActivity extends AppCompatActivity {

    private static final String EXTRA_PHOTO = "EXTRA_PHOTO";
    private PhotoDetailActivityBinding photoDetailActivityBinding;

    public static Intent launchDetail(Context context, Photo photo) {
        Intent intent = new Intent(context, PhotoDetailActivity.class);
        intent.putExtra(EXTRA_PHOTO, photo);
        return intent;
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        photoDetailActivityBinding = DataBindingUtil.setContentView(this, R.layout.photo_detail_activity);
        ViewUtil.displayHomeAsUpEnabled(PhotoDetailActivity.this);
        getExtrasFromIntent();
    }


    private void getExtrasFromIntent() {
        Photo photo = (Photo) getIntent().getSerializableExtra(EXTRA_PHOTO);
        PhotoDetailViewModel photoDetailViewModel = new PhotoDetailViewModel(photo);
        photoDetailActivityBinding.setPhotoDetailViewModel(photoDetailViewModel);
        if (photo != null) setTitle(photo.getTitle());
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            finish();
        }
        return super.onOptionsItemSelected(item);
    }

}
