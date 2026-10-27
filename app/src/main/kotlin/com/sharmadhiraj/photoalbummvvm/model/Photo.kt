package com.sharmadhiraj.photoalbummvvm.model

import java.io.Serializable

data class Photo(
    val id: Int,
    val author: String,
    val width: Int,
    val height: Int,
) : Serializable {
    val thumbnailUrl get() = "https://picsum.photos/id/$id/400/300"
    val imageUrl get() = "https://picsum.photos/id/$id/1080/810"
    val sizeLabel get() = "$width x $height"
    val caption get() = "#$id · $sizeLabel"
}
