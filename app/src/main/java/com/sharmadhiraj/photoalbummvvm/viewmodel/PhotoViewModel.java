package com.sharmadhiraj.photoalbummvvm.viewmodel;

import android.content.Context;
import android.view.View;

import androidx.databinding.ObservableField;
import androidx.databinding.ObservableInt;

import com.sharmadhiraj.photoalbummvvm.R;
import com.sharmadhiraj.photoalbummvvm.app.PhotoAlbumApplication;
import com.sharmadhiraj.photoalbummvvm.data.PhotoAlbumService;
import com.sharmadhiraj.photoalbummvvm.model.Photo;

import java.util.ArrayList;
import java.util.List;
import java.util.Observable;

import rx.Subscription;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action1;

/**
 * Created by Dhiraj Sharma on April 05, 2017
 */

public class PhotoViewModel extends Observable {

    public ObservableInt photoProgress;
    public ObservableField<String> messageLabel;
    private final ObservableInt photoList;
    private final ObservableInt photoLabel;
    private Context context;
    private final List<Photo> photos;
    private Subscription subscription;

    public PhotoViewModel(Context context) {
        this.context = context;
        photos = new ArrayList<>();
        photoProgress = new ObservableInt(View.VISIBLE);
        photoList = new ObservableInt(View.GONE);
        photoLabel = new ObservableInt(View.GONE);
        messageLabel = new ObservableField<>("");
        fetchPhotos();
    }

    private void fetchPhotos() {

        unSubscribeFromObservable();
        PhotoAlbumApplication photoAlbumApplication = PhotoAlbumApplication.create(context);
        PhotoAlbumService peopleService = photoAlbumApplication.getPhotoAlbumService();
        subscription = peopleService.fetchPhotos()
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(photoAlbumApplication.subscribeScheduler())
                .subscribe(new Action1<List<Photo>>() {
                    @Override
                    public void call(List<Photo> photos) {
                        photoProgress.set(View.GONE);
                        photoLabel.set(View.GONE);
                        photoList.set(View.VISIBLE);
                        changePhotos(photos);
                    }
                }, new Action1<Throwable>() {
                    @Override
                    public void call(Throwable throwable) {
                        throwable.printStackTrace();
                        messageLabel.set(context.getString(R.string.error_loading));
                        photoProgress.set(View.GONE);
                        photoLabel.set(View.VISIBLE);
                        photoList.set(View.GONE);
                    }
                });

    }

    public List<Photo> getPhotos() {
        return photos;
    }

    private void unSubscribeFromObservable() {
        if (subscription != null && !subscription.isUnsubscribed()) {
            subscription.unsubscribe();
        }
    }

    private void changePhotos(List<Photo> photos) {
        this.photos.addAll(photos);
        setChanged();
        notifyObservers();
    }

    public void reset() {
        unSubscribeFromObservable();
        subscription = null;
        context = null;
    }
}
