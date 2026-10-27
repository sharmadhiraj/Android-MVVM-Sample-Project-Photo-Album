package com.sharmadhiraj.photoalbummvvm.view

import android.view.View
import android.widget.ImageView
import androidx.databinding.BindingAdapter

@BindingAdapter("imageUrl")
fun ImageView.bindImageUrl(url: String?) = ImageLoader.load(this, url)

@BindingAdapter("visibleIf")
fun View.bindVisibleIf(visible: Boolean?) {
    visibility = if (visible == true) View.VISIBLE else View.GONE
}
