package com.sharmadhiraj.photoalbummvvm.app

import android.app.Application
import com.sharmadhiraj.photoalbummvvm.data.FavoriteStore
import com.sharmadhiraj.photoalbummvvm.data.PhotoRepository

class PhotoAlbumApplication : Application() {

    val repository by lazy { PhotoRepository(FavoriteStore(this)) }
}
