package com.smartmobe.photoalbummvvm.databinding;
import com.smartmobe.photoalbummvvm.R;
import com.smartmobe.photoalbummvvm.BR;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.View;
@SuppressWarnings("unchecked")
public class PhotoDetailActivityBindingImpl extends PhotoDetailActivityBinding  {

    @Nullable
    private static final android.databinding.ViewDataBinding.IncludedLayouts sIncludes;
    @Nullable
    private static final android.util.SparseIntArray sViewsWithIds;
    static {
        sIncludes = null;
        sViewsWithIds = null;
    }
    // views
    @NonNull
    private final android.widget.RelativeLayout mboundView0;
    // variables
    // values
    // listeners
    // Inverse Binding Event Handlers

    public PhotoDetailActivityBindingImpl(@Nullable android.databinding.DataBindingComponent bindingComponent, @NonNull View root) {
        this(bindingComponent, root, mapBindings(bindingComponent, root, 3, sIncludes, sViewsWithIds));
    }
    private PhotoDetailActivityBindingImpl(android.databinding.DataBindingComponent bindingComponent, View root, Object[] bindings) {
        super(bindingComponent, root, 0
            , (android.widget.ImageView) bindings[1]
            , (android.widget.TextView) bindings[2]
            );
        this.image.setTag(null);
        this.mboundView0 = (android.widget.RelativeLayout) bindings[0];
        this.mboundView0.setTag(null);
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
        if (BR.photoDetailViewModel == variableId) {
            setPhotoDetailViewModel((com.smartmobe.photoalbummvvm.viewmodel.PhotoDetailViewModel) variable);
        }
        else {
            variableSet = false;
        }
            return variableSet;
    }

    public void setPhotoDetailViewModel(@Nullable com.smartmobe.photoalbummvvm.viewmodel.PhotoDetailViewModel PhotoDetailViewModel) {
        this.mPhotoDetailViewModel = PhotoDetailViewModel;
        synchronized(this) {
            mDirtyFlags |= 0x1L;
        }
        notifyPropertyChanged(BR.photoDetailViewModel);
        super.requestRebind();
    }

    @Override
    protected boolean onFieldChange(int localFieldId, Object object, int fieldId) {
        switch (localFieldId) {
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
        com.smartmobe.photoalbummvvm.viewmodel.PhotoDetailViewModel photoDetailViewModel = mPhotoDetailViewModel;
        java.lang.String photoDetailViewModelTitle = null;
        java.lang.String photoDetailViewModelImageUrl = null;

        if ((dirtyFlags & 0x3L) != 0) {



                if (photoDetailViewModel != null) {
                    // read photoDetailViewModel.title
                    photoDetailViewModelTitle = photoDetailViewModel.getTitle();
                    // read photoDetailViewModel.imageUrl
                    photoDetailViewModelImageUrl = photoDetailViewModel.getImageUrl();
                }
        }
        // batch finished
        if ((dirtyFlags & 0x3L) != 0) {
            // api target 1

            com.smartmobe.photoalbummvvm.viewmodel.PhotoDetailViewModel.loadImage(this.image, photoDetailViewModelImageUrl);
            android.databinding.adapters.TextViewBindingAdapter.setText(this.title, photoDetailViewModelTitle);
        }
    }
    // Listener Stub Implementations
    // callback impls
    // dirty flag
    private  long mDirtyFlags = 0xffffffffffffffffL;
    /* flag mapping
        flag 0 (0x1L): photoDetailViewModel
        flag 1 (0x2L): null
    flag mapping end*/
    //end
}