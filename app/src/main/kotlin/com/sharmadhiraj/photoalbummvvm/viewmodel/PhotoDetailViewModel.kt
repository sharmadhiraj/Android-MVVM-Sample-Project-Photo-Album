package com.sharmadhiraj.photoalbummvvm.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.map
import com.sharmadhiraj.photoalbummvvm.data.PhotoRepository
import com.sharmadhiraj.photoalbummvvm.model.Photo

class PhotoDetailViewModel(val photo: Photo, private val repository: PhotoRepository) : ViewModel() {

    val isFavorite = repository.favoriteIds.map { photo.id in it }

    fun toggleFavorite() = repository.toggleFavorite(photo.id)
}
