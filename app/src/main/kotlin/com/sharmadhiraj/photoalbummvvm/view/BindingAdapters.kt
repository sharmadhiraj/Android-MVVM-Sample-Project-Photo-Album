package com.sharmadhiraj.photoalbummvvm.view

import android.view.View
import android.widget.ImageView
import androidx.databinding.BindingAdapter

@BindingAdapter("imageUrl", "placeholderUrl", requireAll = false)
fun ImageView.bindImageUrl(url: String?, placeholderUrl: String?) = ImageLoader.load(this, url, placeholderUrl)

@BindingAdapter("visibleIf")
fun View.bindVisibleIf(visible: Boolean?) {
    visibility = if (visible == true) View.VISIBLE else View.GONE
}
