package com.example.gallery_art.model

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes

data class model(
    @DrawableRes val imageArt: Int = 0,
    @StringRes val location: Int = 0,
    @StringRes val author: Int = 0
)