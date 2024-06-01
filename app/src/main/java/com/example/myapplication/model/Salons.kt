package com.example.myapplication.model

import androidx.annotation.DrawableRes

data class Salons(
    val id: Int,
    val categoryId: Int,
    @DrawableRes var image: Int,
    val title: String,
    val grade: String,
    val address: String,
    val listOfServices: List<Service>
)


