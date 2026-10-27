package com.sharmadhiraj.photoalbummvvm.view

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.SearchView
import androidx.activity.viewModels
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.sharmadhiraj.photoalbummvvm.R
import com.sharmadhiraj.photoalbummvvm.app.PhotoAlbumApplication
import com.sharmadhiraj.photoalbummvvm.databinding.ActivityPhotoListBinding
import com.sharmadhiraj.photoalbummvvm.model.Photo
import com.sharmadhiraj.photoalbummvvm.viewmodel.PhotoListViewModel
import com.sharmadhiraj.photoalbummvvm.viewmodel.photoListFactory

class PhotoListActivity : AppCompatActivity(), PhotoActions {

    private val viewModel: PhotoListViewModel by viewModels {
        photoListFactory((application as PhotoAlbumApplication).repository)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = DataBindingUtil.setContentView<ActivityPhotoListBinding>(this, R.layout.activity_photo_list)
        binding.viewModel = viewModel
        binding.lifecycleOwner = this

        val adapter = PhotoAdapter(this)
        binding.photoList.adapter = adapter
        binding.photoList.addOnScrollListener(EndOfListListener(viewModel::onEndReached))
        viewModel.items.observe(this, adapter::submitList)

        setUpMenu(binding)
    }

    private fun setUpMenu(binding: ActivityPhotoListBinding) = with(binding.toolbar) {
        inflateMenu(R.menu.photo_list)
        val favoritesItem = menu.findItem(R.id.action_favorites)
        viewModel.favoritesOnly.observe(this@PhotoListActivity) {
            favoritesItem.setIcon(if (it) R.drawable.ic_favorite else R.drawable.ic_favorite_border)
        }
        setOnMenuItemClickListener {
            if (it.itemId == R.id.action_favorites) viewModel.toggleFavoritesOnly()
            it.itemId == R.id.action_favorites
        }
        (menu.findItem(R.id.action_search).actionView as SearchView)
            .setOnQueryTextListener(object : SearchView.OnQueryTextListener {
                override fun onQueryTextSubmit(query: String) = true
                override fun onQueryTextChange(newText: String): Boolean {
                    viewModel.search(newText)
                    return true
                }
            })
    }

    override fun onOpen(photo: Photo) = startActivity(PhotoDetailActivity.intent(this, photo))

    override fun onToggleFavorite(photo: Photo) = viewModel.toggleFavorite(photo)

    private class EndOfListListener(private val onEnd: () -> Unit) : RecyclerView.OnScrollListener() {
        override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {
            val layoutManager = recyclerView.layoutManager as GridLayoutManager
            if (layoutManager.findLastVisibleItemPosition() >= layoutManager.itemCount - PREFETCH_DISTANCE) onEnd()
        }

        private companion object {
            const val PREFETCH_DISTANCE = 6
        }
    }
}
