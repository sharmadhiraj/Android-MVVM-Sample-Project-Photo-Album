package com.smartmobe.photoalbummvvm.databinding;
import com.smartmobe.photoalbummvvm.R;
import com.smartmobe.photoalbummvvm.BR;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.View;
@SuppressWarnings("unchecked")
public class HomeBindingImpl extends HomeBinding  {

    @Nullable
    private static final android.databinding.ViewDataBinding.IncludedLayouts sIncludes;
    @Nullable
    private static final android.util.SparseIntArray sViewsWithIds;
    static {
        sIncludes = null;
        sViewsWithIds = new android.util.SparseIntArray();
        sViewsWithIds.put(R.id.listPhoto, 3);
    }
    // views
    @NonNull
    private final android.widget.RelativeLayout mboundView0;
    // variables
    // values
    // listeners
    // Inverse Binding Event Handlers

    public HomeBindingImpl(@Nullable android.databinding.DataBindingComponent bindingComponent, @NonNull View root) {
        this(bindingComponent, root, mapBindings(bindingComponent, root, 4, sIncludes, sViewsWithIds));
    }
    private HomeBindingImpl(android.databinding.DataBindingComponent bindingComponent, View root, Object[] bindings) {
        super(bindingComponent, root, 2
            , (android.widget.TextView) bindings[2]
            , (android.support.v7.widget.RecyclerView) bindings[3]
            , (android.widget.ProgressBar) bindings[1]
            );
        this.labelStatus.setTag(null);
        this.mboundView0 = (android.widget.RelativeLayout) bindings[0];
        this.mboundView0.setTag(null);
        this.progressPhoto.setTag(null);
        setRootTag(root);
        // listeners
        invalidateAll();
    }

    @Override
    public void invalidateAll() {
        synchronized(this) {
                mDirtyFlags = 0x8L;
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
        if (BR.photoViewModel == variableId) {
            setPhotoViewModel((com.smartmobe.photoalbummvvm.viewmodel.PhotoViewModel) variable);
        }
        else {
            variableSet = false;
        }
            return variableSet;
    }

    public void setPhotoViewModel(@Nullable com.smartmobe.photoalbummvvm.viewmodel.PhotoViewModel PhotoViewModel) {
        this.mPhotoViewModel = PhotoViewModel;
        synchronized(this) {
            mDirtyFlags |= 0x4L;
        }
        notifyPropertyChanged(BR.photoViewModel);
        super.requestRebind();
    }

    @Override
    protected boolean onFieldChange(int localFieldId, Object object, int fieldId) {
        switch (localFieldId) {
            case 0 :
                return onChangePhotoViewModelPhotoProgress((android.databinding.ObservableInt) object, fieldId);
            case 1 :
                return onChangePhotoViewModelMessageLabel((android.databinding.ObservableField<java.lang.String>) object, fieldId);
        }
        return false;
    }
    private boolean onChangePhotoViewModelPhotoProgress(android.databinding.ObservableInt PhotoViewModelPhotoProgress, int fieldId) {
        if (fieldId == BR._all) {
            synchronized(this) {
                    mDirtyFlags |= 0x1L;
            }
            return true;
        }
        return false;
    }
    private boolean onChangePhotoViewModelMessageLabel(android.databinding.ObservableField<java.lang.String> PhotoViewModelMessageLabel, int fieldId) {
        if (fieldId == BR._all) {
            synchronized(this) {
                    mDirtyFlags |= 0x2L;
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
        com.smartmobe.photoalbummvvm.viewmodel.PhotoViewModel photoViewModel = mPhotoViewModel;
        int photoViewModelPhotoProgressGet = 0;
        android.databinding.ObservableInt photoViewModelPhotoProgress = null;
        java.lang.String photoViewModelMessageLabelGet = null;
        android.databinding.ObservableField<java.lang.String> photoViewModelMessageLabel = null;

        if ((dirtyFlags & 0xfL) != 0) {


            if ((dirtyFlags & 0xdL) != 0) {

                    if (photoViewModel != null) {
                        // read photoViewModel.photoProgress
                        photoViewModelPhotoProgress = photoViewModel.photoProgress;
                    }
                    updateRegistration(0, photoViewModelPhotoProgress);


                    if (photoViewModelPhotoProgress != null) {
                        // read photoViewModel.photoProgress.get()
                        photoViewModelPhotoProgressGet = photoViewModelPhotoProgress.get();
                    }
            }
            if ((dirtyFlags & 0xeL) != 0) {

                    if (photoViewModel != null) {
                        // read photoViewModel.messageLabel
                        photoViewModelMessageLabel = photoViewModel.messageLabel;
                    }
                    updateRegistration(1, photoViewModelMessageLabel);


                    if (photoViewModelMessageLabel != null) {
                        // read photoViewModel.messageLabel.get()
                        photoViewModelMessageLabelGet = photoViewModelMessageLabel.get();
                    }
            }
        }
        // batch finished
        if ((dirtyFlags & 0xeL) != 0) {
            // api target 1

            android.databinding.adapters.TextViewBindingAdapter.setText(this.labelStatus, photoViewModelMessageLabelGet);
        }
        if ((dirtyFlags & 0xdL) != 0) {
            // api target 1

            this.progressPhoto.setVisibility(photoViewModelPhotoProgressGet);
        }
    }
    // Listener Stub Implementations
    // callback impls
    // dirty flag
    private  long mDirtyFlags = 0xffffffffffffffffL;
    /* flag mapping
        flag 0 (0x1L): photoViewModel.photoProgress
        flag 1 (0x2L): photoViewModel.messageLabel
        flag 2 (0x3L): photoViewModel
        flag 3 (0x4L): null
    flag mapping end*/
    //end
}