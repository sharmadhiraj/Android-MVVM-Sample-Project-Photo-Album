package com.smartmobe.photoalbummvvm.databinding;

import android.databinding.Bindable;
import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.CardView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.smartmobe.photoalbummvvm.viewmodel.PhotoItemViewModel;
import java.lang.Deprecated;
import java.lang.Object;

public abstract class ItemPhotoBinding extends ViewDataBinding {
  @NonNull
  public final ImageView image;

  @NonNull
  public final CardView itemPhoto;

  @NonNull
  public final TextView title;

  @Bindable
  protected PhotoItemViewModel mPhotoItemViewModel;

  protected ItemPhotoBinding(Object _bindingComponent, View _root, int _localFieldCount,
      ImageView image, CardView itemPhoto, TextView title) {
    super(_bindingComponent, _root, _localFieldCount);
    this.image = image;
    this.itemPhoto = itemPhoto;
    this.title = title;
  }

  public abstract void setPhotoItemViewModel(@Nullable PhotoItemViewModel photoItemViewModel);

  @Nullable
  public PhotoItemViewModel getPhotoItemViewModel() {
    return mPhotoItemViewModel;
  }

  @NonNull
  public static ItemPhotoBinding inflate(@NonNull LayoutInflater inflater, @Nullable ViewGroup root,
      boolean attachToRoot) {
    return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
  }

  /**
   * This method receives DataBindingComponent instance as type Object instead of
   * type DataBindingComponent to avoid causing too many compilation errors if
   * compilation fails for another reason.
   * https://issuetracker.google.com/issues/116541301
   * @Deprecated Use DataBindingUtil.inflate(inflater, R.layout.item_photo, root, attachToRoot, component)
   */
  @NonNull
  @Deprecated
  public static ItemPhotoBinding inflate(@NonNull LayoutInflater inflater, @Nullable ViewGroup root,
      boolean attachToRoot, @Nullable Object component) {
    return ViewDataBinding.<ItemPhotoBinding>inflateInternal(inflater, com.smartmobe.photoalbummvvm.R.layout.item_photo, root, attachToRoot, component);
  }

  @NonNull
  public static ItemPhotoBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, DataBindingUtil.getDefaultComponent());
  }

  /**
   * This method receives DataBindingComponent instance as type Object instead of
   * type DataBindingComponent to avoid causing too many compilation errors if
   * compilation fails for another reason.
   * https://issuetracker.google.com/issues/116541301
   * @Deprecated Use DataBindingUtil.inflate(inflater, R.layout.item_photo, null, false, component)
   */
  @NonNull
  @Deprecated
  public static ItemPhotoBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable Object component) {
    return ViewDataBinding.<ItemPhotoBinding>inflateInternal(inflater, com.smartmobe.photoalbummvvm.R.layout.item_photo, null, false, component);
  }

  public static ItemPhotoBinding bind(@NonNull View view) {
    return bind(view, DataBindingUtil.getDefaultComponent());
  }

  /**
   * This method receives DataBindingComponent instance as type Object instead of
   * type DataBindingComponent to avoid causing too many compilation errors if
   * compilation fails for another reason.
   * https://issuetracker.google.com/issues/116541301
   * @Deprecated Use DataBindingUtil.bind(view, component)
   */
  @Deprecated
  public static ItemPhotoBinding bind(@NonNull View view, @Nullable Object component) {
    return (ItemPhotoBinding)bind(component, view, com.smartmobe.photoalbummvvm.R.layout.item_photo);
  }
}
