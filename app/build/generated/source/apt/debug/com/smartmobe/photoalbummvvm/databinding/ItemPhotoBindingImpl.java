package com.smartmobe.photoalbummvvm.databinding;
import com.smartmobe.photoalbummvvm.R;
import com.smartmobe.photoalbummvvm.BR;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.View;
@SuppressWarnings("unchecked")
public class ItemPhotoBindingImpl extends ItemPhotoBinding  {

    @Nullable
    private static final android.databinding.ViewDataBinding.IncludedLayouts sIncludes;
    @Nullable
    private static final android.util.SparseIntArray sViewsWithIds;
    static {
        sIncludes = null;
        sViewsWithIds = null;
    }
    // views
    // variables
    // values
    // listeners
    private OnClickListenerImpl mPhotoItemViewModelOnItemClickAndroidViewViewOnClickListener;
    // Inverse Binding Event Handlers

    public ItemPhotoBindingImpl(@Nullable android.databinding.DataBindingComponent bindingComponent, @NonNull View root) {
        this(bindingComponent, root, mapBindings(bindingComponent, root, 3, sIncludes, sViewsWithIds));
    }
    private ItemPhotoBindingImpl(android.databinding.DataBindingComponent bindingComponent, View root, Object[] bindings) {
        super(bindingComponent, root, 1
            , (android.widget.ImageView) bindings[1]
            , (android.support.v7.widget.CardView) bindings[0]
            , (android.widget.TextView) bindings[2]
            );
        this.image.setTag(null);
        this.itemPhoto.setTag(null);
        this.title.setTag(null);
        setRootTag(root);
        // listeners
        invalidateAll();
    }

    @Override
    public void invalidateAll() {
        synchronized(this) {
                mDirtyFlags = 0x2L;
        }
        requestRebind();
    }

    @Override
    public boolean hasPendingBindings() {
        synchronized(this) {
            if (mDirtyFlags != 0) {
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean setVariable(int variableId, @Nullable Object variable)  {
        boolean variableSet = true;
        if (BR.photoItemViewModel == variableId) {
            setPhotoItemViewModel((com.smartmobe.photoalbummvvm.viewmodel.PhotoItemViewModel) variable);
        }
        else {
            variableSet = false;
        }
            return variableSet;
    }

    public void setPhotoItemViewModel(@Nullable com.smartmobe.photoalbummvvm.viewmodel.PhotoItemViewModel PhotoItemViewModel) {
        updateRegistration(0, PhotoItemViewModel);
        this.mPhotoItemViewModel = PhotoItemViewModel;
        synchronized(this) {
            mDirtyFlags |= 0x1L;
        }
        notifyPropertyChanged(BR.photoItemViewModel);
        super.requestRebind();
    }

    @Override
    protected boolean onFieldChange(int localFieldId, Object object, int fieldId) {
        switch (localFieldId) {
            case 0 :
                return onChangePhotoItemViewModel((com.smartmobe.photoalbummvvm.viewmodel.PhotoItemViewModel) object, fieldId);
        }
        return false;
    }
    private boolean onChangePhotoItemViewModel(com.smartmobe.photoalbummvvm.viewmodel.PhotoItemViewModel PhotoItemViewModel, int fieldId) {
        if (fieldId == BR._all) {
            synchronized(this) {
                    mDirtyFlags |= 0x1L;
            }
            return true;
        }
        return false;
    }

    @Override
    protected void executeBindings() {
        long dirtyFlags = 0;
        synchronized(this) {
            dirtyFlags = mDirtyFlags;
            mDirtyFlags = 0;
        }
        com.smartmobe.photoalbummvvm.viewmodel.PhotoItemViewModel photoItemViewModel = mPhotoItemViewModel;
        java.lang.String photoItemViewModelImageUrl = null;
        java.lang.String photoItemViewModelTitle = null;
        android.view.View.OnClickListener photoItemViewModelOnItemClickAndroidViewViewOnClickListener = null;

        if ((dirtyFlags & 0x3L) != 0) {



                if (photoItemViewModel != null) {
                    // read photoItemViewModel.imageUrl
                    photoItemViewModelImageUrl = photoItemViewModel.getImageUrl();
                    // read photoItemViewModel.title
                    photoItemViewModelTitle = photoItemViewModel.getTitle();
                    // read photoItemViewModel::onItemClick
                    photoItemViewModelOnItemClickAndroidViewViewOnClickListener = (((mPhotoItemViewModelOnItemClickAndroidViewViewOnClickListener == null) ? (mPhotoItemViewModelOnItemClickAndroidViewViewOnClickListener = new OnClickListenerImpl()) : mPhotoItemViewModelOnItemClickAndroidViewViewOnClickListener).setValue(photoItemViewModel));
                }
        }
        // batch finished
        if ((dirtyFlags & 0x3L) != 0) {
            // api target 1

            com.smartmobe.photoalbummvvm.viewmodel.PhotoDetailViewModel.loadImage(this.image, photoItemViewModelImageUrl);
            this.itemPhoto.setOnClickListener(photoItemViewModelOnItemClickAndroidViewViewOnClickListener);
            android.databinding.adapters.TextViewBindingAdapter.setText(this.title, photoItemViewModelTitle);
        }
    }
    // Listener Stub Implementations
    public static class OnClickListenerImpl implements android.view.View.OnClickListener{
        private com.smartmobe.photoalbummvvm.viewmodel.PhotoItemViewModel value;
        public OnClickListenerImpl setValue(com.smartmobe.photoalbummvvm.viewmodel.PhotoItemViewModel value) {
            this.value = value;
            return value == null ? null : this;
        }
        @Override
        public void onClick(android.view.View arg0) {
            this.value.onItemClick(arg0); 
        }
    }
    // callback impls
    // dirty flag
    private  long mDirtyFlags = 0xffffffffffffffffL;
    /* flag mapping
        flag 0 (0x1L): photoItemViewModel
        flag 1 (0x2L): null
    flag mapping end*/
    //end
}