package com.sharmadhiraj.photoalbummvvm.view

import com.sharmadhiraj.photoalbummvvm.model.Photo

interface PhotoActions {
    fun onOpen(photo: Photo)
    fun onToggleFavorite(photo: Photo)
}
