package com.smartmobe.photoalbummvvm.view.activity;

import android.content.Context;
import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;

import com.smartmobe.photoalbummvvm.R;
import com.smartmobe.photoalbummvvm.databinding.PhotoDetailActivityBinding;
import com.smartmobe.photoalbummvvm.model.Photo;
import com.smartmobe.photoalbummvvm.util.ViewUtil;
import com.smartmobe.photoalbummvvm.viewmodel.PhotoDetailViewModel;

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
        setTitle(photo.getTitle());
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                finish();
                break;
            case R.id.menu_comment:
                startActivityActionView();
                break;
        }
        return super.onOptionsItemSelected(item);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.comment, menu);
        return true;
    }

    private void startActivityActionView() {
        startActivity(
                new Intent(this, CommentActivity.class));
    }

}
