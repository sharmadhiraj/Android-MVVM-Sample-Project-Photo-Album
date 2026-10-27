package com.sharmadhiraj.photoalbummvvm.view

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.IntentCompat
import androidx.databinding.DataBindingUtil
import com.sharmadhiraj.photoalbummvvm.R
import com.sharmadhiraj.photoalbummvvm.app.PhotoAlbumApplication
import com.sharmadhiraj.photoalbummvvm.databinding.ActivityPhotoDetailBinding
import com.sharmadhiraj.photoalbummvvm.model.Photo
import com.sharmadhiraj.photoalbummvvm.viewmodel.PhotoDetailViewModel
import com.sharmadhiraj.photoalbummvvm.viewmodel.photoDetailFactory

class PhotoDetailActivity : AppCompatActivity() {

    private val viewModel: PhotoDetailViewModel by viewModels {
        val photo = IntentCompat.getSerializableExtra(intent, EXTRA_PHOTO, Photo::class.java)!!
        photoDetailFactory(photo, (application as PhotoAlbumApplication).repository)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = DataBindingUtil.setContentView<ActivityPhotoDetailBinding>(this, R.layout.activity_photo_detail)
        binding.viewModel = viewModel
        binding.lifecycleOwner = this
        binding.toolbar.setNavigationOnClickListener { finish() }
    }

    companion object {
        private const val EXTRA_PHOTO = "photo"

        fun intent(context: Context, photo: Photo) =
            Intent(context, PhotoDetailActivity::class.java).putExtra(EXTRA_PHOTO, photo)
    }
}
