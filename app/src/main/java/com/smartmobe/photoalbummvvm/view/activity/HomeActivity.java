package com.smartmobe.photoalbummvvm.view.activity;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.smartmobe.photoalbummvvm.R;
import com.smartmobe.photoalbummvvm.databinding.HomeBinding;
import com.smartmobe.photoalbummvvm.view.adapter.PhotoAdapter;
import com.smartmobe.photoalbummvvm.viewmodel.PhotoViewModel;

import java.util.Observable;
import java.util.Observer;

/**
 * Created by Dhiraj Sharma on April 05, 2017
 */

public class HomeActivity extends AppCompatActivity implements Observer {

    private HomeBinding homeBinding;
    private PhotoViewModel photoViewModel;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        startDataBinding();
        createPhotoList(homeBinding.listPhoto);
        setUpObserver(photoViewModel);
    }

    private void startDataBinding() {
        homeBinding = DataBindingUtil.setContentView(this, R.layout.home);
        photoViewModel = new PhotoViewModel(this);
        homeBinding.setPhotoViewModel(photoViewModel);
    }

    private void createPhotoList(RecyclerView photoList) {
        PhotoAdapter adapter = new PhotoAdapter();
        photoList.setAdapter(adapter);
        photoList.setLayoutManager(new LinearLayoutManager(this));
    }

    private void setUpObserver(Observable observable){
        observable.addObserver(this);
    }

    @Override
    public void update(Observable observable, Object data) {
        if (observable instanceof PhotoViewModel) {
            PhotoAdapter peopleAdapter = (PhotoAdapter) homeBinding.listPhoto.getAdapter();
            PhotoViewModel photoViewModel = (PhotoViewModel) observable;
            peopleAdapter.setPhotos(photoViewModel.getPhotos());
        }
    }

    @Override protected void onDestroy() {
        super.onDestroy();
        photoViewModel.reset();
    }
}
