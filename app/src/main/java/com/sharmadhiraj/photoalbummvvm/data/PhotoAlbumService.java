package com.sharmadhiraj.photoalbummvvm.data;

import com.sharmadhiraj.photoalbummvvm.model.Photo;

import java.util.List;

import retrofit2.http.GET;
import rx.Observable;

public interface PhotoAlbumService {
    @GET("albums/1/photos")
    Observable<List<Photo>> fetchPhotos();
}
