package com.sharmadhiraj.photoalbummvvm.util;

import android.content.Context;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

/**
 * Created by Dhiraj Sharma on April 06, 2017
 */

public class ViewUtil {

    public static void displayHomeAsUpEnabled(Context context) {
        ActionBar actionBar = ((AppCompatActivity) context).getSupportActionBar();
        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(true);
        }
    }

}
