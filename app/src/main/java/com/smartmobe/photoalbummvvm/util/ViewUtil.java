package com.smartmobe.photoalbummvvm.util;

import android.content.Context;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;

/**
 * Created by Dhiraj Sharma on April 06, 2017
 */

public class ViewUtil {

    public static void displayHomeAsUpEnabled(Context context) {
        ActionBar actionBar = ((AppCompatActivity)context).getSupportActionBar();
        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(true);
        }
    }

}
