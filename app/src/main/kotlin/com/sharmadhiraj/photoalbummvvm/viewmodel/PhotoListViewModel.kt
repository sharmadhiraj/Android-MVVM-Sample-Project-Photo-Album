package com.sharmadhiraj.photoalbummvvm.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MediatorLiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.sharmadhiraj.photoalbummvvm.data.PhotoRepository
import com.sharmadhiraj.photoalbummvvm.data.PicsumApi
import com.sharmadhiraj.photoalbummvvm.model.Photo
import com.sharmadhiraj.photoalbummvvm.model.PhotoItem

class PhotoListViewModel(private val repository: PhotoRepository) : ViewModel() {

    private val loaded = MutableLiveData<List<Photo>>(emptyList())
    private val _query = MutableLiveData("")
    private val _favoritesOnly = MutableLiveData(false)
    private val _isRefreshing = MutableLiveData(false)
    private val _isLoadingMore = MutableLiveData(false)
    private val _hasError = MutableLiveData(false)
    private var nextPage = 1
    private var isLastPage = false
    private var isBusy = false

    val favoritesOnly: LiveData<Boolean> = _favoritesOnly
    val isRefreshing: LiveData<Boolean> = _isRefreshing
    val isLoadingMore: LiveData<Boolean> = _isLoadingMore
    val hasError: LiveData<Boolean> = _hasError

    val items = MediatorLiveData<List<PhotoItem>>().apply {
        val combine = { value = filteredItems() }
        listOf(loaded, _query, _favoritesOnly, repository.favoriteIds).forEach { addSource(it) { combine() } }
    }

    val isEmpty = MediatorLiveData<Boolean>().apply {
        val combine = { value = items.value.isNullOrEmpty() && !isBusy && _hasError.value == false }
        listOf(items, _isRefreshing, _isLoadingMore, _hasError).forEach { addSource(it) { combine() } }
    }

    init {
        loadNextPage()
    }

    fun onEndReached() {
        if (_query.value.isNullOrBlank() && _favoritesOnly.value != true) loadNextPage()
    }

    fun loadNextPage() {
        if (isBusy || isLastPage) return
        isBusy = true
        _isRefreshing.value = nextPage == 1
        _isLoadingMore.value = nextPage > 1
        _hasError.value = false
        repository.loadPhotos(nextPage) { result ->
            isBusy = false
            _isRefreshing.value = false
            _isLoadingMore.value = false
            result.onSuccess { photos ->
                nextPage++
                isLastPage = photos.size < PicsumApi.PAGE_SIZE
                loaded.value = loaded.value.orEmpty() + photos
            }.onFailure { _hasError.value = true }
        }
    }

    fun refresh() {
        if (isBusy) return
        nextPage = 1
        isLastPage = false
        loaded.value = emptyList()
        loadNextPage()
    }

    fun search(query: String) {
        _query.value = query
    }

    fun toggleFavoritesOnly() {
        _favoritesOnly.value = _favoritesOnly.value != true
    }

    fun toggleFavorite(photo: Photo) = repository.toggleFavorite(photo.id)

    private fun filteredItems(): List<PhotoItem> {
        val favorites = repository.favoriteIds.value.orEmpty()
        val query = _query.value.orEmpty().trim()
        return loaded.value.orEmpty()
            .filter { query.isEmpty() || it.author.contains(query, ignoreCase = true) }
            .map { PhotoItem(it, it.id in favorites) }
            .filter { _favoritesOnly.value != true || it.isFavorite }
    }
}
