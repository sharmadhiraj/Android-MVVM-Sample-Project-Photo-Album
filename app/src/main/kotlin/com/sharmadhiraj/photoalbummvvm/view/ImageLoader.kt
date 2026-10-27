package com.sharmadhiraj.photoalbummvvm.view

import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.os.Handler
import android.os.Looper
import android.util.LruCache
import android.widget.ImageView
import com.sharmadhiraj.photoalbummvvm.data.PicsumApi
import java.util.concurrent.Executors

object ImageLoader {

    private const val CACHE_FRACTION = 8
    private const val FADE_MS = 200L

    private val cache = object : LruCache<String, Bitmap>((Runtime.getRuntime().maxMemory() / CACHE_FRACTION).toInt()) {
        override fun sizeOf(key: String, bitmap: Bitmap) = bitmap.byteCount
    }
    private val background = Executors.newFixedThreadPool(4)
    private val mainThread = Handler(Looper.getMainLooper())

    fun load(view: ImageView, url: String?, placeholderUrl: String? = null) {
        view.tag = url
        val cached = url?.let(cache::get)
        if (cached != null) {
            view.setImageBitmap(cached)
            return
        }
        view.setImageBitmap(placeholderUrl?.let(cache::get))
        if (url == null) return
        background.execute {
            val bytes = runCatching { PicsumApi.fetchBytes(url) }.getOrNull() ?: return@execute
            val bitmap = BitmapFactory.decodeByteArray(bytes, 0, bytes.size) ?: return@execute
            cache.put(url, bitmap)
            mainThread.post { if (view.tag == url) show(view, bitmap) }
        }
    }

    private fun show(view: ImageView, bitmap: Bitmap) {
        view.setImageBitmap(bitmap)
        view.alpha = 0f
        view.animate().alpha(1f).setDuration(FADE_MS)
    }
}
