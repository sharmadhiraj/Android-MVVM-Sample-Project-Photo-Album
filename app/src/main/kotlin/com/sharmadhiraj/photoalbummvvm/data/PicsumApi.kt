package com.sharmadhiraj.photoalbummvvm.data

import com.sharmadhiraj.photoalbummvvm.model.Photo
import org.json.JSONArray
import java.net.HttpURLConnection
import java.net.URL

object PicsumApi {

    const val PAGE_SIZE = 20
    private const val LIST_URL = "https://picsum.photos/v2/list?page=%d&limit=$PAGE_SIZE"

    fun fetchPhotos(page: Int): List<Photo> {
        val json = JSONArray(download(LIST_URL.format(page)))
        return List(json.length()) {
            with(json.getJSONObject(it)) {
                Photo(getString("id").toInt(), getString("author"), getInt("width"), getInt("height"))
            }
        }
    }

    fun fetchBytes(url: String) = download(url) { it.readBytes() }

    private fun download(url: String) = download(url) { it.readBytes().decodeToString() }

    private fun <T> download(url: String, read: (java.io.InputStream) -> T): T {
        val connection = URL(url).openConnection() as HttpURLConnection
        connection.connectTimeout = TIMEOUT_MS
        connection.readTimeout = TIMEOUT_MS
        return try {
            connection.inputStream.use(read)
        } finally {
            connection.disconnect()
        }
    }

    private const val TIMEOUT_MS = 10_000
}
