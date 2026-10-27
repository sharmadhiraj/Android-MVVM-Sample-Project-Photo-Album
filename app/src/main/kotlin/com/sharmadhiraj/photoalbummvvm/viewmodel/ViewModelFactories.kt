package com.sharmadhiraj.photoalbummvvm.viewmodel

import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory
import com.sharmadhiraj.photoalbummvvm.data.PhotoRepository
import com.sharmadhiraj.photoalbummvvm.model.Photo

fun photoListFactory(repository: PhotoRepository): ViewModelProvider.Factory = viewModelFactory {
    initializer { PhotoListViewModel(repository) }
}

fun photoDetailFactory(photo: Photo, repository: PhotoRepository): ViewModelProvider.Factory = viewModelFactory {
    initializer { PhotoDetailViewModel(photo, repository) }
}
