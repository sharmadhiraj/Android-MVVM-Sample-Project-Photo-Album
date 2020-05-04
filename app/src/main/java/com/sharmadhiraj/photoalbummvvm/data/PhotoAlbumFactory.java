package com.sharmadhiraj.photoalbummvvm.data;

import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class PhotoAlbumFactory {

    private final static String BASE_URL = "https://jsonplaceholder.typicode.com/";

    public static PhotoAlbumService create() {
        Retrofit retrofit = new Retrofit.Builder().baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .build();
        return retrofit.create(PhotoAlbumService.class);
    }
}
