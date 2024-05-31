package com.example.myapplication.model

import androidx.annotation.DrawableRes

data class Categories(
    val id: Int,
    @DrawableRes var image: Int,
    val title: String
)
