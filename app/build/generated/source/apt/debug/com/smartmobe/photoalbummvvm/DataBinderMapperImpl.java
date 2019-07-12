package com.smartmobe.photoalbummvvm;

import android.databinding.DataBinderMapper;
import android.databinding.DataBindingComponent;
import android.databinding.ViewDataBinding;
import android.util.SparseArray;
import android.util.SparseIntArray;
import android.view.View;
import com.smartmobe.photoalbummvvm.databinding.HomeBindingImpl;
import com.smartmobe.photoalbummvvm.databinding.ItemPhotoBindingImpl;
import com.smartmobe.photoalbummvvm.databinding.PhotoDetailActivityBindingImpl;
import java.lang.IllegalArgumentException;
import java.lang.Integer;
import java.lang.Object;
import java.lang.Override;
import java.lang.RuntimeException;
import java.lang.String;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class DataBinderMapperImpl extends DataBinderMapper {
  private static final int LAYOUT_HOME = 1;

  private static final int LAYOUT_ITEMPHOTO = 2;

  private static final int LAYOUT_PHOTODETAILACTIVITY = 3;

  private static final SparseIntArray INTERNAL_LAYOUT_ID_LOOKUP = new SparseIntArray(3);

  static {
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.smartmobe.photoalbummvvm.R.layout.home, LAYOUT_HOME);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.smartmobe.photoalbummvvm.R.layout.item_photo, LAYOUT_ITEMPHOTO);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.smartmobe.photoalbummvvm.R.layout.photo_detail_activity, LAYOUT_PHOTODETAILACTIVITY);
  }

  @Override
  public ViewDataBinding getDataBinder(DataBindingComponent component, View view, int layoutId) {
    int localizedLayoutId = INTERNAL_LAYOUT_ID_LOOKUP.get(layoutId);
    if(localizedLayoutId > 0) {
      final Object tag = view.getTag();
      if(tag == null) {
        throw new RuntimeException("view must have a tag");
      }
      switch(localizedLayoutId) {
        case  LAYOUT_HOME: {
          if ("layout/home_0".equals(tag)) {
            return new HomeBindingImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for home is invalid. Received: " + tag);
        }
        case  LAYOUT_ITEMPHOTO: {
          if ("layout/item_photo_0".equals(tag)) {
            return new ItemPhotoBindingImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for item_photo is invalid. Received: " + tag);
        }
        case  LAYOUT_PHOTODETAILACTIVITY: {
          if ("layout/photo_detail_activity_0".equals(tag)) {
            return new PhotoDetailActivityBindingImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for photo_detail_activity is invalid. Received: " + tag);
        }
      }
    }
    return null;
  }

  @Override
  public ViewDataBinding getDataBinder(DataBindingComponent component, View[] views, int layoutId) {
    if(views == null || views.length == 0) {
      return null;
    }
    int localizedLayoutId = INTERNAL_LAYOUT_ID_LOOKUP.get(layoutId);
    if(localizedLayoutId > 0) {
      final Object tag = views[0].getTag();
      if(tag == null) {
        throw new RuntimeException("view must have a tag");
      }
      switch(localizedLayoutId) {
      }
    }
    return null;
  }

  @Override
  public int getLayoutId(String tag) {
    if (tag == null) {
      return 0;
    }
    Integer tmpVal = InnerLayoutIdLookup.sKeys.get(tag);
    return tmpVal == null ? 0 : tmpVal;
  }

  @Override
  public String convertBrIdToString(int localId) {
    String tmpVal = InnerBrLookup.sKeys.get(localId);
    return tmpVal;
  }

  @Override
  public List<DataBinderMapper> collectDependencies() {
    ArrayList<DataBinderMapper> result = new ArrayList<DataBinderMapper>(1);
    result.add(new com.android.databinding.library.baseAdapters.DataBinderMapperImpl());
    return result;
  }

  private static class InnerBrLookup {
    static final SparseArray<String> sKeys = new SparseArray<String>(5);

    static {
      sKeys.put(0, "_all");
      sKeys.put(1, "photoViewModel");
      sKeys.put(2, "photoItemViewModel");
      sKeys.put(3, "photoDetailViewModel");
    }
  }

  private static class InnerLayoutIdLookup {
    static final HashMap<String, Integer> sKeys = new HashMap<String, Integer>(3);

    static {
      sKeys.put("layout/home_0", com.smartmobe.photoalbummvvm.R.layout.home);
      sKeys.put("layout/item_photo_0", com.smartmobe.photoalbummvvm.R.layout.item_photo);
      sKeys.put("layout/photo_detail_activity_0", com.smartmobe.photoalbummvvm.R.layout.photo_detail_activity);
    }
  }
}
