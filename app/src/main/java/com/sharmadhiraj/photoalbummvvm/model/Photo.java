package com.sharmadhiraj.photoalbummvvm.model;

import com.google.gson.annotations.Expose;

import java.io.Serializable;

/**
 * Created by Dhiraj Sharma on April 05, 2017
 */

public class Photo implements Serializable {

    @Expose
    private String title;
    @Expose
    private String url;
    @Expose
    private String thumbnailUrl;

    public Photo(String title, String url, String thumbnailUrl) {
        this.title = title;
        this.url = url;
        this.thumbnailUrl = thumbnailUrl;
    }

    public String getTitle() {
        return title;
    }

    public String getUrl() {
        return url;
    }

    public String getThumbnailUrl() {
        return thumbnailUrl;
    }
}
