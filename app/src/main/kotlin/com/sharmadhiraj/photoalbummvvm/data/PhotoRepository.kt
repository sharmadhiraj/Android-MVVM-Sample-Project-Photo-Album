package com.sharmadhiraj.photoalbummvvm.data

import android.os.Handler
import android.os.Looper
import com.sharmadhiraj.photoalbummvvm.model.Photo
import java.util.concurrent.Executors

class PhotoRepository(private val favoriteStore: FavoriteStore) {

    private val background = Executors.newSingleThreadExecutor()
    private val mainThread = Handler(Looper.getMainLooper())

    val favoriteIds = favoriteStore.ids

    fun toggleFavorite(photoId: Int) = favoriteStore.toggle(photoId)

    fun loadPhotos(page: Int, onResult: (Result<List<Photo>>) -> Unit) {
        background.execute {
            val result = runCatching { PicsumApi.fetchPhotos(page) }
            mainThread.post { onResult(result) }
        }
    }
}
