package com.sharmadhiraj.photoalbummvvm.data

import android.content.Context
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData

class FavoriteStore(context: Context) {

    private val prefs = context.getSharedPreferences("favorites", Context.MODE_PRIVATE)
    private val _ids = MutableLiveData(prefs.getStringSet(KEY, emptySet())!!.map(String::toInt).toSet())

    val ids: LiveData<Set<Int>> = _ids

    fun toggle(photoId: Int) {
        val current = _ids.value.orEmpty()
        val updated = if (photoId in current) current - photoId else current + photoId
        prefs.edit().putStringSet(KEY, updated.map(Int::toString).toSet()).apply()
        _ids.value = updated
    }

    private companion object {
        const val KEY = "ids"
    }
}
