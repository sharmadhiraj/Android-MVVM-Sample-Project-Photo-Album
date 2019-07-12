package com.smartmobe.photoalbummvvm.databinding;

import android.databinding.Bindable;
import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.smartmobe.photoalbummvvm.viewmodel.PhotoViewModel;
import java.lang.Deprecated;
import java.lang.Object;

public abstract class HomeBinding extends ViewDataBinding {
  @NonNull
  public final TextView labelStatus;

  @NonNull
  public final RecyclerView listPhoto;

  @NonNull
  public final ProgressBar progressPhoto;

  @Bindable
  protected PhotoViewModel mPhotoViewModel;

  protected HomeBinding(Object _bindingComponent, View _root, int _localFieldCount,
      TextView labelStatus, RecyclerView listPhoto, ProgressBar progressPhoto) {
    super(_bindingComponent, _root, _localFieldCount);
    this.labelStatus = labelStatus;
    this.listPhoto = listPhoto;
    this.progressPhoto = progressPhoto;
  }

  public abstract void setPhotoViewModel(@Nullable PhotoViewModel photoViewModel);

  @Nullable
  public PhotoViewModel getPhotoViewModel() {
    return mPhotoViewModel;
  }

  @NonNull
  public static HomeBinding inflate(@NonNull LayoutInflater inflater, @Nullable ViewGroup root,
      boolean attachToRoot) {
    return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
  }

  /**
   * This method receives DataBindingComponent instance as type Object instead of
   * type DataBindingComponent to avoid causing too many compilation errors if
   * compilation fails for another reason.
   * https://issuetracker.google.com/issues/116541301
   * @Deprecated Use DataBindingUtil.inflate(inflater, R.layout.home, root, attachToRoot, component)
   */
  @NonNull
  @Deprecated
  public static HomeBinding inflate(@NonNull LayoutInflater inflater, @Nullable ViewGroup root,
      boolean attachToRoot, @Nullable Object component) {
    return ViewDataBinding.<HomeBinding>inflateInternal(inflater, com.smartmobe.photoalbummvvm.R.layout.home, root, attachToRoot, component);
  }

  @NonNull
  public static HomeBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, DataBindingUtil.getDefaultComponent());
  }

  /**
   * This method receives DataBindingComponent instance as type Object instead of
   * type DataBindingComponent to avoid causing too many compilation errors if
   * compilation fails for another reason.
   * https://issuetracker.google.com/issues/116541301
   * @Deprecated Use DataBindingUtil.inflate(inflater, R.layout.home, null, false, component)
   */
  @NonNull
  @Deprecated
  public static HomeBinding inflate(@NonNull LayoutInflater inflater, @Nullable Object component) {
    return ViewDataBinding.<HomeBinding>inflateInternal(inflater, com.smartmobe.photoalbummvvm.R.layout.home, null, false, component);
  }

  public static HomeBinding bind(@NonNull View view) {
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
  public static HomeBinding bind(@NonNull View view, @Nullable Object component) {
    return (HomeBinding)bind(component, view, com.smartmobe.photoalbummvvm.R.layout.home);
  }
}
