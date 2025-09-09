package com.example.gallery_art.ui.theme

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import com.example.gallery_art.R
import com.example.gallery_art.data.dataList
import com.example.gallery_art.model.model

data class GalleryArtUiState(
    val index: Int = 0,
    @DrawableRes val imageArt: Int = dataList[index].imageArt,
    val artLocation: Int = dataList[index].location,
    val artAuthor: Int = dataList[index].author,
)