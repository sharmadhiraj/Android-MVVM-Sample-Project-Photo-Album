package com.smartmobe.photoalbummvvm.app;

import android.app.Application;
import android.content.Context;

import com.smartmobe.photoalbummvvm.data.PhotoAlbumFactory;
import com.smartmobe.photoalbummvvm.data.PhotoAlbumService;

import rx.Scheduler;
import rx.schedulers.Schedulers;

/**
 * Created by Dhiraj Sharma on April 05, 2017
 */

public class PhotoAlbumApplication extends Application {

    private PhotoAlbumService photoAlbumService;
    private Scheduler scheduler;

    public static PhotoAlbumApplication create(Context context) {
        return PhotoAlbumApplication.get(context);
    }

    private static PhotoAlbumApplication get(Context context) {
        return (PhotoAlbumApplication) context.getApplicationContext();
    }

    public PhotoAlbumService getPhotoAlbumService() {
        if (photoAlbumService == null) photoAlbumService = PhotoAlbumFactory.create();
        return photoAlbumService;
    }

    public Scheduler subscribeScheduler() {
        if (scheduler == null) scheduler = Schedulers.io();
        return scheduler;
    }
//added to test git commit updated again
}
