package com.sharmadhiraj.photoalbummvvm.view.activity;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.sharmadhiraj.photoalbummvvm.R;
import com.sharmadhiraj.photoalbummvvm.databinding.HomeBinding;
import com.sharmadhiraj.photoalbummvvm.view.adapter.PhotoListAdapter;
import com.sharmadhiraj.photoalbummvvm.viewmodel.PhotoViewModel;

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
        PhotoListAdapter adapter = new PhotoListAdapter();
        photoList.setAdapter(adapter);
        photoList.setLayoutManager(new LinearLayoutManager(this));
    }

    private void setUpObserver(Observable observable) {
        observable.addObserver(this);
    }

    @Override
    public void update(Observable observable, Object data) {
        if (observable instanceof PhotoViewModel) {
            PhotoListAdapter peopleAdapter = (PhotoListAdapter) homeBinding.listPhoto.getAdapter();
            PhotoViewModel photoViewModel = (PhotoViewModel) observable;
            peopleAdapter.setPhotos(photoViewModel.getPhotos());
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        photoViewModel.reset();
    }
}
