package com.smartmobe.photoalbummvvm.databinding;

import android.databinding.Bindable;
import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.smartmobe.photoalbummvvm.viewmodel.PhotoDetailViewModel;
import java.lang.Deprecated;
import java.lang.Object;

public abstract class PhotoDetailActivityBinding extends ViewDataBinding {
  @NonNull
  public final ImageView image;

  @NonNull
  public final TextView title;

  @Bindable
  protected PhotoDetailViewModel mPhotoDetailViewModel;

  protected PhotoDetailActivityBinding(Object _bindingComponent, View _root, int _localFieldCount,
      ImageView image, TextView title) {
    super(_bindingComponent, _root, _localFieldCount);
    this.image = image;
    this.title = title;
  }

  public abstract void setPhotoDetailViewModel(@Nullable PhotoDetailViewModel photoDetailViewModel);

  @Nullable
  public PhotoDetailViewModel getPhotoDetailViewModel() {
    return mPhotoDetailViewModel;
  }

  @NonNull
  public static PhotoDetailActivityBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot) {
    return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
  }

  /**
   * This method receives DataBindingComponent instance as type Object instead of
   * type DataBindingComponent to avoid causing too many compilation errors if
   * compilation fails for another reason.
   * https://issuetracker.google.com/issues/116541301
   * @Deprecated Use DataBindingUtil.inflate(inflater, R.layout.photo_detail_activity, root, attachToRoot, component)
   */
  @NonNull
  @Deprecated
  public static PhotoDetailActivityBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot, @Nullable Object component) {
    return ViewDataBinding.<PhotoDetailActivityBinding>inflateInternal(inflater, com.smartmobe.photoalbummvvm.R.layout.photo_detail_activity, root, attachToRoot, component);
  }

  @NonNull
  public static PhotoDetailActivityBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, DataBindingUtil.getDefaultComponent());
  }

  /**
   * This method receives DataBindingComponent instance as type Object instead of
   * type DataBindingComponent to avoid causing too many compilation errors if
   * compilation fails for another reason.
   * https://issuetracker.google.com/issues/116541301
   * @Deprecated Use DataBindingUtil.inflate(inflater, R.layout.photo_detail_activity, null, false, component)
   */
  @NonNull
  @Deprecated
  public static PhotoDetailActivityBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable Object component) {
    return ViewDataBinding.<PhotoDetailActivityBinding>inflateInternal(inflater, com.smartmobe.photoalbummvvm.R.layout.photo_detail_activity, null, false, component);
  }

  public static PhotoDetailActivityBinding bind(@NonNull View view) {
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
  public static PhotoDetailActivityBinding bind(@NonNull View view, @Nullable Object component) {
    return (PhotoDetailActivityBinding)bind(component, view, com.smartmobe.photoalbummvvm.R.layout.photo_detail_activity);
  }
}
